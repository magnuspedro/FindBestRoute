package br.magnus.readeble.gateway.request

import br.magnus.readeble.domain.entities.PositionStackForward
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.annotations.jaxrs.QueryParam
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("v1/")
@RegisterRestClient(configKey = "position-stack")
interface PositionStack {


    @GET
    @Path("forward")
    fun getLocation(
        @QueryParam("access_key")
        apikey: String,
        @QueryParam("query") location: String
    ): PositionStackForward

}