package daw.prog04_ejerc2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase principal donde, desde su método main, se piden 5 números y se calculan si son primos, 
    mostrando por pantalla si lo son o no. Primero, comprueba que no son negativos y si lo son, muestra un mensaje. 
    Cuando procesa los 5 números, el programa finaliza. 
    Aunque se indique que no es necesaria, se incluye la comprobación de que el valor introducido sea un número.
 */
public class NumeroPrimo {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            System.out.println("Teclea un número entero:");
            //Inicio excepción para comprobar que el valor introducido es un número
            try {
                int numero = teclado.nextInt();
                //Condicional para saber si el número es negativo
                if (numero < 0) {
                    System.out.println("El numero es negativo, no se admite");
                } else {
                    primo(numero);
                }
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número");
                teclado.nextLine();
            }
        }
    }

    /*
    Método "primo" para calcular si un número es primo:
        Un número es primo si es divisible por 1 y si mismo. 
        El bucle for del método, divide cada número entre todos los números entre si mismo y 1 
        y si el resto de estas divisiones es igual a cero más de 2 veces, querrá decir que no es primo
        y si es menor, querrá decir que es primo. Este resultado se imprime por pantalla
     */
    public static void primo(int numero) {
        int divisores = 0;
        //Divisores será el valor de las veces que se puede dividir un número, entre los números del uno al si mismo
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                divisores++;
            }
        }
        //Si divisores es mayor de 2, no es número primo, si es menor sí
        if (divisores > 2) {
            System.out.println(numero + " no es primo");
        } else {
            System.out.println(numero + " es primo");
        }
    }

}
