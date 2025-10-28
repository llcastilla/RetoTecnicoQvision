package co.com.retotecnico.certificacion.tasks;
import co.com.retotecnico.certificacion.models.DatosUsuario;
import co.com.retotecnico.certificacion.userinterfaces.GenericsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static co.com.retotecnico.certificacion.userinterfaces.RegistroUsuarioPage.*;
import static co.com.retotecnico.certificacion.utils.DataGenerator.generarCedulaAleatoria;
import static co.com.retotecnico.certificacion.utils.DataGenerator.generarCorreoAleatorio;


public class RegistroUsuario implements Task {
private  final DatosUsuario datosUsuario;
    public RegistroUsuario(DatosUsuario datosUsuario) {


        this.datosUsuario = datosUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(GenericsPage.ACEPTAR_COOKIES),
                Click.on(GenericsPage.MENU_CUENTA),
                Click.on(SPAN_REGISTRARSE),

                // Genera cédula y correo dinámicamente
                Enter.theValue(generarCedulaAleatoria()).into(INPUT_CEDULA),
                Enter.theValue(datosUsuario.getNombres()).into(INPUT_NOMBRE),
                Enter.theValue(datosUsuario.getApellidos()).into(INPUT_APELLIDO),
                Enter.theValue(generarCorreoAleatorio("micorreo", "prueba.com")).into(INPUT_CORREO),

                Enter.theValue(datosUsuario.getContrasena()).into(INPUT_PASSWORD),
                Enter.theValue(datosUsuario.getConfirmarContrasena()).into(INPUT_CONFIRMAR_PASSWORD),

                Click.on(CHECKBOX_AUTORIZACION_BOLETIN),
                Click.on(CHECKBOX_POLITICA_PRIVACIDAD),
                Click.on(BOTON_REGISTRAR)
        );
    }

    public static RegistroUsuario registro(DatosUsuario datosUsuario) {
        return Tasks.instrumented(RegistroUsuario.class,datosUsuario);
    }
}
