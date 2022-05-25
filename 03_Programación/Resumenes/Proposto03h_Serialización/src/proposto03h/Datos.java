package proposto03h;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//Solo varian los métodos y en la clase Persona, poner serializable
public class Datos {

    //Método para leer los datos guardados
    public static ArrayList<Persoa> ler(File f) {
        ArrayList<Persoa> persoas = new ArrayList<Persoa>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            persoas = (ArrayList<Persoa>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            System.out.println("Non se puido ler o ficheiro " + f.getAbsolutePath());
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema coas clases");
        }
        return persoas;
    }

    //Método para escribir los datos creados
    public static void escribir(ArrayList<Persoa> datos, File f) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(datos);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Non foi posible escrir no ficheiro " + f.getAbsolutePath());
        }
    }
}
