/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication27;

import java.io.Serializable;

public class ContaBancaria implements Serializable {
    private String IBAN;
    private String NIF;
    private String titular;
    private float saldo;

    public ContaBancaria() {
    }

    public ContaBancaria(String IBAN, String NIF, String titular, float saldo) {
        this.IBAN = IBAN;
        this.NIF = NIF;
        this.titular = titular;
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" + "IBAN=" + IBAN + ", NIF=" + NIF + ", titular=" + titular + ", saldo=" + saldo + '}';
    }
    
    
}
