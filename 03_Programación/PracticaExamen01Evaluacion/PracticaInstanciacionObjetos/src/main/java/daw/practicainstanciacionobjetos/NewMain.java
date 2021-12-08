package daw.practicainstanciacionobjetos;

public class NewMain {

    
    public static void main(String[] args) {
        
        
        Clase clase1=new Clase();
        
        System.out.println(clase1.toString());
        
       
        
        Alumno a1=new Alumno();
        System.out.println(clase1.alumnos.toString());
        
        clase1.imprimir();
    }
    
}
