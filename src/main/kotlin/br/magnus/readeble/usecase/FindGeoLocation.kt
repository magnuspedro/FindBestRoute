package br.magnus.readeble.usecase

import br.magnus.readeble.domain.entities.GeoLocation
import br.magnus.readeble.exceptions.ServiceUnavailableException
import br.magnus.readeble.gateway.request.PositionStack
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FindGeoLocation {

    @Inject
    @field: RestClient
    internal lateinit var positionStack: PositionStack

    @field:ConfigProperty(name = "quarkus.rest-client.position-stack.apikey")
    lateinit var apiKey: String

    fun find(location: String): GeoLocation {
        try {
            val getLocation = positionStack.getLocation(apiKey, location)
            return GeoLocation(getLocation.data[0].latitude, getLocation.data[0].longitude)
        } catch (e: Exception) {
            throw ServiceUnavailableException("Service for getting GeoLocation is not working")
        }
    }
}