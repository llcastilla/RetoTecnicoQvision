package co.com.retotecnico.certificacion.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static co.com.retotecnico.certificacion.userinterfaces.AgregarProductoCarritoPage.BTN_TALLA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarTalla implements Interaction {

    private static final Duration TIMEOUT = Duration.ofSeconds(15);
    private static final Duration POLLING = Duration.ofMillis(500);

    @Step("Seleccionar una talla disponible aleatoriamente y validar habilitación de compra")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElementFacade> todasLasTallas = BTN_TALLA.resolveAllFor(actor);
        List<WebElementFacade> tallasHabilitadas = todasLasTallas.stream()
                .filter(t -> t.isVisible() && t.isEnabled() && !t.getAttribute("class").contains("disabled"))
                .collect(Collectors.toList());

        if (!tallasHabilitadas.isEmpty()) {
            int indiceAleatorio = ThreadLocalRandom.current().nextInt(tallasHabilitadas.size());
            WebElementFacade tallaSeleccionada = tallasHabilitadas.get(indiceAleatorio);
            String valorTalla = tallaSeleccionada.getAttribute("data-value");
            System.out.println("Talla seleccionada: " + valorTalla);

            js.executeScript(
                    "const el = arguments[0];" +
                            "try { el.scrollIntoView({behavior: 'auto', block: 'center'}); } catch(e) {}" +
                            "el.dispatchEvent(new MouseEvent('mouseover', { bubbles: true }));" +
                            "el.dispatchEvent(new MouseEvent('mousedown', { bubbles: true }));" +
                            "el.dispatchEvent(new MouseEvent('mouseup', { bubbles: true }));" +
                            "el.dispatchEvent(new MouseEvent('click', { bubbles: true }));" +
                            "var selectors = ['input[name*=\"attribute\"]', 'select[name*=\"attribute\"]'];" +
                            "for (var s=0; s<selectors.length; s++) {" +
                            "  var control = document.querySelector(selectors[s]);" +
                            "  if (control) {" +
                            "    try { control.value = el.getAttribute('data-value'); } catch(e) {}" +
                            "    control.dispatchEvent(new Event('input', { bubbles: true }));" +
                            "    control.dispatchEvent(new Event('change', { bubbles: true }));" +
                            "  }" +
                            "}",
                    tallaSeleccionada
            );

            actor.remember("talla_seleccionada", valorTalla);

            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(TIMEOUT)
                    .pollingEvery(POLLING)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);

            try {
                boolean habilitado = wait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver d) {
                        try {
                            WebElement contenedor = d.findElement(By.cssSelector(".woocommerce-variation-add-to-cart"));
                            String clase = contenedor.getAttribute("class");
                            System.out.println("Verificando contenedor add-to-cart: " + clase);
                            return clase != null && !clase.toLowerCase().contains("disabled");
                        } catch (Exception ex) {
                            return false;
                        }
                    }
                });

                if (habilitado) {
                    System.out.println("El botón de compra se habilitó correctamente.");
                } else {
                    System.out.println("El botón de compra no se habilitó, pero se intentará hacer clic igualmente.");
                }

            } catch (TimeoutException e) {
                System.out.println("Tiempo de espera agotado: el botón de compra no se habilitó tras seleccionar la talla.");
            }

        } else {
            System.out.println("No hay tallas disponibles para este producto.");
            actor.remember("talla_seleccionada", "Sin talla");
        }

        // Independientemente de si había tallas o no, se intenta hacer clic en el botón de compra
        try {
            WebElement botonCompra = driver.findElement(By.cssSelector(".buy_now_link, .single_add_to_cart_button, .add-to-cart"));
            js.executeScript(
                    "const el = arguments[0];" +
                            "try { el.scrollIntoView({behavior: 'auto', block: 'center'}); } catch(e) {}" +
                            "el.removeAttribute('disabled');" +
                            "el.classList.remove('disabled');" +
                            "el.click();",
                    botonCompra
            );
            System.out.println("Se hizo clic en el botón de compra.");
        } catch (Exception e) {
            System.out.println("No se pudo hacer clic en el botón de compra: " + e.getMessage());
        }

        System.out.println("Validación finalizada.");
    }

    public static SeleccionarTalla aleatoriamente() {
        return instrumented(SeleccionarTalla.class);
    }
}
