package com.company;

import java.io.Serializable;
import java.util.Objects;


class Persoana implements Serializable {
    String nume;
    int varsta;
    float salariu;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = (float) salariu;
    }

    public Persoana(String nume, int varsta, double salariu) {
        this.nume = nume;
        this.varsta = varsta;
        this.salariu = (float) salariu;
    }
}


