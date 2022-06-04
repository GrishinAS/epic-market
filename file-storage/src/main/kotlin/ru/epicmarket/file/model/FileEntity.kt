package ru.epicmarket.file.model


import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.MappedCollection
import java.util.*

data class FileEntity(
    val size: Size,
    @MappedCollection(idColumn = "id")
    val creationDate: Date,
    val file: ByteArray,
    @Id val id: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FileEntity

        if (size != other.size) return false
        if (creationDate != other.creationDate) return false
        if (!file.contentEquals(other.file)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = size.hashCode()
        result = 31 * result + creationDate.hashCode()
        result = 31 * result + file.contentHashCode()
        return result
    }

    override fun toString(): String {
        return "FileEntity(size=$size, creationDate=$creationDate, id=$id)"
    }
}
