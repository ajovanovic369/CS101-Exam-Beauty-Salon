package kozmetickisalon.objekti;

import kozmetickisalon.enumi.TipUsluge;
import kozmetickisalon.izuzeci.IzuzetakCena;

public class Usluge {

    private TipUsluge tipUsluge;
    private int trajanjeUsluge;
    private double cenaUsluge;

    public Usluge() {
    }

    public Usluge(TipUsluge tipUsluge, int trajanjeUsluge, double cenaUsluge) throws IzuzetakCena {
        this.tipUsluge = tipUsluge;
        this.trajanjeUsluge = trajanjeUsluge;
        setCenaUsluge(cenaUsluge);
    }

    public TipUsluge getTipUsluge() {
        return tipUsluge;
    }

    public void setTipUsluge(TipUsluge tipUsluge) {
        this.tipUsluge = tipUsluge;
    }

    public int getTrajanjeUsluge() {
        return trajanjeUsluge;
    }

    public void setTrajanjeUsluge(int trajanjeUsluge) {
        this.trajanjeUsluge = trajanjeUsluge;
    }

    public double getCenaUsluge() {
        return cenaUsluge;
    }

    public void setCenaUsluge(double cenaUsluge) throws IzuzetakCena {
        if (cenaUsluge >= 0) {
            this.cenaUsluge = cenaUsluge;
        } else {
            throw new IzuzetakCena("Cena ne sme biti negativna vrednost!");
        }
    }

    @Override
    public String toString() {
        return "Usluge{" + "tipUsluge=" + tipUsluge + ", trajanjeUsluge=" + trajanjeUsluge + ", cenaUsluge=" + cenaUsluge + '}';
    }

}
