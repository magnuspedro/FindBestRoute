package br.magnus.readeble.usecase

import br.magnus.readeble.exceptions.UnprocessableEntityException
import javax.inject.Singleton

@Singleton
class DiscoverType(
    private val createLocation: CreateLocation,
    private val createVehicle: CreateVehicle
) {
    fun discover(message: String) {
        val firstHeader = message.split(",")
        when (firstHeader[0]) {
            "Origem" -> createLocation.create(message)
            "Placa" -> createVehicle.create(message)
            else -> {
                throw UnprocessableEntityException("Invalid CSV file")
            }
        }
    }
}