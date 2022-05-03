package br.magnus.readeble.domain.entities

data class Destination(
    val destination: String? = null,
    val destinationState: String? = null,
    var destinationLatitude: Double? = null,
    var destinationLongitude: Double? = null,
    val loadType: Type? = null,
    val weight: Double? = null
)