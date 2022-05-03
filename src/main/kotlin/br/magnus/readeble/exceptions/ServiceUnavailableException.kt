package br.magnus.readeble.exceptions

import java.io.Serializable

class ServiceUnavailableException : Exception, Serializable {
    constructor(message: String) : super(message)

    constructor(message: String, exception: Exception) : super(message, exception)

    constructor(exception: Exception) : super(exception)

    companion object {
        private const val serialVersionUID = 1L
    }
}