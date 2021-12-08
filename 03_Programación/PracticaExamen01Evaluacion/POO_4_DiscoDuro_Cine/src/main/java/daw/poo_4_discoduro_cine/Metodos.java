package daw.poo_4_discoduro_cine;

public class Metodos {

    public static int generaNumeroRandom(int min, int max) {
        return (int) Math.floor(Math.random() * (min - (max + 1)) + (max + 1));

    }
}
