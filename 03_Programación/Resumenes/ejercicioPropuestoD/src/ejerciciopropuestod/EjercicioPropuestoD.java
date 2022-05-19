/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopropuestod;

import java.util.ArrayList;
/**
 *
 * Igual que no caso anterior, pero creando unha clase de nome Cálculos con
 * métodos capaces de recibir unha lista cos números introducidos e devolver un
 * resultado (cantos(), max(), min(), media()).
 */
public class EjercicioPropuestoD {

    public static void main(String[] args) {
        
        ArrayList<Integer>lista=new ArrayList<Integer>();
        
        lista.add(3);
        lista.add(8);
        lista.add(45);
        lista.add(62);
        lista.add(141);
        lista.add(23);
        
        System.out.println(Calculos.cantos(lista));
        System.out.println(Calculos.max(lista));
        System.out.println(Calculos.min(lista));
        System.out.println(Calculos.media(lista));
        
        
    }

}
