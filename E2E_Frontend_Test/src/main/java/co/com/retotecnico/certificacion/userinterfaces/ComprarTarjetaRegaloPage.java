package co.com.retotecnico.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import java.util.concurrent.ThreadLocalRandom;

public class ComprarTarjetaRegaloPage {
    public static int indiceAleatorio() {
        return ThreadLocalRandom.current().nextInt(1, 7); // 1 inclusive, 7 exclusive
    }

    public static final Target BTN_MENU_DESKTOP = Target.the("botón del menú principal (hamburguesa)")
            .locatedBy("//button[@id='toggle-desktop-menu']");

    public static final Target MENU_BONOS_REGALO = Target.the("Opción del menú Bonos de regalo")
            .locatedBy("//li[a[text()='Bonos de regalo']]/a");

    public static final Target BOTONES_VALOR_BONO = Target.the("botones de valores del bono")
            .locatedBy("(//div[contains(@class,'variation-buttons')]//button[contains(@class,'variation-button')])[{0}]");

    public static Target botonAleatorio() {
        return Target.the("botón de variación aleatorio")
                .locatedBy(BOTONES_VALOR_BONO.getCssOrXPathSelector().replace("{0}", String.valueOf(indiceAleatorio())));
    }

    public static Target OPCION_CIUDAD_ALEATORIA(int indice) {
        return Target.the("opción aleatoria de ciudad")
                .locatedBy("(//li[contains(@class,'select2-results__option')])[" + indice + "]");
    }


    public static final Target INPUT_DIRECCION = Target.the("campo de dirección de facturación")
            .locatedBy("//input[@id='billing_address_1']");

    public static final Target INPUT_CODIGO_POSTAL = Target.the("campo de código postal de facturación")
            .locatedBy("//input[@id='billing_postcode']");
    public static final Target CHECKBOX_TERMINOS = Target.the("checkbox de términos y condiciones")
            .locatedBy("//input[@type='checkbox' and @name='terms']");

    public static final Target BTN_REALIZAR_PEDIDO = Target.the("botón Realizar el pedido")
            .locatedBy("//button[@id='place_order' and @name='woocommerce_checkout_place_order']");

    private ComprarTarjetaRegaloPage() {


    }
}
