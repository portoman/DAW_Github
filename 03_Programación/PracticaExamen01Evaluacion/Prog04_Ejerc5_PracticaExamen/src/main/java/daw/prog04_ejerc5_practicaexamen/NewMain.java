package daw.prog04_ejerc5_practicaexamen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewMain {

    public static void main(String[] args) {
        
        Scanner teclado=new Scanner(System.in);
        
        int divisor=0, dividendo=0;
            while(divisor!=-1&&dividendo!=-1){
        try{

            
            System.out.println("Introduce el dividendo: ");
            dividendo=teclado.nextInt();
            
            System.out.println("Introduce el dividor: ");
            divisor=teclado.nextInt();
            
            int division=dividendo/divisor;
            
            if(divisor!=-1&&dividendo!=-1){
            System.out.println("El resultado es: "+division);
            }else{
                System.out.println("Fin del programa");
            }
            
        }catch(ArithmeticException e){
            System.out.println("El divisor no puede ser cero");
            teclado.nextLine();
    }
        catch(InputMismatchException e){
            System.out.println("Esto no es un número");
            teclado.nextLine();
    }
    }
    }
}
