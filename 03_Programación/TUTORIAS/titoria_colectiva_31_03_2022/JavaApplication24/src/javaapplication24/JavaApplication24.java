package javaapplication24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class JavaApplication24 {

    public static void main(String[] args) {
        HashMap<String, String> persoas = new HashMap<String, String>();

        // LECTURA a memoria da información gardada nun ficheiro
        try {
            BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
            String dni = br.readLine(); //o ficheiro podería estar baleiro
            while (dni != null) {
                String nome = br.readLine();
                persoas.put(dni, nome);
                dni = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            System.out.println("Problema co ficheiro");
        }

        // MANIPULACIÓN da información en memoria
        Scanner teclado = new Scanner(System.in);
        while (true) {
            System.out.println("Introduce dni: ");
            String dniIntroducido = teclado.nextLine();
            if (dniIntroducido.equals("fin")) {
                break;
            }
            System.out.println("Introduce nome: ");
            String nomeIntroducido = teclado.nextLine();

            persoas.put(dniIntroducido, nomeIntroducido);
        }

        // ESCRITURA nun ficheiro da información modificada
        try {
            FileWriter fw = new FileWriter("datos.txt");
            for (String dni : persoas.keySet()) {
                fw.write(dni + "\n" + persoas.get(dni) + "\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Non hai permisos de escritura");
        }
    }
}