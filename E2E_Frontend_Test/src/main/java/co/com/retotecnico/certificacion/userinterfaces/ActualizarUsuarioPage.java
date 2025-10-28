package co.com.retotecnico.certificacion.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ActualizarUsuarioPage {



    public static final Target UPDATE_LINK_DATOS_CUENTA = Target.the("Enlace hacia la sección de datos personales del usuario")
            .locatedBy("(//a[normalize-space()='Datos'])[3]");

    public static final Target UPDATE_BTN_EDITAR_DATOS = Target.the("Botón para habilitar la edición de información del usuario")
            .locatedBy("//button[contains(@class,'update-info-btn')]");

    public static final Target UPDATE_INPUT_NOMBRES = Target.the("Campo para actualizar los nombres del usuario")
            .locatedBy("//input[@name='first_name']");

    public static final Target UPDATE_INPUT_APELLIDOS = Target.the("Campo para actualizar los apellidos del usuario")
            .locatedBy("//input[@id='last_name' or @name='last_name']");

    public static final Target UPDATE_INPUT_CORREO = Target.the("Campo para actualizar el correo electrónico del usuario")
            .locatedBy("//input[@type='text' and @name='aux_email']");

    public static final Target UPDATE_INPUT_FECHA_NACIMIENTO = Target.the("Campo para actualizar la fecha de nacimiento del usuario")
            .located(By.xpath("//input[@data-field='birth_date']"));

    public static final Target UPDATE_INPUT_TELEFONO = Target.the("Campo para actualizar el número telefónico del usuario")
            .located(By.xpath("//input[@data-field='billing_phone']"));

    public static final Target UPDATE_SELECT_GENERO = Target.the("Selector para actualizar el género del usuario")
            .located(By.xpath("//select[@name='gender']"));

    public static final Target UPDATE_BTN_GUARDAR = Target.the("Botón para guardar la información actualizada del perfil")
            .located(By.xpath("//button[@type='button' and contains(@class, 'save-info-btn')]"));


    private ActualizarUsuarioPage() {

    }
}
