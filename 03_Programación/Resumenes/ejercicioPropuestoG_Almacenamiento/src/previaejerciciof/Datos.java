/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previaejerciciof;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author portb
 */
public class Datos {

    // ESCRIBIR:Escribimos los datos en un excel para que se distribuya en columnas con ";"
    public static void escribir(ArrayList<Persona> personas, File file) {

        try {
            FileWriter fw = new FileWriter(file);
            for (Persona p : personas) {
                fw.write(p.getNombre() + ";" + p.getEdad() + "\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("No fue posible escribir en el fichero");
        }

    }

    //LEER: Leemos los datos del excel teniendo en cuenta el split.
    public static ArrayList<Persona> leer(File f) {
        ArrayList<Persona> personas = new ArrayList<Persona>();
        try {
            BufferedReader fichero = new BufferedReader(new FileReader(f));
            String linea;
            while ((linea = fichero.readLine()) != null) {
                personas.add(new Persona(linea.split(";")[0], Integer.parseInt(linea.split(";")[1])));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException ex) {
            System.out.println("No se puede leer el fichero");
        }

        return personas;
    }

}
