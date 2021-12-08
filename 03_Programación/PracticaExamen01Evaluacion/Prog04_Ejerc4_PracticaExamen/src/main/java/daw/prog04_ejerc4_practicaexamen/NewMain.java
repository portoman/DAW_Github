package daw.prog04_ejerc4_practicaexamen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewMain {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        int numInt = 5;
        int numMax = 20;

        while (opcion != 3) {
            System.out.println("Selecciona una opción:\n"
                    + "1.Configurar\n"
                    + "2.Jugar\n"
                    + "3.Salir ");

            try {
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Seleccione número de intentos permitidos: ");
                        numInt = teclado.nextInt();

                        System.out.println("Selecione el número máximo generado");
                        numMax = teclado.nextInt();

                    case 2:
                        int numOculto = (int) Math.floor(Math.random() * numMax + 1);
                        int i=0;
                        while(i<numInt){
                             i++;
//                        for ( i = 1; i <= numInt; i++) {
                            System.out.println("Adivina el número oculto: ");
                            int numInsert = teclado.nextInt();
                            if(numInt==i){
                                 System.out.println("Perdiste!Intentos consumidos");
                            break;
                            }
                            if (numOculto == numInsert) {
                                System.out.println("Has ganado! Has necesitado " + i + " intentos");
                                break;
                            } else if (numOculto < numInsert) {
                                System.out.println("El número oculto es menor");
                            } else if(numOculto > numInsert){
                                System.out.println("El número oculto es mayor");
                            } 
                        
                        }                        
                    case 3: break;
                    
                }

            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número");
                teclado.nextLine();
            }

        }

    }

}
