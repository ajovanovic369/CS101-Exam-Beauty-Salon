package kozmetickisalon.objekti;

import kozmetickisalon.enumi.Pol;
import kozmetickisalon.izuzeci.IzuzetakBrojPoseta;

public class StandardniKorisnik extends Korisnik implements Comparable<StandardniKorisnik> {

    private int brojPosetaSalonu;

    public StandardniKorisnik() {
    }

    public StandardniKorisnik(int brojPosetaSalonu, String ime, String prezime, int brojGodina, Pol pol) throws IzuzetakBrojPoseta {
        super(ime, prezime, brojGodina, pol);
        setBrojPosetaSalonu(brojPosetaSalonu);
    }

    public int getBrojPosetaSalonu() {
        return brojPosetaSalonu;
    }

    public void setBrojPosetaSalonu(int brojPosetaSalonu) throws IzuzetakBrojPoseta {
        if (brojPosetaSalonu >= 0) {
            this.brojPosetaSalonu = brojPosetaSalonu;
        } else {
            throw new IzuzetakBrojPoseta("Broj poseta ne sme biti negativna vrednost!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "StandardniKorisnik{" + "brojPosetaSalonu=" + brojPosetaSalonu + '}';
    }

    @Override
    public int compareTo(StandardniKorisnik t) {
        if (super.getBrojGodina() == t.getBrojGodina()) {
            return 0;
        } else if (super.getBrojGodina() < t.getBrojGodina()) {
            return 1;
        } else {
            return -1;
        }
    }

}
