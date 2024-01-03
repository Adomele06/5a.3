package adomele;
/**
 * Klasse zum Speichern der abgefragten und richtigen Wörtern der Klasse WortTrainer
 * @author Alex Domele
 * @version 2023-10-11
 */
public class Statistik {
    private int abgefragt;
    private int richtig;

    /**
     * Konstruktor ohne Parameter setzt beide Werte auf 0
     */
    public Statistik(){
        this.abgefragt = 0;
        this.richtig = 0;
    }

    /**
     * Erhöht abgefragt Attibut um 1
     */
    public void setAbgefragt(){
        this.abgefragt++;
    }

    /**
     * Erhöht richtig Attribut um 1
     */
    public void setRichtig(){
        this.richtig++;
    }

    public int getAbgefragt(){ return this.abgefragt;}

    public int getRichtig(){return this.richtig;}

    /**
     * Gibt die Attribute zurück
     * @return die Attribute als String
     */
    @Override
    public String toString(){
        return "Abgefragte Wörter: " + this.abgefragt + "; Richtige Wörter: " + this.richtig;
    }
}
