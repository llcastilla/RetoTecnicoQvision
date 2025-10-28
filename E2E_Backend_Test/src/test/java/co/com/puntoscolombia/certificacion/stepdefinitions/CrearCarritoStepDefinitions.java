package co.com.puntoscolombia.certificacion.stepdefinitions;


import co.com.puntoscolombia.certificacion.tasks.ConnectExistClientApi;
import co.com.puntoscolombia.certificacion.tasks.Consumer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static co.com.puntoscolombia.certificacion.utils.Constants.*;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearCarritoStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que un cliente autenticado desea crear un carrito")
    public void queUnClienteAutenticadoDeseaCrearUnCarrito() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_CARRITO));

    }

    @When("se realiza una solicitud POST al endpoint de carrito con la información requerida")
    public void seRealizaUnaSolicitudPOSTAlEndpointDeCarritoConLaInformaciónRequerida() {
        actor.attemptsTo(Consumer.elServicio(QUERYCARRITO));

    }

    @Then("el servicio responde con el código de estado exitoso y el carrito es creado correctamente")
    public void elServicioRespondeConElCódigoDeEstadoExitosoYElCarritoEsCreadoCorrectamente() {
        actor.should(
                seeThatResponse("El carrito fue creado correctamente",
                        response -> response.statusCode(ESTADO_OK)
                                .body("id", equalTo(11))
                                .body("userId", equalTo(1))
                                .body("products[0].id", equalTo(1))
                )
        );
    }

}
