package proposto03g;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Datos {
    public static ArrayList<Persoa> ler(File f) {
        ArrayList<Persoa> persoas = new ArrayList<Persoa>();
        try {
            BufferedReader ficheiro = new BufferedReader(new FileReader(f));
            String linea;
            while((linea = ficheiro.readLine()) != null) {
               persoas.add(new Persoa(linea.split(";")[0], Integer.parseInt(linea.split(";")[1]))); 
            }
        } catch (IOException ex) {
            System.out.println("Non se puido ler o ficheiro " + f.getAbsolutePath());
        }
        return persoas;
    }
    
    public static void escribir(ArrayList<Persoa> datos, File f) {
        try {
            FileWriter fw = new FileWriter(f);
            for (Persoa dato : datos) {
                //Los datos se guardan con un ";" para que se distribuyan en columnas
                fw.write(dato.getNome() + ";" + dato.getIdade() + "\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Non foi posible escrir no ficheiro " + f.getAbsolutePath());
        }
    }
}
