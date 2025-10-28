package co.com.retotecnico.certificacion.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

import java.util.concurrent.ThreadLocalRandom;

public class AgregarProductoCarritoPage {


    public static final Target OPCION_MENU = Target.the("opción del menú de categorías")
            .locatedBy("(//ul[@id='menu-categories-menu']//a)[{0}]");

    public static final Target SELECT_PRODUCTO = Target.the("imagen del producto número {0}")
            .locatedBy("(//div[contains(@class,'product-wrapper-with-variation')])[{0}]");

    public static final Target BTN_TALLA = Target.the("botón de talla")
            .locatedBy("(//div[contains(@class,'variation-buttons')]//button[contains(@class,'variation-button')])");


    private AgregarProductoCarritoPage() {


    }
}
