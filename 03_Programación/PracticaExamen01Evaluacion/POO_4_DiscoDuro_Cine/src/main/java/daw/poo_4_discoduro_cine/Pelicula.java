package daw.poo_4_discoduro_cine;

import daw.poo_4_discoduro_cine.Datos;

public class Pelicula {
    
    String titulo_pelicula;
    String edad;
    int duracion;
    String director;
    
    public Pelicula(){
        titulo_pelicula= Datos.titulo_pelicula[Metodos.generaNumeroRandom(0, 5)];
    }
    
}
