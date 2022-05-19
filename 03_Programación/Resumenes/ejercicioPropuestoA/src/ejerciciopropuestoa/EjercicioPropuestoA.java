/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopropuestoa;

/**
 *
 * @author portb
 */
public class EjercicioPropuestoA {

    /**
     * Dada unha colección de números, quérese un resumo que inclúa cantos son,
     * cal é o valor máximo, o mínimo e o valor medio.
     *
     * ) Os números son enteiros e almacénanse nun array ao principio do
     * programa (int[] datos = {3,8,45,62,141,23};)
     */
    public static void main(String[] args) {

        int[] datos = {3, 8, 45, 62, 141, 23};

        int menor = datos[0];
        int mayor = datos[0];
        int suma = 0;

        for (int i = 0; i < datos.length; i++) {

            if (datos[i] < menor) {
                menor = datos[i];
            }
            if (datos[i] > mayor) {
                mayor = datos[i];
            }
            suma = suma + datos[i];

        };

        double medio = (double) suma / datos.length;
        System.out.println(menor);
        System.out.println(mayor);
        System.out.println(medio);

    }

}
