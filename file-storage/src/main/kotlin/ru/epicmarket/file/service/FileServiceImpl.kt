package ru.epicmarket.file.service

import org.slf4j.LoggerFactory
import org.springframework.web.multipart.MultipartFile
import ru.epicmarket.file.model.FileEntity
import ru.epicmarket.file.model.MetaInfo
import ru.epicmarket.file.model.Size
import ru.epicmarket.file.repository.FileRepository
import java.awt.Image
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.*
import javax.imageio.ImageIO


private val log = LoggerFactory.getLogger(FileServiceImpl::class.java.name)

class FileServiceImpl(private val repository: FileRepository) : FileService {

    override fun getFile(id: Long): ByteArray {
        log.info("getFile request id: $id")
        val fileEntity = repository.findById(id).get()
        return fileEntity.file
    }

    override fun getMetaInfo(id: Long): MetaInfo {
        log.info("getMetaInfo request id: $id")
        val fileEntity = repository.findById(id).get()
        return MetaInfo(fileEntity.id, fileEntity.size, fileEntity.creationDate)
    }

    override fun getPreview(id: Long, size: String): ByteArray {
        log.info("getPreview request id: $id, size: $size")
        val sizeParsed = parseSize(size)
        val fileEntity = repository.findById(id).get()
        val bufferedImage = ImageIO.read(ByteArrayInputStream(fileEntity.file))

        val scaledImage = bufferedImage.getScaledInstance(sizeParsed.width, sizeParsed.height, Image.SCALE_DEFAULT)
        val outputImage = BufferedImage(sizeParsed.width, sizeParsed.height, BufferedImage.TYPE_INT_RGB)
        outputImage.graphics.drawImage(scaledImage, 0, 0, null)
        val output = ByteArrayOutputStream()
        ImageIO.write(outputImage, "jpg", output)
        return output.toByteArray()
    }

    override fun uploadFile(file: MultipartFile): MetaInfo {
        log.info("uploadFile request. File size: ${file.size}")
        val img = ImageIO.read(file.inputStream)
        val size = Size(img.width, img.height)
        val fileEntity = FileEntity(size, Date(), file.bytes)
        val savedEntity = repository.save(fileEntity)
        return MetaInfo(savedEntity.id, size, savedEntity.creationDate)
    }

    private fun parseSize(size: String): Size {
        try {
            val delimiter = size.indexOf('x')
            val width = size.substring(0, delimiter)
            val height = size.substring(delimiter + 1)
            return Size(Integer.parseInt(width), Integer.parseInt(height))
        } catch (e: Exception) {
            log.error("Error in size parsing", e)
            throw IllegalArgumentException("Size should be in format [width]x[height]")
        }
    }
}