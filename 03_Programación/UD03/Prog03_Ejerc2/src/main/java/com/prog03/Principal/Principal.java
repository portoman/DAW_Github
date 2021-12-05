package com.prog03.Principal;

import com.prog03.figuras.Rectangulo;

public class Principal {

    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo(5, 5);
        Rectangulo r2 = new Rectangulo(3, 6);
        Rectangulo r3 = new Rectangulo(2, 8);
        Rectangulo r4 = new Rectangulo();

        r4.setAltura(8);
        r4.setBase(7);

        //Comprobaciones
        System.out.println("r4 tiene una base de: " + r4.getBase() + " y una altura: " + r4.getAltura());

        r4.setAltura(5);
        r4.setBase(4);

        System.out.println("Cambio de valores: Ahora r4 tiene una base de: " + r3.getBase() + " y una altura: " + r3.getAltura());
        System.out.println("****************");

        System.out.println("El área de r1 es: " + r1.getArea());
        System.out.println("El área de r2 es: " + r2.getArea());
        System.out.println("El área de r3 es: " + r3.getArea());
        System.out.println("El área de r4 es: " + r4.getArea());
        System.out.println("****************");

        System.out.println("r1 tiene " + r1.toString());
        System.out.println("r2 tiene " + r2.toString());
        System.out.println("r3 tiene " + r3.toString());
        System.out.println("r4 tiene " + r4.toString());

        System.out.println("****************");

        System.out.println("r1: " + (r1.isCuadrado() ? "Es cuadrado" : "No es cuadrado"));
        System.out.println("r2: " + (r2.isCuadrado() ? "Es cuadrado" : "No es cuadrado"));
        System.out.println("r3: " + (r3.isCuadrado() ? "Es cuadrado" : "No es cuadrado"));
        System.out.println("r4: " + (r4.isCuadrado() ? "Es cuadrado" : "No es cuadrado"));

    }

}
