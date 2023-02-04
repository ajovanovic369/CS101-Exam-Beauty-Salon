package kozmetickisalon.objekti;

import kozmetickisalon.enumi.Pol;
import kozmetickisalon.enumi.TipKartice;

public class PremiumKorisnik extends Korisnik implements Comparable<PremiumKorisnik> {

    private int popust;
    private TipKartice tipKartice;

    public PremiumKorisnik() {
    }

    public PremiumKorisnik(int popust, TipKartice tipKartice, String ime, String prezime, int brojGodina, Pol pol) {
        super(ime, prezime, brojGodina, pol);
        this.popust = popust;
        this.tipKartice = tipKartice;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public TipKartice getTipKartice() {
        return tipKartice;
    }

    public void setTipKartice(TipKartice tipKartice) {
        this.tipKartice = tipKartice;
    }

    @Override
    public String toString() {
        return super.toString() + "PremiumKorisnik{" + "popust=" + popust + ", tipKartice=" + tipKartice + '}';
    }

    @Override
    public int compareTo(PremiumKorisnik t) {
        if (this.tipKartice == t.tipKartice) {
            return 0;
        } else if (this.tipKartice.ordinal() > t.tipKartice.ordinal()) {
            return 1;
        } else {
            return -1;
        }
    }
}
