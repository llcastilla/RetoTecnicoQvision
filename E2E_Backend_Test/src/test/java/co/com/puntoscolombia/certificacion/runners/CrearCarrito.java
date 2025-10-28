package co.com.puntoscolombia.certificacion.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/crear_carrito.feature",
        glue = "co.com.puntoscolombia.certificacion",
        snippets = CAMELCASE)
public class CrearCarrito {
}
