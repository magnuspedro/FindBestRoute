package br.magnus.readeble.gateway.database

import br.magnus.readeble.domain.entities.Vehicle
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters.eq
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class VehicleServices {
    @Inject
    lateinit var mongoClient: MongoClient

    fun add(vehicles: List<Vehicle>) {
        vehicles.forEach {
            getCollection().find(eq("plate", it.plate)).toList().takeIf { it.isNotEmpty() }
                ?: getCollection().insertOne(it)
        }
    }

    private fun getCollection(): MongoCollection<Vehicle> {
        return mongoClient.getDatabase("route").getCollection("vehicle", Vehicle::class.java)
    }
}