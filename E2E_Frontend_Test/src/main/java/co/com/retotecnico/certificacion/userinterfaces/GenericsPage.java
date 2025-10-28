package co.com.retotecnico.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class GenericsPage {
    public static final Target BTN_INICIAR_SESION = Target.the("Botón para iniciar sesión en la cuenta del usuario")
            .locatedBy("//button[@name='login']");

    public static final Target ACEPTAR_COOKIES = Target.the("Botón para aceptar las cookies del sitio")
            .locatedBy("//div[@id='cookiescript_accept']");

    public static final Target MENU_CUENTA = Target.the("Botón para abrir el menú de la cuenta del usuario")
            .locatedBy("//div[@id='toggle-account-menu']/a");

    public static final Target USUARIO = Target.the("Campo para ingresar el número de cédula del usuario")
            .locatedBy("//input[@id='username']");

    public static final Target CONTRASENA = Target.the("Campo para ingresar la contraseña del usuario")
            .locatedBy("//input[@id='password']");

    public static final Target BTN_COMPRAR_AHORA = Target.the("botón Comprar Ahora para agregar la tarjeta al carrito")
            .locatedBy("//a[contains(@class,'buy_now_link') and contains(@href,'add-to-cart')]");

    public static final Target BTN_FINALIZAR_COMPRA = Target.the("botón Finalizar compra")
            .locatedBy("//a[contains(@class,'checkout-button') and contains(@href,'finalizar-compra')]");

    public static final Target BTN_CONTINUAR_STEP2 = Target.the("botón Continuar en el paso 2 del checkout")
            .locatedBy("//button[@data-step='step2' and contains(@class,'resume-cta')]");

    public static final Target SELECT_CIUDAD_BILLING = Target.the("campo de ciudad de facturación")
            .locatedBy("//span[@id='select2-billing_city-container']");


    private GenericsPage() {


    }
}
