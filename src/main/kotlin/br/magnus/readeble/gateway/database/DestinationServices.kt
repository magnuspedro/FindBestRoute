package br.magnus.readeble.gateway.database

import br.magnus.readeble.domain.entities.Destination
import br.magnus.readeble.domain.entities.Route
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters.and
import com.mongodb.client.model.Filters.eq
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class DestinationServices {
    @Inject
    lateinit var mongoClient: MongoClient

    fun add(routes: List<Route>) {
        routes.forEach {
            getCollection().find(
                and(eq("destination", it.destination), eq("weight", it.weight))
            ).toList().takeIf { it.isNotEmpty() } ?: getCollection().insertOne(
                Destination(
                    destination = it.destination,
                    destinationState = it.destinationState,
                    destinationLatitude = it.destinationLatitude,
                    destinationLongitude = it.destinationLongitude,
                    weight = it.weight,
                    loadType = it.loadType
                )
            )
        }

    }

    private fun getCollection(): MongoCollection<Destination> {
        return mongoClient.getDatabase("route").getCollection("destination", Destination::class.java)
    }
}