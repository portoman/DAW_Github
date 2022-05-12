/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tutoria_20220324;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author portb
 */
public class Tutoria_20220324 {

    public static void main(String[] args) {

        //Array de nombres
        String[] nomes = new String[10];
        System.out.println("La longitud del array es:" + nomes.length);

        //Introducir valores en array
        nomes[0] = "Antonio";
        nomes[3] = "Rosa";

        //ArrayList colección de datos en forma de lista. Se dimensiona dinámicamente
        ArrayList<String> nomesAL = new ArrayList<String>();

        //Introducir valores en un ArrayList
        nomesAL.add("Antonio");
        nomesAL.add("Rosa");
        nomesAL.add("Rosa");
        nomesAL.add("Rosa");

        //Eliminar elementos
        nomesAL.remove("Rosa");//Elimina una Rosa

        System.out.println("Contiene a Rosa: " + nomesAL.contains("Rosa"));
        System.out.println("Está vacio: " + nomesAL.isEmpty());

        if (!nomesAL.isEmpty()) {
            //Bucle en ArrayList
            for (String nombre : nomesAL) {
                System.out.println("El nombre es: " + nombre);
            }
        } else {
            System.out.println("Está vacio");
        }

        System.out.println("########## Conjunto #########");
        //HashSet -Conjunto
        HashSet<String> nombresS = new HashSet<String>();

       
        //No acepta valores repetidos
        nombresS.add("Paco");
        nombresS.add("Paco");
        nombresS.add("Paco");
        System.out.println("Puedes meter otro Paco: "+nombresS.add("Paco"));
        nombresS.add("Oscar");
        System.out.println("Puedes meter un Andrés: "+nombresS.add("Andrés"));

        if (!nombresS.isEmpty()) {
            //Bucle en ArrayList
            for (String nombre : nombresS) {
                System.out.println("El nombre es: " + nombre);
            }
        } else {
            System.out.println("Está vacio");
        }
    }

}
