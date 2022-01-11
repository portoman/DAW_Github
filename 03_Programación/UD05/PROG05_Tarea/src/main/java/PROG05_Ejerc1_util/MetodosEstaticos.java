package PROG05_Ejerc1_util;

import java.time.LocalDate;

public class MetodosEstaticos {
    
    //Método para comprobar que los números escogidos están entre el 1 y el 9
    public static boolean numeroOpcion(int valor){
        return valor>=1 && valor<=9;
    }
    
    //Método para comprobar que un valor es positivo. Si lo es devuelve true, sino false
    public static boolean valorPositivo(double valor){
        return valor>0;
    }
    
    //Método para comprobar que una fecha es anterior al momento actual. Si lo es devuelve true, sino false
    public static boolean fechaAnterior(LocalDate fecha){
        return fecha.isBefore(LocalDate.now());
    }
    
    
    //Método para comprobar que el DNI es válido. Si lo es devuelve true, sino false
    public static boolean dniValido(int dni){
    return dni>999999 && dni<99999999; 
}
}