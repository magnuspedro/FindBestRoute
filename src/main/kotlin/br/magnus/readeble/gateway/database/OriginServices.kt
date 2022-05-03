package br.magnus.readeble.gateway.database

import br.magnus.readeble.domain.entities.Origin
import br.magnus.readeble.domain.entities.Route
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters.and
import com.mongodb.client.model.Filters.eq
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class OriginServices {
    @Inject
    lateinit var mongoClient: MongoClient

    fun add(routes: List<Route>) {
        routes.forEach {
            getCollection().find(
                and(eq("origin", it.origin))
            ).toList().takeIf { it.isNotEmpty() } ?: getCollection().insertOne(
                Origin(
                    origin = it.origin,
                    originState = it.originState,
                    originLatitude = it.originLatitude,
                    originLongitude = it.originLongitude
                )
            )
        }

    }

    private fun getCollection(): MongoCollection<Origin> {
        return mongoClient.getDatabase("route").getCollection("origin", Origin::class.java)
    }
}