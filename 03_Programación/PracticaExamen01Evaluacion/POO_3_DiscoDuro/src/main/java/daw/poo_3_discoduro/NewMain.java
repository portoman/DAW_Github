package daw.poo_3_discoduro;

public class NewMain {

    public static void main(String[] args) {
        
        
        
        Estudiante e1=new Estudiante();
        
        System.out.println(e1.presencia());
        
        Profesor  p1=new Profesor();
        
        System.out.println(p1.presencia());
        System.out.println(p1.materia);
        
        System.out.println(Math.ceil(Math.random()*10));
       
        System.out.println(Metodos.generaNumeroRandom(2, 5));
    }
    
}
