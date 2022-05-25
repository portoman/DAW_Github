package javaapplication26;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JavaApplication26 {

    public static void main(String[] args) {
        //File: Manipulamos los ficheros y carpetas sin entrar en el contenido
        File carpeta = new File(".");
        //Array de 2 bytes
        byte[] buffer = new byte[2];
        //Variable leidos, da el número de archivos leidos. Explicado por encima
        int leidos;

        //Si carpeta es un directorio
        if (carpeta.isDirectory()) {
            //Bucle para recorrer todos los ficheros
            for (File fichero : carpeta.listFiles()) {
                // Ver si el fichero contiene o no una imagen JPG mirando los 2 primeros bytes
                if (fichero.isFile()) {
                    try {
                        //Abrir un archivo en binario, en bruto. No nos importa el contenido, solo los bytes
                        FileInputStream fis = new FileInputStream(fichero);
                        //Leer: El metodo read coloca los 2 bytes en el array creado
                        leidos = fis.read(buffer);
                        System.out.print("El ficheiro " + fichero.getName() + " ");
                        //Un fichero JPEG en los 2 primeros bytes tiene estos 2 valores: 0xFF, 0xD8 (Viene en la wikipedia)
                        if (buffer[0] == (byte) 0xFF && buffer[1] == (byte) 0xD8) {
                            System.out.println("El fichero es un JPG");
                        } else {
                            System.out.println("El fichero no es un JPG");
                        }

                        //Cerrar
                        fis.close();
                        System.out.println("Leidos: " + leidos);
                    } catch (FileNotFoundException ex) {
                        System.out.println("No existe el fichero");
                    } catch (IOException ex) {
                        System.out.println("No fue posible leer");
                    }

                }

            }

        }

    }

}
