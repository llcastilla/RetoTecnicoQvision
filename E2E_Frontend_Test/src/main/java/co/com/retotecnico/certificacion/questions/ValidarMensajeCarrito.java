package co.com.retotecnico.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.retotecnico.certificacion.userinterfaces.FinalizeRequestPage.MENSAJE_PRODUCTO_AGREGADO;

public class ValidarMensajeCarrito implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        String mensaje = Text.of(MENSAJE_PRODUCTO_AGREGADO)
                .answeredBy(actor)
                .trim();

        // Normaliza el texto eliminando comillas tipográficas y cambiando a minúsculas
        mensaje = mensaje
                .replace("“", "")
                .replace("”", "")
                .toLowerCase();

        return mensaje;
    }

    public static ValidarMensajeCarrito mensaje() {
        return new ValidarMensajeCarrito();
    }
}
