package co.com.retotecnico.certificacion.questions;

import co.com.retotecnico.certificacion.userinterfaces.FinalizeRequestPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarMensajeBienvenida implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(FinalizeRequestPage.MENSAJE_BIENVENIDA)
                .answeredBy(actor)
                .trim();
    }

    public static ValidarMensajeBienvenida mensaje() {
        return new ValidarMensajeBienvenida();
    }
}
