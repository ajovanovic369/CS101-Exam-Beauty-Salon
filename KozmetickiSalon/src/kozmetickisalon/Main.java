package kozmetickisalon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kozmetickisalon.enumi.Pol;
import kozmetickisalon.enumi.TipKartice;
import kozmetickisalon.izuzeci.IzuzetakAdresa;
import kozmetickisalon.izuzeci.IzuzetakBrojPoseta;
import kozmetickisalon.objekti.Korisnik;
import kozmetickisalon.objekti.PremiumKorisnik;
import kozmetickisalon.objekti.Salon;
import kozmetickisalon.objekti.StandardniKorisnik;

public class Main {

    public static void main(String[] args) {

        try {
            Korisnik k1 = new StandardniKorisnik(10, "Pera", "Petrovic", 2, Pol.M);
            Korisnik k2 = new StandardniKorisnik(5, "Milica", "Milic", 1, Pol.Z);
            Korisnik k3 = new PremiumKorisnik(10, TipKartice.PLATINUM_KARTICA, "Dusan", "Dusanovic", 7, Pol.M);
            Korisnik k4 = new PremiumKorisnik(25, TipKartice.SILVER_KARTICA, "Milka", "Milkic", 12, Pol.Z);
            Salon s = new Salon("Lepota i dug", "Tamo Daleko 21", true);
            s.dodajKorisnika(k1);
            s.dodajKorisnika(k2);
            s.dodajKorisnika(k3);
            s.dodajKorisnika(k4);
            /**
             * upisivanje u datoteku
             */
            upisiPodatke(s.ispisiSveStandardneKorisnike(), s.ispisiSvePremiumKorisnike());
            /**
             * metoda vraca sve standardne korisnike muskog pola
             */
            System.out.println(s.vracaSveStandardneMuskogPola());
            /**
             * metoda vraca tip kartice
             */
            System.out.println(s.vracaNajveciPopus(TipKartice.PLATINUM_KARTICA));

        } catch (IzuzetakBrojPoseta ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IzuzetakAdresa ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void upisiPodatke(List<StandardniKorisnik> listS, List<PremiumKorisnik> listP){
    
        BufferedWriter upisi = null;
        try {
            upisi = new BufferedWriter(new FileWriter("salon.txt"));
            Salon s = new Salon("Salon Lepote", "Tamo Daleko 21", true);
            upisi.write("Ime:" + s.getIme() + "Adresa:" + s.getAdresa() + "Da li poseduje parking:" + s.isDaLiPosedujeParking() + "\n");
            for(StandardniKorisnik sk: listS){
                upisi.write(sk.getIme() + sk.getPrezime() + sk.getBrojGodina() + sk.getPol() + "\n" + sk.getBrojPosetaSalonu() + "\n");
            }
            for(PremiumKorisnik pk: listP){
                upisi.write(pk.getIme() + pk.getPrezime() + pk.getBrojGodina() + pk.getPol() + "\n" + pk.getPopust() + pk.getTipKartice() + "\n");
            }
            upisi.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IzuzetakAdresa ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
