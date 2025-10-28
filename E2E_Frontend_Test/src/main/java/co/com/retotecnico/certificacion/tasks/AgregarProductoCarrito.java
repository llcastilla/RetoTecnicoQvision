package co.com.retotecnico.certificacion.tasks;

import co.com.retotecnico.certificacion.interactions.SeleccionarTalla;
import co.com.retotecnico.certificacion.interactions.StopWatch;
import co.com.retotecnico.certificacion.models.DatosUsuario;
import co.com.retotecnico.certificacion.utils.DataGenerator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.concurrent.ThreadLocalRandom;

import static co.com.retotecnico.certificacion.userinterfaces.AgregarProductoCarritoPage.*;
import static co.com.retotecnico.certificacion.userinterfaces.GenericsPage.*;

public class AgregarProductoCarrito implements Task {
    int indiceAleatorio = ThreadLocalRandom.current().nextInt(1, 6);
    int indiceProducto = ThreadLocalRandom.current().nextInt(1, 4);

    private final DatosUsuario datosUsuario;

    public AgregarProductoCarrito(DatosUsuario datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(ACEPTAR_COOKIES),
                Click.on(MENU_CUENTA),
                Enter.theValue(datosUsuario.getCedula()).into(USUARIO),
                Enter.theValue(datosUsuario.getContrasena()).into(CONTRASENA),
                Click.on(BTN_INICIAR_SESION),
                Click.on(OPCION_MENU.of(String.valueOf(indiceAleatorio))),
                Click.on(SELECT_PRODUCTO.of(String.valueOf(indiceProducto))),
                SeleccionarTalla.aleatoriamente()
                );


    }

    public static AgregarProductoCarrito carrito(DatosUsuario datosUsuario) {
        return Tasks.instrumented(AgregarProductoCarrito.class, datosUsuario);
    }
}
