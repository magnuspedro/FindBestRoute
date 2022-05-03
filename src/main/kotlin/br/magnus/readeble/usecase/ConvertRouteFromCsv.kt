package br.magnus.readeble.usecase

import br.magnus.readeble.domain.entities.Route
import br.magnus.readeble.domain.reader.CsvReaderConverter
import br.magnus.readeble.exceptions.UnprocessableEntityException
import javax.inject.Singleton

@Singleton
class ConvertRouteFromCsv(
    private val csvReaderConverter: CsvReaderConverter<Route>,
) {

    fun create(route: String?): List<Route> {
        route?.takeIf { it.isNotBlank() } ?: throw UnprocessableEntityException("Route should not be empty")
        return csvReaderConverter.read(route, Route::class.java)
    }
}