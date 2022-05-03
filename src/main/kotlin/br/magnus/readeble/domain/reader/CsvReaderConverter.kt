package br.magnus.readeble.domain.reader

import br.magnus.readeble.domain.entities.Route
import br.magnus.readeble.exceptions.UnprocessableEntityException
import com.fasterxml.jackson.databind.MappingIterator
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class CsvReaderConverter<T> {

    private val log = LoggerFactory.getLogger(javaClass)

    fun read(csv: String, clazz: Class<T>): List<T> {
        val mapper = CsvMapper()
        val schema = mapper.typedSchemaFor(clazz).withHeader()
        try {
            val mappedIterator: MappingIterator<T> = mapper.readerFor(clazz)
                .with(schema.withColumnSeparator(','))
                .readValues(csv)
            return mappedIterator.readAll()
        } catch (e: InvalidFormatException) {
            log.error("Invalid CSV $e")
            throw UnprocessableEntityException("Invalid CSV format")
        }
    }
}