package com.company;
import java.util.Scanner;
//UI Klasa
public class Bankomat {
    private Scanner scanner;
    private Racun racun;
    private int uneseniBrojRacuna;
    private int uneseniPin;
    private int opcija;

    public Bankomat(Scanner scanner){
        this.scanner = scanner;

    }

    public void prepoznajOpciju(int opcija, Banka banka){
        switch (opcija){
            case 1:
                System.out.println("Vase stanje racuna iznosi : " + this.racun.getStanjeRacuna());
                break;

            case 2:
                System.out.println("Unesite iznos koju zelite podici sa racuna");
                int iznosZaIsplatu = Integer.valueOf(scanner.nextLine());
                if(iznosZaIsplatu%10!=0){
                    System.out.println("Iznos koji ste unijeli nije djeljiv sa 10");
                }else if(iznosZaIsplatu>this.racun.getStanjeRacuna()){
                    System.out.println("Nedovoljno sredstava na racunu.");
                }else{
                    this.racun.dizanjeNovca(iznosZaIsplatu);
                }
                break;

            case 3:
                System.out.println("Unesite iznos koju zelite uplatiti na racun");
                int iznosZaUplatu = Integer.valueOf(scanner.nextLine());
                if(iznosZaUplatu%10!=0){
                    System.out.println("Iznos koji ste unijeli nije djeljiv sa 10");
                }else{
                    this.racun.uplataNovca(iznosZaUplatu);
                }
                break;

            case 4:
                System.out.println("Unesite iznos koju zelite prebaciti na racun");
                int iznosZaTransfer = Integer.valueOf(scanner.nextLine());
                if(iznosZaTransfer > this.racun.getStanjeRacuna()) {
                    System.out.println("Nedovoljno sredstava na racunu.");
                }else{
                    System.out.println("Unesite broj racuna na koji zelite prebaciti iznos");
                    int brojRacunaZaTransfer = Integer.valueOf(scanner.nextLine());
                    Racun racunZaTransfer = banka.odrediRacun(brojRacunaZaTransfer);
                    if(racunZaTransfer != null) {
                        this.racun.transferNovca(iznosZaTransfer, racunZaTransfer);
                    }
                }
                break;

            case 5:
                System.out.println("Vase transakcije : ");
                this.racun.miniIzvod();
                break;

            case 6:
                System.out.println("Upisite novi PIN za Vas racun, max. 4 karaktera");
                int noviPin = Integer.valueOf(scanner.nextLine());
                while(noviPin > 10000) {
                    System.out.println("Vas pin ima vise od 4 cifre, upisite novi PIN");
                    noviPin = Integer.valueOf(scanner.nextLine());
                }
                this.racun.setPin(noviPin);
                System.out.println("Uspjesno ste promjenili PIN.");
                System.out.println("Vas novi PIN je : " + this.racun.getPin());
                break;

        }
    }

    public void start(){
        Drzava BiH = new Drzava("Bosna i Hercegovina");
        Grad sa = new Grad("Sarajevo", BiH);
        Zanimanje st = new Zanimanje("Student");
        VrstaRacuna stu = new VrstaRacuna("Studentski");
        Korisnik rijad = new Korisnik("Rijad","Čomor","Ahmet","111111111111111",st,"Ulica 22",sa,"7/10/1999","061/111-111","riccidesign@gmail.com");
        Racun rijadRacun = new Racun(1000, rijad,stu,1000.00, 1234, true);
        Banka banka = new Banka();
        banka.dodajKorisnickiRacun(rijadRacun);

        Korisnik bilal = new Korisnik("Bilal","Đ","Ahmet","111111111111111",st,"Ulica 22",sa,"7/10/1999","061/111-111","riccidesign@gmail.com");
        Racun bilalRacun = new Racun(1001, bilal,stu,500.00, 1234, true);
        banka.dodajKorisnickiRacun(bilalRacun);


        while(true) {
            System.out.println("Dobro dosli na BP bankomat");
            System.out.println("Upisite broj racuna :");
            this.uneseniBrojRacuna = Integer.valueOf(scanner.nextLine());
            if (banka.postojanjeRacuna(this.uneseniBrojRacuna)) {

                System.out.println("Upisite PIN :");
                this.uneseniPin = Integer.valueOf(scanner.nextLine());
                this.racun = banka.izaberiRacun(this.uneseniBrojRacuna, this.uneseniPin);
                if(this.racun != null && this.racun.getStatusRacuna()) {
                    System.out.println("Uspjesan pristup");
                    System.out.println("Dobro dosli, " + this.racun.getImeKorisnik());
                }else if(this.racun == null){
                    continue;
                } else if(!this.racun.getStatusRacuna()){
                    System.out.println(this.racun.getImeKorisnik() + ", Vas racun je blokiran.");
                    continue;
                }else{
                    continue;
                }
                while (true) {
                    System.out.println();
                    System.out.println("Izaberite neku od opcija :");
                    System.out.println("1. Provjeri stanje \n" + "2. Isplata sa racuna \n" + "3. Uplata na racun \n" + "4. Transfer \n" + "5. Mini izvod \n" + "6. Promjeni PIN \n" + "7. Izlaz \n");
                    this.opcija = Integer.valueOf(scanner.nextLine());
                    prepoznajOpciju(this.opcija, banka);

                    if (this.opcija == 7) {
                        System.out.println("Dovidjenja, " + this.racun.getImeKorisnik());
                        break;
                    }
                }
                continue;
            } else {
                System.out.println("Unijeli ste nepostojeci broj racuna");
            }
        }

    }


}
