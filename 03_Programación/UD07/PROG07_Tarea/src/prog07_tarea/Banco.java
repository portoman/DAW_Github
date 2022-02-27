package prog07_tarea;

import prog07_tarea.cuentas.CuentaBancaria;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase que contiene el array que almacena las cuentas y diferentes métodos para realizar operaciones de abrir, listar, consultar, ingresar y retirar dinero en las cuentas.
 */
public class Banco {

    //Constante que define el número máximo de cuentas
    private final int NUMERO_MÁXIMO_CUENTAS = 100;
    //Array con 100 cuentas bancarias
    CuentaBancaria[] cuentasTotales = new CuentaBancaria[NUMERO_MÁXIMO_CUENTAS];
    //Variable para definir la primera posición libre en el array
    int primeraPosicionLibre = 0;

    //Constructor vacío. No seria necesario declararlo, pero lo indica el enunciado 
    public Banco() {
    }

    //Método que recibe por parámetro un objeto CuentaBancaria y lo almacena en la estructura. Devuelve true o false indicando si la operación se realizó con éxito
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        boolean devolucion = false;
        if (primeraPosicionLibre < NUMERO_MÁXIMO_CUENTAS) {
            cuentasTotales[primeraPosicionLibre++] = cuenta;
            devolucion = true;
        }
        return devolucion;
    }

    /*Método que no recibe parámetro y devuelve un array donde cada elemento es una cadena que representa la información de una cuenta.
    Por ligadura dinámica, el tipo de objeto instanciado determinará el tipo de método devolverInfoString que se usará. */
    public String listadoCuentas() {
        String resultado = "";

        for (int i = 0; i < primeraPosicionLibre; i++) {
            resultado += cuentasTotales[i].devolverInfoString() + "\n";
        }
        return resultado;
    }

    /*Método que recibe un IBAN por parámetro y devuelve una cadena con la información de la cuenta o null si la cuenta no existe.
    Por ligadura dinámica, el tipo de objeto instanciado determinará el tipo de método devolverInfoString que se usará. 
     */
    public String informacionCuenta(String IBAN) {
        String devolucion = null;
        for (int i = 0; i < primeraPosicionLibre; i++) {
            if (cuentasTotales[i].getIBAN().equals(IBAN)) {
                devolucion = cuentasTotales[i].devolverInfoString();
            }
        }
        return devolucion;
    }

    //Método que recibe un IBAN por parámetro y una cantidad e ingresa la cantidad en la cuenta. Devuelve true o false indicando si la operación se realizó con éxito.
    public boolean ingresoCuenta(String IBAN, double cantidad) {
        boolean devolucion = false;
        for (int i = 0; i < primeraPosicionLibre; i++) {
            if (cuentasTotales[i].getIBAN().equals(IBAN)) {
                cuentasTotales[i].setSaldo(cuentasTotales[i].getSaldo() + cantidad);
                devolucion = true;
            }
        }
        return devolucion;
    }

    //Método que recibe un IBAN por parámetro y una cantidad y trata de retirar la cantidad de la cuenta. Devuelve true o false indicando si la operación se realizó con éxito.
    public boolean retiradaCuenta(String IBAN, double cantidad) {
        boolean devolucion = false;
        for (int i = 0; i < primeraPosicionLibre; i++) {
            if (cuentasTotales[i].getIBAN().equals(IBAN)) {
                cuentasTotales[i].setSaldo(cuentasTotales[i].getSaldo() - cantidad);
                devolucion = true;
            }
        }
        return devolucion;
    }

    //Método que Recibe un IBAN por parámetro y devuelve el saldo de la cuenta si existe. En caso contrario devuelve -1.
    public double obtenerSaldo(String IBAN) {
        double devolucion = -1;
        for (int i = 0; i < primeraPosicionLibre; i++) {
            if (cuentasTotales[i].getIBAN().equals(IBAN)) {
                devolucion = cuentasTotales[i].getSaldo();
            }
        }
        return devolucion;

    }
}
