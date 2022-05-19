/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopropuestoc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Os números introdúcense polo teclado, almacénanse nunha lista e cando o
 * usuario indique que rematou, calcúlanse e amósanse os resultados
 */
public class EjercicioPropuestoC {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Integer> lista = new ArrayList<Integer>();
        boolean semaforo = true;
        int numero;
        while (semaforo) {
            System.out.println("Introduce un número: ");
            numero = teclado.nextInt();
            if (numero == 0) {
                break;
            }
            lista.add(numero);
        }

        int menor = lista.get(0);
        int mayor = lista.get(0);
        int suma = 0;

        for (int numero2 : lista) {
            if (numero2 < menor) {
                menor = numero2;
            }
            if (numero2 > mayor) {
                mayor = numero2;
            }
            suma = suma + numero2;
        };

        double medio = (double) suma / lista.size();
        System.out.println(lista);
        System.out.println(menor);
        System.out.println(mayor);
        System.out.println(medio);
    }
;

}
