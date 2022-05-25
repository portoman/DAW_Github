/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previaejerciciof;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * Se modifican estos métodos con serializables
 */
public class Datos {

    //Método para escribir los datos creados
    public static void escribir(ArrayList<Persona> personas, File file) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(personas);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Non foi posible escrir no ficheiro " + file.getAbsolutePath());
        }

    }

    //Método para leer los datos guardados
    public static ArrayList<Persona> leer(File f) {
        ArrayList<Persona> personas = new ArrayList<Persona>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            personas = (ArrayList<Persona>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            System.out.println("Non se puido ler o ficheiro " + f.getAbsolutePath());
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema coas clases");
        }

        return personas;
    }

}
