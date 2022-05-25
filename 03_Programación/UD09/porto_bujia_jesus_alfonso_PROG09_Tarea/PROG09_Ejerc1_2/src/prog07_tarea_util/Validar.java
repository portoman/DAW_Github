package prog07_tarea_util;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase Validar que incluye diferentes métodos estáticos para realizar validaciones.
 */
public class Validar implements Serializable {

    //Método para validar si el formato del DNI es correcto con expresión regular
    public static boolean validacionDNI(String dniAValidar) {
        Pattern dni = Pattern.compile("([0-9]{8})[A-Z]");
        Matcher dniMatcher = dni.matcher(dniAValidar);
        return dniMatcher.matches();
    }

    //Método para validar si el formato del IBAN es correcto con expresión regular
    public static boolean validacionIBAN(String ibanAValidar) {
        Pattern dni = Pattern.compile("ES([0-9]{20})");
        Matcher dniMatcher = dni.matcher(ibanAValidar);
        return dniMatcher.matches();
    }
}
