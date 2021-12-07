package daw.prog04_ejercicio2_practicaexamen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewMain {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        try {
            for (int i = 0; i <= 5; i++) {
                System.out.println("Introduzca un número: ");
                int numero = teclado.nextInt();

                if (numero < 0) {
                    System.out.println("El número es negativo");
                    break;
                } else {
                    System.out.println(primo(numero));
                };
            }

        } catch (InputMismatchException e) {
            System.out.println("Eso no es un número");
            teclado.nextLine();
        }
}
public static String primo(int num) {
        int contador = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                contador++;
            }
        }
        String primo1 = contador > 1 ? "El número no es primo" : "El número es primo";
        return primo1;
    };

}
