package br.magnus.readeble.domain.reader

import br.magnus.readeble.domain.entities.Route
import br.magnus.readeble.domain.entities.Type
import io.quarkus.test.junit.QuarkusTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import javax.inject.Inject

@QuarkusTest
internal class CsvReaderConverterTest {

    @Inject
    lateinit var csvReaderConverter: CsvReaderConverter<Route>

    @Test
    fun `Should read csv from string`() {
        val csv = "Origem,UF,Destino,UF,Tipo de Carga,Peso/Ton\n" +
                "Imbituva,PR,Ponta Grossa,PR,Granel,20"

        val routes = csvReaderConverter.read(csv, Route::class.java)
        assertAll(
            "Should validate values",
            {
                assertThat(routes[0].origin, `is`("Imbituva"))
                assertThat(routes[0].originState, `is`("PR"))
                assertThat(routes[0].destination, `is`("Ponta Grossa"))
                assertThat(routes[0].destinationState, `is`("PR"))
                assertThat(routes[0].loadType, `is`(Type.GRANEL))
                assertThat(routes[0].weight, `is`(20.0))
            }

        )
    }
}