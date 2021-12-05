package daw.prog04_ejerc5;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase principal donde, desde su método main, se piden 2 números y se calcula su división.
    El programa solicita números indefinidamente hasta que los dos números solicitados sean -1. 
    Si el dividendo es cero, se controla con una excepción, mostrándose un mensaje por pantalla.
    Aunque se indique que no es necesaria, se incluye la comprobación de que el valor introducido sea un número.
 */
public class Excepcion {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int dividendo = 0;
        int divisor = 0;
        int contador = 0;

        //Bucle do-while: Si no se introducen los 2 valores a -1, el bucle no para
        do {
            //Inicio excepción para comprobar que el valor introducido es un número
            try {
                System.out.println("Introduzca dividendo: ");
                dividendo = teclado.nextInt();

                System.out.println("Introduzca divisor: ");
                divisor = teclado.nextInt();

                //Si los 2 números son -1, se para el programa directamente, sin calcular nada
                if (dividendo == -1 && divisor == -1) {
                    break;
                }
                int resultado = dividendo / divisor;
                System.out.println("El resultado es: " + resultado);
                System.out.println("Numero de divisiones calculadas= " + ++contador);
            } catch (ArithmeticException e1) {
                //Catch para detectar si el divisor es cero
                System.out.println("El divisor es cero, no se puede realizar la división");
                teclado.nextLine();
            } catch (InputMismatchException e2) {
                //Catch para detectar si el número no es un número
                System.out.println("Eso no es un número");
                teclado.nextLine();
            }

        } while (dividendo != -1 & divisor != -1);

    }

}
