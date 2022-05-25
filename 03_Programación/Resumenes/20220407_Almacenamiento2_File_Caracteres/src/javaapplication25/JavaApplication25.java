
package javaapplication25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaApplication25 {

    public static void main(String[] args) {
        //Seleccionamos la carpeta donde está el proyecto
        File carpeta = new File(".");
        //Si "carpeta" es un directorio
        if(carpeta.isDirectory()) {
            //Recorremos el contenido
            for (File f : carpeta.listFiles()) {
                //Si el archivo es un fichero "D", si es un archivo "F" junto a su nombre
                System.out.println((f.isDirectory()?"D":"F") + "-" + f.getName());
                
                // Si son archivos, queremos ver su contenido con FileReader - Caracteres
                if(f.isFile()) {
                    try {
                        FileReader fr = new FileReader(f);
                        // Para detectar el final del fichero con FileReader usamos BufferedReader
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        //Asignación combinada con comparación
                        while((linea=br.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (FileNotFoundException ex) {
                        System.out.println("El ficheiro no existe");
                    } catch (IOException ex) {
                        System.out.println("Probablemente no tenemos permiso de lectura");
                    }
                }
            }

        }
        System.out.println("*********************");
        //Impresión solo de los elementos
        if(carpeta.isDirectory()) {
            //Recorremos el contenido
            for (File f : carpeta.listFiles()) {
                //Si el archivo es un fichero "D", si es un archivo "F" junto a su nombre
                System.out.println((f.isDirectory()?"D":"F") + "-" + f.getName());
            }
        }
    }
    
}
