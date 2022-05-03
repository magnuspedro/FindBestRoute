package br.magnus.readeble.domain.entities

import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("plate", "capacity", "type", "consumption")
data class Vehicle(
    val plate: String? = null,
    val capacity: String? = null,
    val type: String? = null,
    val consumption: String? = null
)