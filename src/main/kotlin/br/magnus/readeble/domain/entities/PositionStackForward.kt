package br.magnus.readeble.domain.entities

import com.fasterxml.jackson.annotation.JsonProperty

data class PositionStackForward(
    @JsonProperty("data")
    val data: List<GeoLocation>
)

data class GeoLocation(
    @JsonProperty("latitude")
    val latitude: Double,
    @JsonProperty("longitude")
    val longitude: Double
)
