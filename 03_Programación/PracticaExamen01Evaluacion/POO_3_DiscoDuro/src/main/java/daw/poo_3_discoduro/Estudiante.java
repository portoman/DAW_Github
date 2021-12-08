package daw.poo_3_discoduro;

public class Estudiante extends Persona {

    private int calificacion;

    private final int PROBABILIDAD = 50;

    public boolean presencia() {
        return ((Math.random() * 100) <= PROBABILIDAD);
    }

    ;
    boolean presente=presencia();
    
    public Estudiante() {
        super();

        calificacion = Metodos.generaNumeroRandom(0, 10);

        super.setEdad(Metodos.generaNumeroRandom(10, 18));

    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    @Override
    public String toString() {
        
        return super.toString()+"Estudiante{" + "calificacion=" + calificacion + ", presente=" + presente + '}';
    }

}
