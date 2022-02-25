package com.company;

public class Grad {
    private String nazivGrada;
    private String nazivDrzave;

    public Grad(String nazivGrada, Drzava drzava){
        this.nazivDrzave=nazivGrada;
        this.nazivDrzave = drzava.getNazivDrzave();
    }

    public String getNazivGrada(){
        return this.nazivGrada;
    }

    public String getNazivDrzave(){
        return this.nazivDrzave;
    }

}
