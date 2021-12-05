package daw.prog04_ejerc3;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase principal donde, desde su método main, se piden 2 números y se calcula el Mínimo Común Múltiplo(MCM) de ellos.
    Comprueba que ambos números son positivos, mostrando mensaje y finalizando el programa si no lo son.
    Aunque se indique que no es necesaria, se incluye la comprobación de que el valor introducido sea un número.
 */
public class MCM {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        //Inicio excepción para comprobar que el valor introducido es un número
        try {

            System.out.println("Teclee el primer número:");
            int x = teclado.nextInt();

            System.out.println("Teclee el segundo número:");
            int y = teclado.nextInt();

            //Condicional para comprobar que los números son positivos
            if (x > 0 & y > 0) {
                //MCM
                int mcm = mcm(x, y);

                System.out.println("El MCM es: " + mcm);
            } else {
                System.out.println("Los números no son positivos");
            }
        } catch (InputMismatchException e) {
            System.out.println("Eso no es un número");
            teclado.nextLine();
        }

    }

    public static int mcm(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int resultado = (a / mcd(num1, num2) * b);

        return resultado;

    }

    public static int mcd(int num1, int num2) {

        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int resultado = 0;
        do {
            resultado = b;
            b = a % b;
            a = resultado;
        } while (b != 0);

        return resultado;
    }

}
