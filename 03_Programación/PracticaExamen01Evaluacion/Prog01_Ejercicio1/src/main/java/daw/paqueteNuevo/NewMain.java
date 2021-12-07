package daw.paqueteNuevo;

import daw.paqueteNuevo.Fecha.enumMes;

public class NewMain {
    public static void main(String[] args) {
           enumMes mes= enumMes.Febrero;
            
           System.out.println("El mes es: "+mes);
           
           Fecha hoy=new Fecha(enumMes.Diciembre, 06, 2021);
           
           
        hoy.toString();
        
        System.out.println("El mes es: "+hoy.isSummer());
        System.out.println(hoy.toString());
        
        
        Fecha objFecha1=new Fecha(mes.Mayo);
        
        objFecha1.setDia(4);
        objFecha1.setAnho(1985);
        
        System.out.println("Mi cumple es: "+objFecha1.toString());
           
        
        Fecha objFecha2=new Fecha(mes.Junio, 18, 1987);
        
        System.out.println("El año cuando nació fue: "+objFecha2.anho);
        
        System.out.println("La fecha completa fue: "+objFecha2.toString());
        
        System.out.println((objFecha2.isSummer())?"Es verano":"No es verano");
    
        System.out.println(objFecha2.isSummer());
    
    }
    
}
