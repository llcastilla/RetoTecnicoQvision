package co.com.puntoscolombia.certificacion.stepdefinitions;


import co.com.puntoscolombia.certificacion.tasks.ConnectExistClientApi;
import co.com.puntoscolombia.certificacion.tasks.ConsumerPatch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.puntoscolombia.certificacion.utils.Constants.*;
import static org.hamcrest.Matchers.*;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ModificarUsuarioStepDefinitions {
    Actor actor = Actor.named("tester");

    @Given("que un cliente autenticado tiene un usuario existente a modificar")
    public void queUnClienteAutenticadoTieneUnUsuarioExistenteAModificar() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_USUARIO_PATCH));

    }

    @When("se realiza una solicitud PUT al endpoint de usuarios con la información actualizada")
    public void seRealizaUnaSolicitudPUTAlEndpointDeUsuariosConLaInformaciónActualizada() {
        actor.attemptsTo(ConsumerPatch.elServicio(QUERYUSER));

    }

    @Then("el servicio responde con el código de estado exitoso y el usuario se modifica correctamente")
    public void elServicioRespondeConElCódigoDeEstadoExitosoYElUsuarioSeModificaCorrectamente() {
        actor.should(
                seeThatResponse("El servicio debe responder con 200 OK y devolver los datos del usuario modificado",
                        response -> response
                                .statusCode(ESTADO_SERVICIO_OK)
                                .body("username", not(isEmptyOrNullString()))
                                .body("username", equalTo("john_doe"))
                                .body("email", not(isEmptyOrNullString()))
                                .body("email", equalTo("john@example.com"))
                )
        );
    }

}
