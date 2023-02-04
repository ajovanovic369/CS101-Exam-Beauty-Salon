package kozmetickisalon.objekti;

import kozmetickisalon.enumi.Pol;

public abstract class Korisnik {

    private String ime;
    private String prezime;
    private int brojGodina;
    private Pol pol;

    public Korisnik() {
    }

    public Korisnik(String ime, String prezime, int brojGodina, Pol pol) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojGodina = brojGodina;
        this.pol = pol;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getBrojGodina() {
        return brojGodina;
    }

    public void setBrojGodina(int brojGodina) {
        this.brojGodina = brojGodina;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "ime=" + ime + ", prezime=" + prezime + ", brojGodina=" + brojGodina + ", pol=" + pol + '}';
    }

}
