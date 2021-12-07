package daw.prog04_ejercicio1_practicaexamen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewMain {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            System.out.println("Escribe un número: ");
            int num = teclado.nextInt();

            for (int i = 0; i < num; i++) {
                int mult = num * i;
                System.out.println("Número: " + num + " multiplicado por " + i + " es " + mult);
            }

            int i = 0;
            while (i <= num) {

                int mult = num * i;
                System.out.println("Número: " + num + " multiplicado por " + i + " es " + mult);
                i++;
            }
            
            i=0;
            do{
                int mult = num * i;
                System.out.println("Número: " + num + " multiplicado por " + i + " es " + mult);
                i++;
            }while(i<=num);

        } catch (InputMismatchException e) {
            System.out.println("Esto no es un número");
            teclado.nextLine();
        }
    }

}
