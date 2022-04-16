package daw.serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serializadora {

    private ObjectInputStream lectorDeObjetos;
    private ObjectOutputStream escritorDeObjetos;

    public void escribirObjeto(Object objeto) {
        try {
            escritorDeObjetos = new ObjectOutputStream(new FileOutputStream("objeto.dat"));
            escritorDeObjetos.writeObject(objeto);
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe");
        } catch (IOException ex) {
            System.out.println("Probablemente no tenemos permiso de escritura");
        }
    }

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
