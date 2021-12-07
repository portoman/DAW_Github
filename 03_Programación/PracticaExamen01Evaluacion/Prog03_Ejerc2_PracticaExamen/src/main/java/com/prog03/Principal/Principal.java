package com.prog03.Principal;

import com.prog03.figuras.Rectangulo;

public class Principal {

    public static void main(String[] args) {

        Rectangulo r1 = new Rectangulo(5, 6);
        Rectangulo r2 = new Rectangulo(4, 6);

        Rectangulo r3 = new Rectangulo(3, 3);
        
        System.out.println();

        System.out.println(r3.isCuadrado());
        
        
        System.out.println(r3.toString());
    }

}
