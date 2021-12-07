package daw.poo_3_discoduro;

import  daw.poo_3_discoduro.Materia;

public class Profesor extends Persona{
    Materia materia;
    
    int probabilidad=20;
    
    public boolean presencia(){
        return ((Math.random()*100)<=probabilidad);
    };
    }
