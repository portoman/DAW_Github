package prog07_tarea.cuentas;

import java.io.Serializable;
import prog07_tarea.Imprimible;
import prog07_tarea.Persona;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase donde hay una composición, ya que se incluye la clase Persona en ella.  También se implementa la interfaz Imprimible y Serializable.
Será la clase padre de las diferentes cuentas bancarias: Cuentas corrientes y cuenta ahorro.
De acuerdo con el ejercicio 1 de la tarea de la unidad 9, para poder serializar las cuentas implementamos la interfaz Serializable 
 */
public abstract class CuentaBancaria implements Imprimible, Serializable {

    //Atributos
    private Persona persona;
    private double saldo;
    private String IBAN;

    //Constructor donde para evitar que existan dos referencias al mismo objeto Persona, se crea uno nuevo mediante la copia del objeto (llamando a los métodos get)
    public CuentaBancaria(Persona persona, double saldo, String IBAN) {
        Persona personaNueva = new Persona(persona.getNombre(), persona.getApellidos(), persona.getDNI());
        this.persona = personaNueva;
        this.saldo = saldo;
        this.IBAN = IBAN;
    }

    //Getter y Setters
    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Método implementado por la interfaz Imprimible que devuelve la información de una cuenta como una cadena de caracteres
    @Override
    public String devolverInfoString() {
        return persona.devolverInfoString() + ", saldo: " + saldo + " €, IBAN: " + IBAN;
    }

}
