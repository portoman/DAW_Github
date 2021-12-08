package daw.practicainstanciacionobjetos;

public class Clase {

    Alumno[] alumnos;
    int numAlumnos=50;
    
    public Clase() {
        
        this.alumnos=new Alumno[numAlumnos];
        
        creaAlumnos(numAlumnos);
    }

    public void imprimir() {
        for (int i=0;i<alumnos.length;i++){
            System.out.println("Clase{" + "alumnos=" + alumnos[i].toString());
    };
    }
    
    public void creaAlumnos(int numAlumnos){
        for(int i = 0; i < numAlumnos; i++){
            this.alumnos[i] = new Alumno();
    }
}
}
