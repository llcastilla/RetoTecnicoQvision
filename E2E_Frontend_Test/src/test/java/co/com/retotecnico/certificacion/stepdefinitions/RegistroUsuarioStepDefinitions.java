package co.com.retotecnico.certificacion.stepdefinitions;

import co.com.retotecnico.certificacion.models.Customer;
import co.com.retotecnico.certificacion.questions.ValidarMensajeBienvenida;
import co.com.retotecnico.certificacion.tasks.RegistroUsuario;
import co.com.retotecnico.certificacion.userinterfaces.MainPagePage;
import co.com.retotecnico.certificacion.utils.dataPruebas;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

import static co.com.retotecnico.certificacion.utils.WordsToRemember.CUSTOMER_DATA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;


public class RegistroUsuarioStepDefinitions {

    @After
    public static void CloseDriver() {
        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
    }

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        Actor actor = OnStage.theActorCalled("actor");
        actor.wasAbleTo(Open.browserOn().the(MainPagePage.class));
    }

    @Given("que el usuario se encuentra en la página de registro {}")
    public void queElUsuarioSeEncuentraEnLaPáginaDeRegistroModificarDatosPersonales(String prolife) {
        theActorInTheSpotlight().remember(CUSTOMER_DATA, dataPruebas.getCustomerDataWith(prolife));

    }

    @When("completa todos los campos obligatorios con datos válidos")
    public void completaTodosLosCamposObligatoriosConDatosVálidos() {
        Customer customer = theActorInTheSpotlight().recall(CUSTOMER_DATA);

        theActorInTheSpotlight().attemptsTo(
                RegistroUsuario.registro(customer.getDatosUsuario())
        );
    }

    @Then("el sistema debe mostrar un mensaje de confirmación")
    public void elSistemaDebeMostrarUnMensajeDeConfirmación() {
        theActorInTheSpotlight().should(
                seeThat(
                        "el mensaje de bienvenida mostrado",
                        ValidarMensajeBienvenida.mensaje(),
                        containsString("Hola,")
                )
        );
    }


}
