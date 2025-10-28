package co.com.retotecnico.certificacion.stepdefinitions;

import co.com.retotecnico.certificacion.models.Customer;
import co.com.retotecnico.certificacion.questions.ValidarMensajeBienvenida;
import co.com.retotecnico.certificacion.tasks.IniciarSesion;
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


public class InicioSesionStepDefinitions {

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



    @Given("que el usuario tiene una cuenta registrada {}")
    public void queElUsuarioTieneUnaCuentaRegistrada(String prolife) {
        theActorInTheSpotlight().remember(CUSTOMER_DATA, dataPruebas.getCustomerDataWith(prolife));

    }
    @When("ingresa su correo y contraseña válidos")
    public void ingresaSuCorreoYContraseñaVálidos() {
        Customer customer = theActorInTheSpotlight().recall(CUSTOMER_DATA);

        theActorInTheSpotlight().attemptsTo(
                IniciarSesion.sesion(customer.getDatosUsuario())
        );
    }


    @Then("el sistema redirige al panel de Mi cuenta")
    public void elSistemaRedirigeAlPanelDeMiCuenta() {
        theActorInTheSpotlight().should(
                seeThat(
                        "el mensaje de bienvenida mostrado",
                        ValidarMensajeBienvenida.mensaje(),
                        containsString("Hola,")
                )
        );
    }


}
