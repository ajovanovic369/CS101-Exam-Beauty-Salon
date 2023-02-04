package kozmetickisalon.objekti;

import java.util.ArrayList;
import java.util.List;
import kozmetickisalon.alati.Alati;
import kozmetickisalon.enumi.Pol;
import kozmetickisalon.enumi.TipKartice;
import kozmetickisalon.izuzeci.IzuzetakAdresa;

public class Salon {

    private String ime;
    private String adresa;
    private boolean daLiPosedujeParking;
    private List<Korisnik> listaKorisnika = new ArrayList<>();

    public Salon() {
    }

    public Salon(String ime, String adresa, boolean daLiPosedujeParking) throws IzuzetakAdresa {
        this.ime = ime;
        setAdresa(adresa);
        this.daLiPosedujeParking = daLiPosedujeParking;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) throws IzuzetakAdresa {
        if (Character.isUpperCase(adresa.charAt(0)) && Alati.sadrziBrojeve(adresa)) {
            this.adresa = adresa;
        } else {
            throw new IzuzetakAdresa("Adresa nije validna!");
        }
    }

    public boolean isDaLiPosedujeParking() {
        return daLiPosedujeParking;
    }

    public void setDaLiPosedujeParking(boolean daLiPosedujeParking) {
        this.daLiPosedujeParking = daLiPosedujeParking;
    }

    @Override
    public String toString() {
        return "Salon{" + "ime=" + ime + ", adresa=" + adresa + ", daLiPosedujeParking=" + daLiPosedujeParking + '}';
    }

    public boolean dodajKorisnika(Korisnik k) {
        listaKorisnika.add(k);
        return true;
    }

    public List<StandardniKorisnik> ispisiSveStandardneKorisnike() {
        List<StandardniKorisnik> listS = new ArrayList<>();
        for (Korisnik k : listaKorisnika) {
            if (k instanceof StandardniKorisnik) {
                listS.add((StandardniKorisnik) k);
            }
        }
        return listS;
    }

    public List<PremiumKorisnik> ispisiSvePremiumKorisnike() {
        List<PremiumKorisnik> listP = new ArrayList<>();
        for (Korisnik k : listaKorisnika) {
            if (k instanceof PremiumKorisnik) {
                listP.add((PremiumKorisnik) k);
            }
        }
        return listP;
    }
    
    
    public List<StandardniKorisnik> vracaSveStandardneMuskogPola(){
        List<StandardniKorisnik> listS = new ArrayList<>();
        for(StandardniKorisnik sk: ispisiSveStandardneKorisnike()){
            if(sk.getPol() == Pol.M){
                if(sk.getBrojPosetaSalonu()>3){
                    listS.add(sk);
                }
            }
        }
        return listS;
    }
    
    public List<PremiumKorisnik> vracaNajveciPopus(TipKartice tipKartice){
        List<PremiumKorisnik> listP = new ArrayList<>();
        for(PremiumKorisnik pk: ispisiSvePremiumKorisnike()){
            int popus = pk.getPopust();
            if(pk.getTipKartice() == tipKartice){
                listP.add(pk);}
        }
        return listP;
    }

}
