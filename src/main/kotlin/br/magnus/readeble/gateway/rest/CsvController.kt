package br.magnus.readeble.gateway.rest

import br.magnus.readeble.usecase.DiscoverType
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("api/v1")
class CsvController(
    private val discoverType: DiscoverType
) {

    @Path("/import")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MEDIA_TYPE_WILDCARD)
    @POST
    fun createRoute(message: String): Response {
        discoverType.discover(message)
        return Response.status(Response.Status.CREATED).header("Access-Control-Allow-Origin", "*").build()
    }

}