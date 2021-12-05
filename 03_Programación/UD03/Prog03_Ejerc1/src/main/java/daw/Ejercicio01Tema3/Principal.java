package daw.Ejercicio01Tema3;

public class Principal {

    public static void main(String[] args) {

        //Instancia un objeto de la clase Fecha denominado objFecha1 con el primer constructor.
        Fecha objFecha1 = new Fecha(Fecha.enumMes.Marzo);

        //Actualiza los atributos dia y año para dicho objeto.
        objFecha1.setDia(4);
        objFecha1.setAnio(2021);

        //Muestra la fecha por pantalla en formato largo.
        System.out.println("Primera fecha, inicializada con el primer constructor");
        System.out.println("La fecha es: "+objFecha1.toString());
        
        //Muestra un mensaje por pantalla indicando si la fecha es verano
        String esVerano1 = objFecha1.isSummer() ? "Es verano" : "No es verano";
        System.out.println(esVerano1);
        
        //Instancia otro objeto de la clase Fecha denomiando objFecha2 con el segundo constructor
        Fecha objFecha2= new Fecha(5, Fecha.enumMes.Mayo, 2020);
        
        //Muestra el año de esta fecha por pantalla.
        System.out.println("\nSegunda fecha, inicializada con el segundo constructor");
        System.out.println("La fecha 2 contiene el año " +objFecha2.getAnio());
        
        //Muestra la fecha en formato largo por pantalla.
        System.out.println("La fecha es: "+objFecha2.toString());
        
        //Muestra un mensaje por pantalla indicando si la fecha es verano o no.
        String esVerano2 = objFecha2.isSummer() ? "Es verano" : "No es verano";
        System.out.println(esVerano2);
    }

}
