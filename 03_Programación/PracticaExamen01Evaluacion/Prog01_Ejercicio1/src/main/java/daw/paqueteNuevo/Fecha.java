/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.paqueteNuevo;

/**
 *
 * @author portb
 */
public class Fecha {

    enum enumMes {
        Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre
    };

    int dia;
    int anho;
    enumMes mes;

    public Fecha(enumMes mes) {
        this.mes = mes;
    }

    public Fecha(enumMes mes, int dia, int año) {
        this.mes = mes;
        this.dia = dia;
        this.anho = año;
    }

    //Getter y Setters
    public int getDia() {
        return this.dia;
    }

    public int getAnho() {
        return this.anho;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public boolean isSummer() {
        return (this.mes.equals(enumMes.Junio)||this.mes.equals(enumMes.Julio)||this.mes.equals(enumMes.Agosto));

    }

    public String toString(){
        return  this.dia+" de "+this.mes+" de "+this.anho;
    }
}
