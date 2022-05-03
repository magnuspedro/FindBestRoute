package br.magnus.readeble.gateway.rest

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test

@QuarkusTest
internal class CsvControllerTest {

    @Test
    fun `Should test csv create route`() {
        given()
            .`when`().post("/api/v1/import")
            .then()
            .statusCode(422)
    }
}