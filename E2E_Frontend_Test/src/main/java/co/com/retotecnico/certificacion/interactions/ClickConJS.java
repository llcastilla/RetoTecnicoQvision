package co.com.retotecnico.certificacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class ClickConJS implements Interaction {

    private final Target target;

    public ClickConJS(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade element = target.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor) net.serenitybdd.core.Serenity.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static ClickConJS en(Target target) {
        return Tasks.instrumented(ClickConJS.class, target);
    }
}
