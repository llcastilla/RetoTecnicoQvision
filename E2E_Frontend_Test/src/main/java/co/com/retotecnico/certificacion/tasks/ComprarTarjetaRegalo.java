package co.com.retotecnico.certificacion.tasks;
import co.com.retotecnico.certificacion.interactions.ClickConJS;
import co.com.retotecnico.certificacion.models.DatosUsuario;
import co.com.retotecnico.certificacion.userinterfaces.ComprarTarjetaRegaloPage;
import co.com.retotecnico.certificacion.utils.DataGenerator;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static co.com.retotecnico.certificacion.userinterfaces.AgregarProductoCarritoPage.BTN_TALLA;
import static co.com.retotecnico.certificacion.userinterfaces.ComprarTarjetaRegaloPage.*;
import static co.com.retotecnico.certificacion.userinterfaces.GenericsPage.*;

public class ComprarTarjetaRegalo implements Task {
    int indiceAleatorio = DataGenerator.generarIndiceAleatorio(100); // entre 1 y 100

    private final DatosUsuario datosUsuario;

    public ComprarTarjetaRegalo(DatosUsuario datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> tallasDisponibles = BTN_TALLA.resolveAllFor(actor);

        actor.attemptsTo(
                Click.on(ACEPTAR_COOKIES),
                Click.on(MENU_CUENTA),
                Enter.theValue(datosUsuario.getCedula()).into(USUARIO),
                Enter.theValue(datosUsuario.getContrasena()).into(CONTRASENA),
                Click.on(BTN_INICIAR_SESION),
                Click.on(BTN_MENU_DESKTOP),
                Click.on(MENU_BONOS_REGALO),
                ClickConJS.en(botonAleatorio()),
                Click.on(BTN_COMPRAR_AHORA),
                Click.on(BTN_FINALIZAR_COMPRA),
                Click.on(BTN_CONTINUAR_STEP2),
                Click.on(SELECT_CIUDAD_BILLING),
                Click.on(ComprarTarjetaRegaloPage.OPCION_CIUDAD_ALEATORIA(indiceAleatorio)),
                Enter.theValue(DataGenerator.generarDireccionAleatoria()).into(ComprarTarjetaRegaloPage.INPUT_DIRECCION),
                Enter.theValue(DataGenerator.generarCodigoPostalAleatorio()).into(ComprarTarjetaRegaloPage.INPUT_CODIGO_POSTAL),
                Click.on(CHECKBOX_TERMINOS),
                Click.on(BTN_REALIZAR_PEDIDO)

        );


    }

    public static ComprarTarjetaRegalo regalo(DatosUsuario datosUsuario ) {
        return Tasks.instrumented(ComprarTarjetaRegalo.class, datosUsuario);
    }
}
