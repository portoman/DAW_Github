package daw.practicainstanciacionobjetos;

public class Formula {
    
    public static int  generarNumeroRandom(int min, int max) {
        
        return (int) Math.floor(Math.random() *(max-min)+min+1);
    }
    
}
