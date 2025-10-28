package co.com.retotecnico.certificacion.tasks;

import co.com.retotecnico.certificacion.models.DatosUsuario;
import co.com.retotecnico.certificacion.userinterfaces.GenericsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static co.com.retotecnico.certificacion.userinterfaces.GenericsPage.*;


public class IniciarSesion implements Task {
private  final DatosUsuario datosUsuario;
    public IniciarSesion(DatosUsuario datosUsuario) {


        this.datosUsuario = datosUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(GenericsPage.ACEPTAR_COOKIES),
                Click.on(GenericsPage.MENU_CUENTA),
                Enter.theValue(datosUsuario.getCedula()).into(USUARIO),
                Enter.theValue(datosUsuario.getContrasena()).into(CONTRASENA),
                Click.on(BTN_INICIAR_SESION)




        );
    }

    public static IniciarSesion sesion(DatosUsuario datosUsuario) {
        return Tasks.instrumented(IniciarSesion.class,datosUsuario);
    }
}
