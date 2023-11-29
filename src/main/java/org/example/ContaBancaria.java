package org.example;

import java.util.Objects;

public class ContaBancaria {
    private int saldo;
    private Boolean podeSacar;
    private String type;

    public ContaBancaria(String type) {
        this.saldo = 0;
        this.type = type;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public void setPodeSacar(boolean podeSacar) {
        this.podeSacar = podeSacar;
    }
    public boolean sacar(int valor) {
        if ((saldo - valor) >= 0 || Objects.equals(type, "especial")) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
    public int consultaSaldo() {
        return saldo;
    }
}