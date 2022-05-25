package javaapplication27;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class JavaApplication27 {

    public static void main(String[] args) {
        //Lectura inicial de los objetos almacenados
        HashMap<String, ContaBancaria> contas = leer();

        //Tratamiento de la información
        //  Visualización de las cuentas que estaban almacenadas
        for (String iban : contas.keySet()) {
            System.out.println(contas.get(iban));
        }
        //  Creación de una nueva cuenta cada vez que se ejecute
        contas.put("ES" + Math.random() * 1000, new ContaBancaria("abc", "abcssssss", "abc", 1000));

        //Almacenamiento final como objeto
        guardar(contas);
        //Almacenamiento final como texto
        guardarListado(contas);
    }

    //Método para almacenar los objetos almacenados en el HashMap. Serialización
    public static void guardar(HashMap<String, ContaBancaria> contas) {
        try {
            //Abrir
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos.dat"));
            //Escribir
            oos.writeObject(contas);
            //Cerrar
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Non existe o ficheiro");
        } catch (IOException ex) {
            System.out.println("Non foi posible escribir no ficheiro");
        }
    }

    //Método para leer los objetos almacenados
    public static HashMap<String, ContaBancaria> leer() {
        try {
            //Abrir
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datos.dat"));
            //Leer. Con Casting, para convertirlo en un HashMap
            HashMap<String, ContaBancaria> cuentas = (HashMap<String, ContaBancaria>) ois.readObject();
            //Cerrar
            ois.close();
            //Devolución de las cuentas
            return cuentas;
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero");
        } catch (IOException ex) {
            System.out.println("No fue posible leer del fichero");
        } catch (ClassNotFoundException ex) {
            System.out.println("La clase del objeto no es correcta");
        }
        //Si hay algún problema, devuelve un Hashmap vacio
        return new HashMap<String, ContaBancaria>();
    }

    //Método para guardar los datos de las cuentas en un archivo en forma de texto
    public static void guardarListado(HashMap<String, ContaBancaria> contas) {
        try {
            //Abrir un ficheiro de caracteres
            FileWriter fw = new FileWriter("listado.txt");
            //Escribir
            for (String iban : contas.keySet()) {
                fw.write(contas.get(iban).toString() + "\n");
            }
            //Cerrar
            fw.close();
        } catch (IOException ex) {
            System.out.println("No fue posible escribir en el fichero");
        }
    }
}
