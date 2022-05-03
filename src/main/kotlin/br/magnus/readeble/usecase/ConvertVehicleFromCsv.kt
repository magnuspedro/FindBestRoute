package br.magnus.readeble.usecase

import br.magnus.readeble.domain.entities.Route
import br.magnus.readeble.domain.entities.Vehicle
import br.magnus.readeble.domain.reader.CsvReaderConverter
import br.magnus.readeble.exceptions.UnprocessableEntityException
import javax.inject.Singleton

@Singleton
class ConvertVehicleFromCsv(
    private val csvReaderConverter: CsvReaderConverter<Vehicle>,
) {

    fun create(vehicle: String?): List<Vehicle> {
        vehicle?.takeIf { it.isNotBlank() } ?: throw UnprocessableEntityException("Vehicle should not be empty")
        return csvReaderConverter.read(vehicle, Vehicle::class.java)
    }
}
