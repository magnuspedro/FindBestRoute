package br.magnus.vehicle.exceptions

data class ErrorResponse(
    val errorId: String? = null,
    val errors: List<ErrorMessage>? = null
) {
    companion object {
        data class ErrorMessage(
            private val path: String? = null,
            private val message: String? = null
        )
    }
}
