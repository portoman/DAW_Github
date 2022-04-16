package prog07_tarea.cuentas;

import prog07_tarea.Persona;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Subclase que hereda de la clase CuentaCorriente que tiene como atributos propios tipoInteresDescubierto, maximoDescubiertoPermitido y comisionFija
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {

    //Atributos propios
    private double tipoInteresDescubierto;
    private double maximoDescubiertoPermitido;
    private double comisionFija;

    //Constructor que usa la referencia super para acceder al constructor padre para insertar la clase persona, saldo e IBAN e inserta también los atributos propios
    public CuentaCorrienteEmpresa(Persona persona, double saldo, String IBAN, double tipoInteresDescubierto, double maximoDescubiertoPermitido, double comisionFija) {
        super(persona, saldo, IBAN);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
        this.comisionFija = comisionFija;
    }

    //Getters y Setters
    public double getMaximoDescubiertoPermitido() {
        return maximoDescubiertoPermitido;
    }

    public void setMaximoDescubiertoPermitido(double maximoDescubiertoPermitido) {
        this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
    }

    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    public double getComisionFija() {
        return comisionFija;
    }

    public void setComisionFija(double comisionFija) {
        this.comisionFija = comisionFija;
    }

    //Método sobreescrito de la clase padre que devuelve la información de una cuenta como una cadena de caracteres incluyendo la información de los atributos propios
    @Override
    public String devolverInfoString() {
        return "Tipo: Cuenta corriente de empresa, " + super.devolverInfoString() + ", tipo de interés descubierto: " + tipoInteresDescubierto + ", máximo descubierto permitido: " + maximoDescubiertoPermitido + ", comisión fija: " + comisionFija;
    }

}
