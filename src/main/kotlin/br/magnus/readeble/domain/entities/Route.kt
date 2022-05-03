package br.magnus.readeble.domain.entities

import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("origin", "originState", "destination", "destinationState", "loadType", "weight")
data class Route(
    val origin: String? = null,
    val originState: String? = null,
    var originLatitude: Double? = null,
    var originLongitude: Double? = null,
    val destination: String? = null,
    val destinationState: String? = null,
    var destinationLatitude: Double? = null,
    var destinationLongitude: Double? = null,
    val loadType: Type? = null,
    val weight: Double? = null
)
