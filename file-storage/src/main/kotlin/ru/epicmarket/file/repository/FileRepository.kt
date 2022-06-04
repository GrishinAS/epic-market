package ru.epicmarket.file.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.epicmarket.file.model.FileEntity

@Repository
interface FileRepository : CrudRepository<FileEntity, Long>