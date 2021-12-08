package daw.poo_3_discoduro;

import  daw.poo_3_discoduro.Constantes;

public class Profesor extends Persona{
    String materia;
    
   private final int PROBABILIDAD=20;
    
    public boolean presencia(){
        return ((Math.random()*100)>=PROBABILIDAD);
    };
    
    boolean presente=presencia();
    
    public Profesor(){
        super();
        
        super.setEdad(Metodos.generaNumeroRandom(25, 65));
        
        this.materia=Constantes.MATERIAS[Metodos.generaNumeroRandom(0, 2)];
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }


    
    
    }
