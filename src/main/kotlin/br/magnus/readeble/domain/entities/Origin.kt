package br.magnus.readeble.domain.entities

data class Origin(
    val origin: String? = null,
    val originState: String? = null,
    var originLatitude: Double? = null,
    var originLongitude: Double? = null,
)
