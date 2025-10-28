package co.com.retotecnico.certificacion.stepdefinitions;

import co.com.retotecnico.certificacion.models.Customer;
import co.com.retotecnico.certificacion.questions.MensajeActualizacion;
import co.com.retotecnico.certificacion.tasks.ActualizarUsuario;
import co.com.retotecnico.certificacion.userinterfaces.MainPagePage;
import co.com.retotecnico.certificacion.utils.dataPruebas;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.hamcrest.Matchers;

import static co.com.retotecnico.certificacion.utils.WordsToRemember.CUSTOMER_DATA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class ActualizarDatosPersonalesStepDefinitions {

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


    @Given("que el usuario ha iniciado sesión {}")
    public void queElUsuarioHaIniciadoSesiónModificarDatosPersonales(String prolife) {
        theActorInTheSpotlight().remember(CUSTOMER_DATA, dataPruebas.getCustomerDataWith(prolife));
    }
    @When("actualiza su número de teléfono y guarda los cambios")
    public void actualizaSuNúmeroDeTeléfonoYGuardaLosCambios() {
        Customer customer = theActorInTheSpotlight().recall(CUSTOMER_DATA);

        theActorInTheSpotlight().attemptsTo(
                ActualizarUsuario.actualizar(customer.getDatosUsuario())
        );
    }


    @Then("el sistema debe mostrar un mensaje de confirmación de actualizacion")
    public void elSistemaDebeMostrarUnMensajeDeConfirmaciónDeActualizacion() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        "El mensaje de confirmación",
                        MensajeActualizacion.es(),
                        Matchers.equalTo("Datos personales actualizados correctamente")
                )
        );
    }
}
