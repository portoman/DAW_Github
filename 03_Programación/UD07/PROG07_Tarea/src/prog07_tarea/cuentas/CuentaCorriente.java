package prog07_tarea.cuentas;

import prog07_tarea.Persona;
import prog07_tarea.cuentas.CuentaBancaria;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Subclase que hereda de la clase Cuenta Bancaria que tiene como atributo propio el listaEntidades
 */
public class CuentaCorriente extends CuentaBancaria {

    //Atributo propio de esta clase
    String listaEntidades;

    //Constructor que usa la referencia super para acceder al constructor padre para insertar la clase persona, saldo e IBAN
    public CuentaCorriente(Persona persona, double saldo, String IBAN) {
        super(persona, saldo, IBAN);
    }

    //Getter y setter
    public String getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }

    /*
    Método sobreescrito de la clase padre que devuelve la información de una cuenta como una cadena de caracteres. Llama directamente al método de la clase padre.
    El atributo propio listaEntidades no lo incluyo a mostrar en este método porque siempre dará null, ya que el enunciado no menciona introducir ni mostrar nada en él, 
    simplemente que la clase tenga este atributo.
     */
    @Override
    public String devolverInfoString() {

        return super.devolverInfoString();
    }

}
