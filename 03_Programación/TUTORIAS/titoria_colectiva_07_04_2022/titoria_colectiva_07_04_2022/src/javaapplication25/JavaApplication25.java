
package javaapplication25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication25 {

    public static void main(String[] args) {
        File carpeta = new File(".");
        if(carpeta.isDirectory()) {
            for (File f : carpeta.listFiles()) {
                System.out.println((f.isDirectory()?"D":"F") + "-" + f.getName());
                // no caso dos ficheiros queremos ver o seu contido
                if(f.isFile()) {
                    try {
                        FileReader fr = new FileReader(f);
                        // como detectar o fin do ficheiro?
                        // para FileReader imos usar BufferedReader
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        while((linea=br.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (FileNotFoundException ex) {
                        System.out.println("O ficheiro non existe");
                    } catch (IOException ex) {
                        System.out.println("Probablemente non temos permiso de lectura");
                    }
                }
            }

        }


        
        
    }
    
}
