package br.magnus.readeble.exceptions

import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class UnprocessableEntityExceptionHandler : ExceptionMapper<UnprocessableEntityException> {
    override fun toResponse(exception: UnprocessableEntityException): Response {
        return Response.status(422).entity(exception.message).header("Access-Control-Allow-Origin", "*").build()
    }

}