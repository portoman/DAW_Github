package ejerciciopropuestob;

import java.util.Scanner;

/**
 *
 * @author portb
 */
public class EjercicioPropuestoB {

    /**
     * (b) Os números introdúcense polo teclado, non se van almacenando en
     * ningunha estrutura de memoria e finalmente amósanse os resultados
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] datos = new int[5];

        for (int i = 0; i < datos.length; i++) {
            System.out.println("Introduce un número: ");
            datos[i] = teclado.nextInt();
        }

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
