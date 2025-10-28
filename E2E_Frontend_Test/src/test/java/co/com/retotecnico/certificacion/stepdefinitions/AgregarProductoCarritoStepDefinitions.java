package co.com.retotecnico.certificacion.stepdefinitions;

import co.com.retotecnico.certificacion.models.Customer;
import co.com.retotecnico.certificacion.questions.ValidarMensajeCarrito;
import co.com.retotecnico.certificacion.tasks.AgregarProductoCarrito;
import co.com.retotecnico.certificacion.tasks.ComprarTarjetaRegalo;
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


public class AgregarProductoCarritoStepDefinitions {

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

    @Given("que el usuario está en la página de inicio {}")
    public void queElUsuarioEstáEnLaPáginaDeInicioAgregarProductoCarrito(String prolife) {
        theActorInTheSpotlight().remember(CUSTOMER_DATA, dataPruebas.getCustomerDataWith(prolife));
    }

    @When("selecciona un producto y lo agrega al carrito")
    public void seleccionaUnProductoYLoAgregaAlCarrito() {
        Customer customer = theActorInTheSpotlight().recall(CUSTOMER_DATA);

        theActorInTheSpotlight().attemptsTo(
                AgregarProductoCarrito.carrito(customer.getDatosUsuario())
        );
    }

    @Then("el producto debe aparecer en el carrito de compras")
    public void elProductoDebeAparecerEnElCarritoDeCompras() {
        theActorInTheSpotlight().should(
                seeThat(
                        "el mensaje de confirmación del carrito",
                        ValidarMensajeCarrito.mensaje(),
                        containsString("se ha añadido a tu carrito")
                )
        );
    }
}
