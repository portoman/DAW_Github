package daw.prog04_ejerc1;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase principal donde, desde su método main, se pide un número entero menor que 30 y se imprime la tabla 
    de multipiclar con 3 bucles diferentes. Si es mayor o igual que 30, se muestra un mensaje en pantalla y finaliza 
    el programa. Aunque se indique que no es necesaria, se incluye la comprobación de que el valor introducido 
    sea un número.
 */
public class TablaMultiplicar {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Teclea un numero entero: ");

        //Inicio excepción para comprobar que el valor introducido es un número
        try {
            int numero = teclado.nextInt();
            
            //Condición para que se realice la tabla solo si el número es menor que 30
            if (numero < 30) {
                System.out.println("Bucle for:");
                //Bucle for
                for (int i = 0; i <= 10; i++) {
                    System.out.println(numero * i);
                }
                
                
                System.out.println("Bucle while:");
                int i = 1;
                //Bucle while
                while (i <= 10) {
                    System.out.println(numero * i);
                    i++;
                }

                System.out.println("Bucle do-while:");
                i = 1;
                //Bucle do-while
                do {
                    System.out.println(numero * i++);
                } while (i <= 10);
            } else {
                //Mensaje si el número es mayor o igual que 30
                System.out.println("El número debe ser menor que 30");
            }
        } catch (InputMismatchException e) {
            System.out.println("Eso no es un número");
        }
    }
}
