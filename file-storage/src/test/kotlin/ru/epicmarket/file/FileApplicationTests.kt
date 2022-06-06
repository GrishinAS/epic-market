package ru.epicmarket.file

import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import ru.epicmarket.file.repository.FileRepository

@SpringBootTest
@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration::class,
	DataSourceTransactionManagerAutoConfiguration::class]
)
class FileApplicationTests {

	@MockBean
	lateinit var fileRepository: FileRepository

	@Test
	fun contextLoads() {
	}

}
