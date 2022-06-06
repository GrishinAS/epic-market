package ru.epicmarket.file.service

import org.springframework.web.multipart.MultipartFile
import ru.epicmarket.file.model.MetaInfo

interface FileService {
    fun getFile(id: Long): ByteArray?
    fun getMetaInfo(id: Long): Any
    fun getPreview(id: Long, size: String): ByteArray
    fun uploadFile(file: MultipartFile): MetaInfo

}