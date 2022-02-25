package com.company;

public class Transfer extends Transakcija{
    private int brojRacunaPrimaoca;

    public Transfer(double iznos, int brojRacunaPosiljaoca, String vrstaUsluge, int brojRacunaPrimaoca){
        super(iznos, brojRacunaPosiljaoca, vrstaUsluge);
        this.brojRacunaPrimaoca = brojRacunaPrimaoca;
    }

    public String toString(){
        return ("\nIznos : " + this.iznos + " | Broj racuna posiljaoca : " + this.brojRacunaKorisnika + " | Broj racuna primaoca : " + this.brojRacunaPrimaoca + " | Datum transfera : " + this.datumTransakcije + " | Vrsta usluge : " + this.vrstaUsluge);
    }

}
