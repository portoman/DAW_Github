package daw.poo_2_discoduro;

public class Raices {

    public double a, b, c;

    public Raices(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double solucion1() {
        return -this.b + getDiscriminante() / 2 * this.a;
    }

    public double solucion2() {
        return -this.b - getDiscriminante() / 2 * this.a;
    }

    public void obtenerRaices() {
        System.out.println("La solución 1 es: " + solucion1() + "\nLa solución 2 es: " + solucion2());
    }

    public void obtenerRaiz() {
        if (solucion1() == solucion2()) {
            System.out.println("La solución es única y es esta: " + solucion1());
        } else {
            System.out.println("La solución no es única");
        }
    }

    public double getDiscriminante() {
        return (Math.pow(b, 2) - 4 * a * c);
    }
//    double solucion1 = -b + (Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
//    double solucion2 = -b - Math.sqrt(Math.pow(b, 2) - 4 * a * c) / 2 * a;

    
    public boolean tieneRaices(){
        return getDiscriminante()>=0;
    }
    
    public boolean tieneRaiz(){
        return getDiscriminante()==0;
    }
    
}
