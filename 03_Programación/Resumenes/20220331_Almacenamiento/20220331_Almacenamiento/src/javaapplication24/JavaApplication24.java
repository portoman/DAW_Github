package javaapplication24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


/*
Clase File-> permite manipular ficheiros e carpetas vistos dende fóra, sen acceder ao seu contido.
Clase FileReader-> permite ler o contido dun ficheiro supoñendo que o que hai nel son caracteres.
Clase BufferedReader-> aumentará as posibilidades de manipulación de FileReader.
Checked exceptions->  son excepcións que Java nos obriga a considerar porque se comproba que estean tratadas en tempo de compilación. 
No caso que nos ocupa, aparece a necesidade de tratar FileNotFoundException e IOException, porque pode suceder que o ficheiro ao que queremos 
acceder non exista ou non teñamos permisos de lectura. 
Os ficheiros son recursos externos ao noso programa e hai que asegurar que é posible a súa manipulación.
 */
public class JavaApplication24 {

    public static void main(String[] args) {
        //Map, diccionario
        HashMap<String, String> persoas = new HashMap<String, String>();

        // LECTURA en memoria de la información ya guardada en un fichero
        try {
            BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
            //El fichero puede estar vacío
            String dni = br.readLine(); 
            while (dni != null) {
                String nome = br.readLine();
                //Se incluye toda la info en el hashmap que hubiese en el fichero
                persoas.put(dni, nome);
                dni = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            System.out.println("Problema con el fichero");
        }

        // MANIPULACIÓN de la información en memoria
        Scanner teclado = new Scanner(System.in);
        while (true) {
            System.out.println("Introduce dni: ");
            String dniIntroducido = teclado.nextLine();
            if (dniIntroducido.equals("fin")) {
                break;
            }
            System.out.println("Introduce nome: ");
            String nomeIntroducido = teclado.nextLine();

            //Con put, si la clave ya existe, se sobreescribe el valor
            persoas.put(dniIntroducido, nomeIntroducido);
        }

        // ESCRITURA en el fichero de la información modificada
        try {
            //Creación del fichero
            FileWriter fw = new FileWriter("datos.txt");
            //Para recorrer el hashmap 
            for (String dni : persoas.keySet()) {
                fw.write(dni + "\n" + persoas.get(dni) + "\n");
            }
            //Cierre
            fw.close();
        } catch (IOException ex) {
            System.out.println("No hay permisos de escritura");
        }
        
        //Salida de datos por consola
        for (String dni : persoas.keySet()) {
            System.out.println("DNI: " + dni + "\n" + "persona " + persoas.get(dni) + "\n");
        }
    }

}
