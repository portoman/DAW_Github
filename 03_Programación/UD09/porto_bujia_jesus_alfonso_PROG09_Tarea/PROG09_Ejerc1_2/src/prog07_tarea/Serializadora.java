package prog07_tarea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase cuyos objetos se encargarán de guardar la información deseada en el disco duro y recuperarla.
 */
public class Serializadora {

    //Atributo para leer objetos
    private ObjectInputStream lectorDeObjetos;
    //Atriburo para escribir objetos
    private ObjectOutputStream escritorDeObjetos;

    //Método que permite guardar información, pasándole un objeto, en el archivo datoscuentasbancarias.dat
    public void escribirObjeto(Object objeto) {
        try {
            escritorDeObjetos = new ObjectOutputStream(new FileOutputStream("datoscuentasbancarias.dat"));
            escritorDeObjetos.writeObject(objeto);
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe");
        } catch (IOException ex) {
            System.out.println("Probablemente no tenemos permiso de escritura");
        }
    }

    //Método que permite recuperar información del archivo que le pasemos como parámetro
    public Object leerObjeto(String nombreDelArchivo) {
        Object devolucion = null;
        try {
            lectorDeObjetos = new ObjectInputStream(new FileInputStream(nombreDelArchivo));
            devolucion = lectorDeObjetos.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe");
        } catch (IOException ex) {
            System.out.println("Probablemente no tenemos permiso de escritura");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
        }
        return devolucion;
    }

}
