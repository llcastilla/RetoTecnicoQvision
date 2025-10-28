package co.com.retotecnico.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/actualizar_datos_personales.feature",
        glue = {"co.com.retotecnico.certificacion.stepdefinitions"},
        tags = "",
        snippets = SnippetType.CAMELCASE
)
public class ActualizarDatosPersonales {
}
