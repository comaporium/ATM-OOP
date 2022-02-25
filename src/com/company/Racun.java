package com.company;

import java.util.ArrayList;

public class Racun {
    private final int brojRacuna;
    private final Korisnik korisnik;
    private String vrstaRacuna;
    private double stanjeRacuna;
    private int pin;
    private boolean statusRacuna;
    private ArrayList<Transakcija> izvod;

    public Racun(int brojRacuna, Korisnik korisnik, VrstaRacuna vrstaRacuna, double stanjeRacuna, int pin, boolean statusRacuna){
        this.brojRacuna = brojRacuna;
        this.korisnik = korisnik;
        this.vrstaRacuna = vrstaRacuna.getVrstaRacuna();
        this.stanjeRacuna = stanjeRacuna;
        this.pin = pin;
        this.statusRacuna = statusRacuna;
        this.izvod = new ArrayList<>();
    }

    //getteri
    public int getBrojRacuna(){
        return this.brojRacuna;
    }

    public Korisnik getKorisnik(){
        return this.korisnik;
    }

    public String getVrstaRacuna(){
        return vrstaRacuna;
    }

    public double getStanjeRacuna(){
            return this.stanjeRacuna;
    }

    public int getPin(){
        return this.pin;
    }

    public boolean getStatusRacuna(){
        return this.statusRacuna;
    }


    //setteri
    public void setVrstaRacuna(VrstaRacuna vrstaRacuna){
        this.vrstaRacuna = vrstaRacuna.getVrstaRacuna();
    }

    public void setStanjeRacuna(double stanjeRacuna){
        this.statusRacuna = statusRacuna;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public void setStatusRacuna(boolean statusRacuna){
        this.statusRacuna = statusRacuna;
    }

    //za login

    public boolean validacija(int pinUnos){
        if(this.pin == pinUnos){
            return true;
        }
        return false;
    }

    public String getImeKorisnik(){
        return this.korisnik.getIme();
    }

    public void dizanjeNovca(int iznos){
        this.stanjeRacuna -= iznos;
        izvod.add(new Transakcija(iznos, this.brojRacuna, "Isplata sa racuna"));
        System.out.println("Uspjesno ste podigli " + iznos + "KM sa Vaseg racuna, novo stanje : " + this.stanjeRacuna);
    }

    public void uplataNovca(int iznos){
        this.stanjeRacuna += iznos;
        izvod.add(new Transakcija(iznos, this.brojRacuna, "Uplata na racun"));
        System.out.println("Uspjesno ste uplatili " + iznos + "KM na Vas racun, novo stanje : " + this.stanjeRacuna);
    }

    public void transferNovca(double iznos, Racun racunPrimaoca){
        this.stanjeRacuna -= iznos;
        racunPrimaoca.stanjeRacuna += iznos;
        this.izvod.add(new Transfer(iznos,this.brojRacuna,"Transfer sa racuna na racun", racunPrimaoca.brojRacuna));
        racunPrimaoca.izvod.add(new Transfer(iznos,this.brojRacuna, "Transfer sa racuna na racun", racunPrimaoca.brojRacuna));
        System.out.println("Uspjesno ste uplatili " + iznos + "KM na racun " + racunPrimaoca.brojRacuna +", novo stanje : " + this.stanjeRacuna);
    }

    public void miniIzvod(){

        System.out.println(this.izvod);
    }
}
