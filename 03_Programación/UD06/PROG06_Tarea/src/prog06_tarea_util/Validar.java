package prog06_tarea_util;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase Validar que incluye diferentes métodos estáticos para realizar validaciones.
 */
public class Validar {

    //Método para comprobar que los números escogidos están entre el 1 y el 6
    public static boolean numeroOpcion(int valor) {
        return valor >= 1 && valor <= 6;
    }

    //Método para comprobar que un valor es positivo. Si lo es devuelve true, sino false
    public static boolean valorPositivo(double valor) {
        return valor > 0;
    }

    //Método para comprobar que una fecha es anterior al momento actual. Si lo es devuelve true, sino false
    public static boolean fechaAnterior(LocalDate fecha) {
        return fecha.isBefore(LocalDate.now());
    }

    //Método para validar si el formato del DNI es correcto con expresión regular
    public static boolean validacionDNI(String dniAValidar) {
        Pattern dni = Pattern.compile("([0-9]{8})[A-Z]");
        Matcher dniMatcher = dni.matcher(dniAValidar);
        return dniMatcher.matches();
    }
    //Método para validar si el formato del DNI es correcto con expresión regular
    public static boolean validacionNIE(String dniAValidar) {
        Pattern dni = Pattern.compile("[A-Z]([0-9]{8})");
        Matcher dniMatcher = dni.matcher(dniAValidar);
        return dniMatcher.matches();
    }

    //Método para validar si el formato de la matricula es correcto con expresión regular
    public static boolean validacionMatricula(String matriculaAValidar) {
        Pattern matricula = Pattern.compile("[0-9]{4}[A-Z]{3}");
        Matcher matriculaMatcher = matricula.matcher(matriculaAValidar);
        return matriculaMatcher.matches();
    }
    
    //Método para validar que el nombre tenga 1 nombre y 2 apellidos y que la longitud maxima sea 40
    public static boolean validacionNombre(String nombreAValidar) {
        boolean valor=true;
        if(nombreAValidar.length()>40){
            valor=false;
        }
        String[] palabras = nombreAValidar.split("\\s+");
        if(palabras.length!=3){
            valor=false;
        };
        return valor;
    }
}
