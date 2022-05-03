package br.magnus.readeble.exceptions

import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class ServiceUnavailableErrorExceptionHandler : ExceptionMapper<ServiceUnavailableException> {
    override fun toResponse(exception: ServiceUnavailableException): Response {
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(exception.message).build()
    }

}