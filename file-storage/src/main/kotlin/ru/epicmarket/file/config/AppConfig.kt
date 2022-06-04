package ru.epicmarket.file.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.epicmarket.file.repository.FileRepository
import ru.epicmarket.file.service.FileService
import ru.epicmarket.file.service.FileServiceImpl

@Configuration
class AppConfig {

    @Bean
    fun fileService(repository: FileRepository) : FileService = FileServiceImpl(repository)
}