package prog07_tarea.cuentas;

import prog07_tarea.Persona;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Subclase que hereda de la clase Cuenta Corriente que tiene como atributo propio comisionMantenimiento.
 */
public class CuentaCorrientePersonal extends CuentaCorriente {

    //Atributo propio
    private double comisionMantenimiento;

    //Constructor que usa la referencia super para acceder al constructor padre para insertar la clase persona, saldo e IBAN e inserta también el atributo propio
    public CuentaCorrientePersonal(Persona persona, double saldo, String IBAN, double comisionMantenimiento) {
        super(persona, saldo, IBAN);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    //Getter y Setter
    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    //Método sobreescrito de la clase padre que devuelve la información de una cuenta como una cadena de caracteres incluyendo la información del atributo propio
    @Override
    public String devolverInfoString() {
        return "Tipo: Cuenta corriente personal, " + super.devolverInfoString() + " , comisión de mantenimiento:  " + comisionMantenimiento;
    }

}
