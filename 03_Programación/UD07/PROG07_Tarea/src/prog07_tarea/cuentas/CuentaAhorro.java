package prog07_tarea.cuentas;

import prog07_tarea.Persona;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Subclase que hereda de la clase CuentaBancaria que tiene como atributo propio el tipoInteres
 */
public class CuentaAhorro extends CuentaBancaria {

    //Atributo
    private double tipoInteres;

    //Constructor que usa la referencia super para acceder al constructor padre para insertar la clase persona, saldo e IBAN y le añade el atributo propio tipoInteres
    public CuentaAhorro(Persona persona, double saldo, String IBAN, double tipoInteres) {
        super(persona, saldo, IBAN);
        this.tipoInteres = tipoInteres;
    }

    //Getter y setter
    public double getTipoInteresAnual() {
        return tipoInteres;
    }

    public void setTipoInteresAnual(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    //Método sobreescrito de la clase padre que devuelve la información de una cuenta como una cadena de caracteres incluyendo la información del atributo propio
    @Override
    public String devolverInfoString() {

        return "Tipo: Cuenta ahorro, " + super.devolverInfoString() + ", tipo interés:" + tipoInteres;
    }

}
