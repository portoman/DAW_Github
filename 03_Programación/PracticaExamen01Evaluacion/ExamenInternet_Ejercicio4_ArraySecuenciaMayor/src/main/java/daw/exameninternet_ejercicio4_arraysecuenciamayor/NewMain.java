package daw.exameninternet_ejercicio4_arraysecuenciamayor;

public class NewMain {

    public static void main(String[] args) {

        int[] a1 = {2, 2, 5, 5, 5, 5, 5, 5, 4, 4};
        System.out.println(secuenciaMayor(a1));
    }

    public static int secuenciaMayor(int[] a1) {
        int contador = 0;

        for (int i = 0; i < a1.length; i++) {
            if (i > 1) {
                if (a1[i - 1] == a1[i]) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
