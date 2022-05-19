/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuestod;

import java.util.ArrayList;

/**
 *
 * @author portb
 */
public class Calculos {

    static int cantos(ArrayList<Integer> lista) {
        return lista.size();
    }

    static int max(ArrayList<Integer> lista) {
        int max = 0;
        for (int numero : lista) {
            if (numero > max) {
                max = numero;
            }
        }
        return max;
    }
    
     static int min(ArrayList<Integer> lista) {
        int min = 0;
        for (int numero : lista) {
            if (numero < min) {
                min = numero;
            }
        }
        return min;
    }

      static double media(ArrayList<Integer> lista) {
        
         int suma = 0;

        for (int numero2 : lista) {
            suma = suma + numero2;
        };
        double medio = (double) suma / lista.size();
        return medio;
    }
     
}
