package ru.epicmarket.file.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import ru.epicmarket.file.service.FileService


@RestController
@RequestMapping("/file")
class FilesController(val fileService: FileService) {


    @GetMapping("/{id}", produces = [MediaType.IMAGE_JPEG_VALUE])
    fun getFile(@PathVariable id: Long) =
        fileService.getFile(id)

    @PostMapping
    fun uploadFile(@RequestParam file: MultipartFile) =
        fileService.uploadFile(file)

    @GetMapping("/{id}/meta_info")
    fun getMetaInfo(@PathVariable id: Long) =
        fileService.getMetaInfo(id)

    @GetMapping("/{id}/preview/{size}", produces = [MediaType.IMAGE_JPEG_VALUE])
    fun getPreview(@PathVariable id: Long, @PathVariable size: String) =
        fileService.getPreview(id, size)

}