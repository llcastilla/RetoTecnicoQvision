package co.com.retotecnico.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RegistroUsuarioPage {

    public static final Target SPAN_REGISTRARSE = Target.the("es donde nos vamos a registrar")
            .locatedBy("//span[@id='show_register']");

    public static final Target INPUT_CEDULA = Target.the("Ingresamos el número de cédula")
            .locatedBy("(//input[@id='reg_username' or @name='username'])[2]");

    public static final Target INPUT_NOMBRE = Target.the("Ingresamos el primer nombre del usuario")
            .locatedBy("//input[@id='first_name' or @name='first_name']");

    public static final Target INPUT_APELLIDO = Target.the("Ingresamos el apellido del usuario")
            .locatedBy("//input[@id='last_name' or @name='last_name']");

    public static final Target INPUT_CORREO = Target.the("Ingresamos el correo electrónico del usuario")
            .locatedBy("//input[@id='reg_email' or @name='email']");

    public static final Target INPUT_PASSWORD = Target.the("Ingresamos la contraseña del usuario")
            .locatedBy("(//input[@id='reg_password' or @name='password'])[2]");

    public static final Target INPUT_CONFIRMAR_PASSWORD = Target.the("Confirmamos la contraseña del usuario")
            .locatedBy("//input[@id='reg_password2' or @name='password2']");
    public static final Target CHECKBOX_AUTORIZACION_BOLETIN = Target.the("Checkbox de autorización para recibir el boletín o newsletter")
            .locatedBy("//input[@id='newsletter_authorization' or @name='newsletter_authorization']");

    public static final Target CHECKBOX_POLITICA_PRIVACIDAD = Target.the("Checkbox de aceptación de la política de privacidad")
            .locatedBy("//input[@id='privacy_policy_reg' or @name='privacy_policy_reg']");
    public static final Target BOTON_REGISTRAR = Target.the("Botón para enviar el formulario y completar el registro del usuario")
            .locatedBy("//button[@type='submit' and (@name='register' or contains(.,'Registrarme'))]");

    private RegistroUsuarioPage() {


    }
}
