package co.com.retotecnico.certificacion.tasks;

import co.com.retotecnico.certificacion.models.DatosUsuario;
import co.com.retotecnico.certificacion.userinterfaces.ActualizarUsuarioPage;
import co.com.retotecnico.certificacion.userinterfaces.GenericsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import static co.com.retotecnico.certificacion.userinterfaces.GenericsPage.*;
import static co.com.retotecnico.certificacion.utils.DataGenerator.generarCorreoAleatorio;
import static co.com.retotecnico.certificacion.utils.DataGenerator.generarFechaNacimientoAleatoria;


public class ActualizarUsuario implements Task {
    private final DatosUsuario datosUsuario;

    public ActualizarUsuario(DatosUsuario datosUsuario) {


        this.datosUsuario = datosUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(GenericsPage.ACEPTAR_COOKIES),
                Click.on(GenericsPage.MENU_CUENTA),
                Enter.theValue(datosUsuario.getCedula()).into(USUARIO),
                Enter.theValue(datosUsuario.getContrasena()).into(CONTRASENA),
                Click.on(GenericsPage.BTN_INICIAR_SESION),
                Click.on(ActualizarUsuarioPage.UPDATE_LINK_DATOS_CUENTA),
                Click.on(ActualizarUsuarioPage.UPDATE_BTN_EDITAR_DATOS),

                SendKeys.of(Keys.CONTROL, "a").into(ActualizarUsuarioPage.UPDATE_INPUT_NOMBRES),
                SendKeys.of(Keys.DELETE).into(ActualizarUsuarioPage.UPDATE_INPUT_NOMBRES),
                Enter.theValue(datosUsuario.getNombres()).into(ActualizarUsuarioPage.UPDATE_INPUT_NOMBRES),

                SendKeys.of(Keys.CONTROL, "a").into(ActualizarUsuarioPage.UPDATE_INPUT_APELLIDOS),
                SendKeys.of(Keys.DELETE).into(ActualizarUsuarioPage.UPDATE_INPUT_APELLIDOS),
                Enter.theValue(datosUsuario.getApellidos()).into(ActualizarUsuarioPage.UPDATE_INPUT_APELLIDOS),

                SendKeys.of(Keys.CONTROL, "a").into(ActualizarUsuarioPage.UPDATE_INPUT_CORREO),
                SendKeys.of(Keys.DELETE).into(ActualizarUsuarioPage.UPDATE_INPUT_CORREO),
                Enter.theValue(generarCorreoAleatorio("micorreo", "prueba.com")).into(ActualizarUsuarioPage.UPDATE_INPUT_CORREO),

                Enter.theValue(generarFechaNacimientoAleatoria()).into(ActualizarUsuarioPage.UPDATE_INPUT_FECHA_NACIMIENTO),
                Enter.theValue(datosUsuario.getTelefono()).into(ActualizarUsuarioPage.UPDATE_INPUT_TELEFONO),
                SelectFromOptions.byVisibleText(datosUsuario.getGenero()).from(ActualizarUsuarioPage.UPDATE_SELECT_GENERO),

                Click.on(ActualizarUsuarioPage.UPDATE_BTN_GUARDAR)
        );
    }

    public static ActualizarUsuario actualizar(DatosUsuario datosUsuario) {
        return Tasks.instrumented(ActualizarUsuario.class, datosUsuario);
    }
}
