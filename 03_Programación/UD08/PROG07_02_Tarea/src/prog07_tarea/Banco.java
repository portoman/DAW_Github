package prog07_tarea;

import java.io.Serializable;
import java.util.ArrayList;
import prog07_tarea.cuentas.CuentaBancaria;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase que contiene un ArrayList que almacena las cuentas y diferentes métodos para realizar operaciones de abrir, listar, consultar, ingresar, retirar dinero en las cuentas
así como un nuevo método para eliminar cuentas, de acuerdo al enunciado de la tarea de la unidad 8.
 */
public class Banco {

    /*Escojo ArrayList porque es una estructura más rápida que los LinkedList y 
    no se van a realizar muchas eliminaciones, sino que se insertarán y consultarán elementos por posición mayoritariamente
     */
    ArrayList<CuentaBancaria> cuentasTotales = new ArrayList<CuentaBancaria>();

    //Constructor vacío. No seria necesario declararlo, pero lo indica el enunciado 
    public Banco() {
    }

    //Método que recibe por parámetro un objeto CuentaBancaria y lo almacena en la estructura. 
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        boolean devolucion = true;
        //Incluyo código para que no existan 2 cuentas con el mismo IBAN
        for (CuentaBancaria cu : this.cuentasTotales) {
            if (cu.getIBAN().equals(cuenta.getIBAN())) {
                devolucion = false;
            }
        }
        if (devolucion) {
            this.cuentasTotales.add(cuenta);
        }
        return devolucion;
    }

    ;

    /*Método que no recibe parámetro y devuelve un String donde cada elemento es una cadena que representa la información de una cuenta.
    Por ligadura dinámica, el tipo de objeto instanciado determinará el tipo de método devolverInfoString que se usará. */
    public String listadoCuentas() {
        String resultado = "";
        for (CuentaBancaria cuenta : this.cuentasTotales) {
            resultado += cuenta.devolverInfoString() + "\n";
        }
        return resultado;
    }

    /*Método que recibe un IBAN por parámetro y devuelve una cadena con la información de la cuenta o null si la cuenta no existe.
    Por ligadura dinámica, el tipo de objeto instanciado determinará el tipo de método devolverInfoString que se usará. 
     */
    public String informacionCuenta(String IBAN) {
        String devolucion = null;
        for (CuentaBancaria cuenta : this.cuentasTotales) {
            if (cuenta.getIBAN().equals(IBAN)) {
                devolucion = cuenta.devolverInfoString();
            }
        }
        return devolucion;
    }

    //Método que recibe un IBAN por parámetro y una cantidad e ingresa la cantidad en la cuenta. Devuelve true o false indicando si la operación se realizó con éxito o no.
    public boolean ingresoCuenta(String IBAN, double cantidad) {
        boolean devolucion = false;
        for (CuentaBancaria cuenta : this.cuentasTotales) {
            if (cuenta.getIBAN().equals(IBAN)) {
                cuenta.setSaldo(cuenta.getSaldo() + cantidad);
                devolucion = true;
            }
        }
        return devolucion;
    }

    //Método que recibe un IBAN por parámetro y una cantidad y trata de retirar la cantidad de la cuenta. Devuelve true o false indicando si la operación se realizó con éxito o no.
    public boolean retiradaCuenta(String IBAN, double cantidad) {
        boolean devolucion = false;
        for (CuentaBancaria cuenta : this.cuentasTotales) {
            if (cuenta.getIBAN().equals(IBAN)) {
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
                devolucion = true;
            }
        }
        return devolucion;
    }

    //Método que Recibe un IBAN por parámetro y devuelve el saldo de la cuenta si existe. En caso contrario devuelve -1.
    public double obtenerSaldo(String IBAN) {
        double devolucion = -1;
        for (CuentaBancaria cuenta : this.cuentasTotales) {
            if (cuenta.getIBAN().equals(IBAN)) {
                devolucion = cuenta.getSaldo();
            }
        }
        return devolucion;
    }

    //Método para eliminar cuenta bancaria si su saldo es cero. Si se elimina devuelve 1 y si el saldo no es cero devuelve 0
    public int eliminarCuenta(String IBAN) {
        int devolucion = -1;
        CuentaBancaria eliminar = null;
        for (CuentaBancaria cuenta : this.cuentasTotales) {
            if (cuenta.getIBAN().equals(IBAN) && cuenta.getSaldo() == 0) {
                eliminar = cuenta;
                devolucion = 1;
            } else if (cuenta.getIBAN().equals(IBAN) && cuenta.getSaldo() != 0) {
                devolucion = 0;
            }
        }
        this.cuentasTotales.remove(eliminar);
        return devolucion;
    }
}
