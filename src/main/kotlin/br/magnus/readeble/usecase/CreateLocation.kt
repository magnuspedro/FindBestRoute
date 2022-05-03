package br.magnus.readeble.usecase

import br.magnus.readeble.gateway.database.DestinationServices
import br.magnus.readeble.gateway.database.OriginServices
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateLocation(
    private val convertRouteFromCsv: ConvertRouteFromCsv,
    private val findGeoLocation: FindGeoLocation
) {
    @Inject
    private lateinit var originServices: OriginServices

    @Inject
    private lateinit var destinationServices: DestinationServices

    fun create(route: String) {
        val routes = convertRouteFromCsv.create(route)
        routes.parallelStream().forEach {
            val location = findGeoLocation.find("${it.origin}, ${it.originState}")
            it.originLatitude = location.latitude
            it.originLongitude = location.longitude
        }
        routes.parallelStream().forEach {
            val location = findGeoLocation.find("${it.destination}, ${it.destinationState}")
            it.destinationLatitude = location.latitude
            it.destinationLongitude = location.longitude
        }

        originServices.add(routes)
        destinationServices.add(routes)

    }
}