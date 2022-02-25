package com.company;
import java.util.HashMap;

public class Banka {
    private HashMap<Integer, Racun> korisnickiRacuni;

    public Banka(){
        this.korisnickiRacuni = new HashMap<>();
    }

    public void dodajKorisnickiRacun(Racun racun){
        korisnickiRacuni.putIfAbsent(racun.getBrojRacuna(), racun);
    }

    public boolean postojanjeRacuna(int uneseniBrojRacuna){
        for(Integer brojRacuna : korisnickiRacuni.keySet()){
            if(brojRacuna == uneseniBrojRacuna){
                return true;
            }
        }

        return false;
    }

    public Racun izaberiRacun(int uneseniBrojRacuna, int uneseniPin){
        for(Integer brojRacuna : korisnickiRacuni.keySet()){
            if(brojRacuna == uneseniBrojRacuna){
                if(korisnickiRacuni.get(brojRacuna).validacija(uneseniPin)){
                    //System.out.println("Uspjesan pristup");
                    return korisnickiRacuni.get(brojRacuna);
                }else {
                    System.out.println("Netacan PIN");
                    return null;
                }
            }

        }
        System.out.println("Zao nam je, unijeli ste nepostojeci racun");
        return null;
    }

    public Racun odrediRacun(int uneseniBrojRacuna){
        for(Integer brojRacuna : korisnickiRacuni.keySet()){
            if(brojRacuna == uneseniBrojRacuna){
                    //System.out.println(korisnickiRacuni.get(brojRacuna));
                    return korisnickiRacuni.get(brojRacuna);

                }
            }
            System.out.println("Upisani broj racuna ne postoji");
            return null;
        }

}
