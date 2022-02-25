package com.company;
import java.util.Date;

public class Transakcija {
    protected double iznos;
    protected int brojRacunaKorisnika;
    protected Date datumTransakcije;
    protected String vrstaUsluge;

    public Transakcija(double iznos, int brojRacuna, String vrstaUsluge){
        this.iznos = iznos;
        this.brojRacunaKorisnika = brojRacuna;
        this.datumTransakcije = new Date();
        this.vrstaUsluge = vrstaUsluge;
    }

    public String toString(){
        return ("\nIznos : " + this.iznos +  " | Datum : " + this.datumTransakcije + " | Vrsta usluge : " + this.vrstaUsluge);
    }

}
