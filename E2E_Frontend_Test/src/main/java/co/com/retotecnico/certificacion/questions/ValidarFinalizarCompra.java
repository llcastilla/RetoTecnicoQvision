package co.com.retotecnico.certificacion.questions;

import co.com.retotecnico.certificacion.userinterfaces.FinalizeRequestPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarFinalizarCompra implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        // Obtiene el texto del h1 y lo retorna como String
        return Text.of(FinalizeRequestPage.TITULO_FINALIZAR_COMPRA)
                .answeredBy(actor)
                .trim();
    }

    // Método estático para usar de forma fluida en el Step
    public static Question<String> valor() {
        return new ValidarFinalizarCompra();
    }
}
