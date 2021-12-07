package daw.mcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MCM {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Teclee el primer número: ");

        int num1 = teclado.nextInt();

        System.out.println("Teclee el segundo número: ");

        int num2 = teclado.nextInt();

        int max = Math.max(num1, num2);

        while ((max % num1 != 0) || (max % num2 != 0)) {
            max++;
        }

        System.out.println("El MCM es: "+max);
int numero=7;
        if (numero % 2 == 0)
System.out.print("El número es par /n");
    }

}
