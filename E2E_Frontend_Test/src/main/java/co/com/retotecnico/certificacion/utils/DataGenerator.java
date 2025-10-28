package co.com.retotecnico.certificacion.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {

    private static final Random random = new Random();

    /**
     * Genera una cédula aleatoria de 10 dígitos.
     * @return número de cédula como cadena
     */
    public static String generarCedulaAleatoria() {
        StringBuilder cedula = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            cedula.append(random.nextInt(10));
        }
        return cedula.toString();
    }

    /**
     * Genera un correo con un número aleatorio entre el nombre base y el dominio.
     * Ejemplo: micorreo4032@prueba.com
     * @param correoBase Parte antes del @ (ejemplo: "micorreo")
     * @param dominio Dominio del correo (ejemplo: "prueba.com")
     * @return correo aleatorio generado
     */
    public static String generarCorreoAleatorio(String correoBase, String dominio) {
        int numero = 1000 + random.nextInt(9000); // genera número entre 1000 y 9999
        return correoBase + numero + "@" + dominio;
    }

    /**
     * Genera una fecha de nacimiento aleatoria entre 18 y 70 años atrás,
     * en formato ddMMyyyy (por ejemplo "25011995").
     * @return fecha de nacimiento en formato ddMMyyyy
     */
    public static String generarFechaNacimientoAleatoria() {
        LocalDate hoy = LocalDate.now();

        // Fecha máxima: 18 años atrás
        LocalDate maxFecha = hoy.minusYears(18);

        // Fecha mínima: 70 años atrás
        LocalDate minFecha = hoy.minusYears(70);

        // Calcula días entre ambas fechas
        long diasEntre = maxFecha.toEpochDay() - minFecha.toEpochDay();

        // Escoge un número aleatorio dentro del rango
        long diasAleatorios = (long) (random.nextDouble() * diasEntre);

        // Genera la fecha final
        LocalDate fechaNacimiento = minFecha.plusDays(diasAleatorios);

        // Devuelve en formato ddMMyyyy
        return fechaNacimiento.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
    }

    /**
     * Genera una dirección aleatoria estilo colombiano: Carrera X # Y-Z
     * @return dirección aleatoria
     */
    public static String generarDireccionAleatoria() {
        int carrera = 1 + random.nextInt(200); // Carrera 1 a 200
        int numero = 1 + random.nextInt(1000); // Número 1 a 1000
        int digito = random.nextInt(100); // Dígito opcional 0 a 99

        return "Carrera " + carrera + " #" + numero + "-" + digito;
    }

    /**
     * Genera un código postal aleatorio de 5 dígitos (ej: 11001, 200005, etc.)
     * @return código postal como String
     */
    public static String generarCodigoPostalAleatorio() {
        int codigo = 10000 + random.nextInt(90000); // genera número entre 10000 y 99999
        return String.valueOf(codigo);
    }

    /**
     * Genera un índice aleatorio para Select2 (o cualquier lista), entre 1 y max
     * @param max valor máximo del índice (inclusive)
     * @return índice aleatorio
     */
    public static int generarIndiceAleatorio(int max) {
        return 1 + random.nextInt(max); // devuelve entre 1 y max
    }


}
