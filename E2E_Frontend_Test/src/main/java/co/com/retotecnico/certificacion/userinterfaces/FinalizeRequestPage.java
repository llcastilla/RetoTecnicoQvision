package co.com.retotecnico.certificacion.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class FinalizeRequestPage {
    public static final Target MENSAJE_BIENVENIDA = Target.the("Mensaje de bienvenida después del registro")
            .locatedBy("//h3[contains(normalize-space(.),'Hola')]");

    public static final Target MENSAJE_ACTUALIZACION = Target.the("mensaje de confirmación de actualización")
            .located(By.xpath("//span[contains(text(),'Datos personales actualizados correctamente')]"));

    public static final Target TITULO_FINALIZAR_COMPRA = Target.the("título de Finalizar Compra")
            .locatedBy("//h1[contains(text(),'Finalizar compra')]");

    public static final Target MENSAJE_PRODUCTO_AGREGADO = Target.the("mensaje de producto añadido al carrito")
            .located(By.xpath("//div[contains(@class,'woocommerce-message')]"));

    private FinalizeRequestPage() {

    }

}
