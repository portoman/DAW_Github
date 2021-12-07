package daw.poo_3_discoduro;

public class Metodos {
    
    public static int generaNumeroRandom(int min, int max){
        return (int)Math.floor(Math.random()*(min-(max+1))+(max+1));
    }
}
