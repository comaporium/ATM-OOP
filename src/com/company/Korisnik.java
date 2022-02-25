package com.company;


public class Korisnik {
    private String ime;
    private String prezime;
    private String imeOca;
    private String jmbg;
    private String zanimanje;
    private String adresaStanovanja;
    private String grad;
    private String datumRodjenja;
    private String kontaktTelefon;
    private String eMail;


    public Korisnik(String ime, String prezime, String imeOca, String jmbg, Zanimanje zanimanje, String adresaStanovanja, Grad grad, String datumRodjenja, String kontaktTelefon, String eMail){
        this.ime=ime;
        this.prezime=prezime;
        this.imeOca=imeOca;
        this.jmbg=jmbg;
        this.zanimanje = zanimanje.getZanimanje();
        this.adresaStanovanja=adresaStanovanja;
        this.grad = grad.getNazivGrada();
        this.datumRodjenja = datumRodjenja;
        this.kontaktTelefon = kontaktTelefon;
        this.eMail = eMail;
    }


    //getteri
    public String getIme(){
        return this.ime;
    }

    public String getPrezime(){
        return this.prezime;
    }

    public String getImeOca(){
        return this.imeOca;
    }

    public String getJmbg(){
        return this.jmbg;
    }

    public String getZanimanje(){
        return this.zanimanje;
    }

    public String getAdresaStanovanja(){
        return this.adresaStanovanja;
    }

    public String getGrad(){
        return this.grad;
    }

    public String getKontaktTelefon(){
        return kontaktTelefon;
    }

    public String geteMail(){
        return eMail;
    }

    //setteri
    public void setIme(String ime){
        this.ime = ime;
    }

    public void setPrezime(String prezime){
        this.prezime = prezime;
    }

    public void setImeOca(String imeOca){
        this.imeOca = imeOca;
    }

    public void setJmbg(String jmbg){
        this.jmbg = jmbg;
    }

    public void setZanimanje(Zanimanje zanimanje){
        this.zanimanje = zanimanje.getZanimanje();
    }

    public void setAdresaStanovanja(String adresaStanovanja){
        this.adresaStanovanja = adresaStanovanja;
    }

    public void setGrad(Grad grad){
        this.grad = grad.getNazivGrada();
    }

    public void setDatumRodjenja(String datumRodjenja){
        this.datumRodjenja = datumRodjenja;
    }

    public void setKontaktTelefon(String kontaktTelefon){
        this.kontaktTelefon = kontaktTelefon;
    }

    public void seteMail(String eMail){
        this.eMail = eMail;
    }


}
