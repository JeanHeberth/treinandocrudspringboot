package br.jeanheberth.cruduserspringboot.page;


import br.jeanheberth.cruduserspringboot.constantes.Constantes;
import br.jeanheberth.cruduserspringboot.utils.base.BaseTeste;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.client.MockRestServiceServer;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

class PaginaTest extends BaseTeste {

    @Test
    void consultarJsonComUmDado() {

        given()
                .spec(urlBase)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(Constantes.ID_USERS + 1)
                .then()
                .statusCode(200)
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/testeComUmDado.json"));
        //  Assertions.assertEquals();
    }

    @Test
    void consultarJsonComVariosDados() {
        given()
                .spec(urlBase)
                .contentType(ContentType.JSON)
                .when()
                .get(Constantes.ALL_USERS)
                .andReturn()
                .then()
                .body(matchesJsonSchemaInClasspath("schemas/testeComVariosDados.json"))
                .extract();

    }

    @Test
    void deveVerificarUsuario() {
        given()
                .spec(urlBase)
                .when()
                .get(Constantes.ID_USERS + 1)
                .then()
                .statusCode(200)
                .log().all()
                .body("id", is(1))
                .body("nome", containsString("Departamento Pessoal"))
                .body("numero", is(20));

    }
}



