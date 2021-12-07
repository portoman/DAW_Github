package daw.poo_3_discoduro;

public class Estudiante extends Persona{
    
    int calificacion;
    
     int probabilidad=50;
    
    public boolean presencia(){
        return ((Math.random()*100)<=probabilidad);
    };


}
