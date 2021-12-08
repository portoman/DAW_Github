package daw.practicainstanciacionobjetos;

public class Alumno {
    
    String nombre;
    int edad;
    
    public Alumno(){
        
        this.nombre=Datos.nombre[Formula.generarNumeroRandom(0, 6)];
        this.edad=Formula.generarNumeroRandom(10, 65);
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
    
    
}
