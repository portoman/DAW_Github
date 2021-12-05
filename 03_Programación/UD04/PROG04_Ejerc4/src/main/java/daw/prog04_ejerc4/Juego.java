package daw.prog04_ejerc4;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase principal donde, desde su método main, se implementa un juego que consiste en adivinar un número oculto.
    Al iniciar el programa muestra un menú con distintas opciones: 1. Configurar, 2. Jugar, 3. Salir.
        1. Configurar: Si se indica configurar, se podrá cambiar antes de empezar a jugar, el número de intentos permitidos y el número máximo generado.
        2. Jugar: - Si se indica jugar, se parte de los siguientes valores por defecto: Num intentos=5, Num max=20.
                  - Una vez indicado el 2, el programa empezará a pedir números para que se adivine el número oculto.
                  - Si el usuario lo adivina, saldrá el siguiente mensaje: "Has ganado!. Has necesitado X intentos", indicando el número de intentos.
                  - Si se consume el número de intentos, se indicará este otro mensaje: "Perdiste!. Intentos consumidos".
                  - En cada intento, si el usuario no adivina el número se le proporcionará una pista, por ejemplo, "El número oculto es menor".
                  - Pierda o gane, la siguiente opción será mostrar el menú
        3. Salir: El programa finaliza.
    Aunque se indique que no es necesaria, se incluye la comprobación de que el valor introducido sea un número.
 */
public class Juego {

    public static void main(String[] args) {
        int opcion;

        Scanner teclado = new Scanner(System.in);
        boolean semaforo = false;

        //Bucle do-while: Si no se teclea un número, se repite la petición, activando el boolean semaforo
        do {
            //Inicio excepción para comprobar que el valor introducido es un número
            try {
                //Bucle do-while: Mientras no se eliga la opción 3, no se sale del juego
                do {
                    System.out.println("Seleccione una opcion: \n 1.Configurar \n 2.Jugar \n 3.Salir");

                    opcion = teclado.nextInt();
                    //Predefinición de los valores de número de intentos y número máximo generado
                    int numInt = 5;
                    int numMax = 10;
                    switch (opcion) {
                        //Opción 1
                        case 1:
                            System.out.println("Introduzca número de intentos permitidos: ");
                            numInt = teclado.nextInt();
                            System.out.println("Introduzca el número máximo generado: ");
                            numMax = teclado.nextInt();
                        //Opción 2: Jugar
                        case 2:
                            //Cálculo aleatorio del número oculto
                            int numOculto = (int) Math.floor(Math.random() * numMax + 1);

                            //Bucle for para permitir adivinar en los numeros de intentos elegidos o por defecto
                            for (int i = 1; i <= numInt; i++) {
                                System.out.println("Adivina el número oculto:");
                                int numero = teclado.nextInt();
                                if (numOculto == numero) {
                                    System.out.println("Has ganado!. Has necesitado " + i + " intentos \n");
                                    break;
                                } else {
                                    //Mensaje de pista, si se falla
                                    String pista = numOculto > numero ? "El número oculto es mayor \n" : "El número oculto es menor \n";
                                    System.out.println(pista);
                                }
                                //Condicional para que cuando se alcance el número máximo de intentos, salga el mensaje de abajo
                                if (i == numInt) {
                                    System.out.println("Perdiste!. Intentos consumidos \n");
                                }
                            }
                        //Opción 3: Salir
                        case 3:
                            //Asignación de valor false al semáforo, para el caso de que se haya introducido un valor no numérico, estando en true
                            semaforo = false;
                            break;
                    }
                    //Mientras no se pulse 3, no se para el juego
                } while (opcion != 3);
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número");
                teclado.nextLine();
                //Asignación de valor true, para que se repita el menú
                semaforo = true;
            }
        } while (semaforo);
    }

}
