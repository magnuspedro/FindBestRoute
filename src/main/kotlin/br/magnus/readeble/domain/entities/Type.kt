package br.magnus.readeble.domain.entities

import com.fasterxml.jackson.annotation.JsonValue

enum class Type(@JsonValue val tipo: String) {
    GRANEL("Granel"),
    SECA("Seca"),
    SOLTA("Solta")
}