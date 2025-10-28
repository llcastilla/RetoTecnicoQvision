package co.com.retotecnico.certificacion.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cedula",
        "nombres",
        "apellidos",
        "correoElectronico",
        "contrasena",
        "confirmarContrasena",
        "telefono",
        "genero"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DatosUsuario {

    @JsonProperty("cedula")
    private String cedula;

    @JsonProperty("nombres")
    private String nombres;

    @JsonProperty("apellidos")
    private String apellidos;

    @JsonProperty("correoElectronico")
    private String correoElectronico;

    @JsonProperty("contrasena")
    private String contrasena;

    @JsonProperty("confirmarContrasena")
    private String confirmarContrasena;


    @JsonProperty("telefono")
    private String telefono;


    @JsonProperty("genero")
    private String genero;
}
