package br.jeanheberth.cruduserspringboot.page;


import br.jeanheberth.cruduserspringboot.constantes.Constantes;
import br.jeanheberth.cruduserspringboot.utils.base.BaseTeste;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
 class ValidandoUrlTest extends BaseTeste {

    @Test
    void testeRetornarPagina() {
        given()
                .spec(urlBase)
                .log().all()
                .when()
                .get(Constantes.olaMundo)
                .then()
                .statusCode(200)
                .body(containsString("Ola Mundo!"));

    }

    @Test
    void consultarUsuario() {
        given()
               // .spec(urlBase)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                //.get(Constantes.ID_USERS + 1)
                .then()

                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("schemas/testeComVariosDados.json"))

        ;
    }
}
