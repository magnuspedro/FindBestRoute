package br.magnus.readeble.usecase

import br.magnus.readeble.gateway.database.VehicleServices
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateVehicle(
    private val createVehicleFromCsv: ConvertVehicleFromCsv

) {
    @Inject
    private lateinit var vehicleServices: VehicleServices

    fun create(vehicle: String) {
        val vehicles = createVehicleFromCsv.create(vehicle)
        vehicleServices.add(vehicles)
    }
}