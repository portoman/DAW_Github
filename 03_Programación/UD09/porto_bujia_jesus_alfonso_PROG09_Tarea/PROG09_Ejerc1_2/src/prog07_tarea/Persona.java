package prog07_tarea;

import java.io.Serializable;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase que contiene la información sobre los datos personales básicos del cliente (nombre, apellidos, DNI) e implementa la interfaz imprimible
 */
public class Persona implements Imprimible, Serializable {

    //Atributos
    private String nombre;
    private String apellidos;
    private String DNI;

    //Constructor
    public Persona(String nombre, String apellidos, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
    }

    ///Getters y Setters
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    //Método implementado por la interfaz Imprimible que devuelve la información de una persona como una cadena de caracteres
    @Override
    public String devolverInfoString() {
        return "nombre: " + nombre + ", apellidos: " + apellidos + ", DNI: " + DNI;
    }

}
