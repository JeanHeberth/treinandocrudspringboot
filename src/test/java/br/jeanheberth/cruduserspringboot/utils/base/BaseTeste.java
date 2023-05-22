package br.jeanheberth.cruduserspringboot.utils.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static br.jeanheberth.cruduserspringboot.constantes.Constantes.url;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseTeste {

    protected static RequestSpecification urlBase = new RequestSpecBuilder()
            .setBaseUri(url)
            .build();

}
