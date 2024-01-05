package adomele;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
/**
 * Klasse WortTrainer mit allen dazugehörigen Methoden
 * @author Alex Domele
 * @version 2023-09-23
 */
public class WortTrainer {

    private WortListe liste;
    private int aktuellerEintrag;
    private Statistik statistik;

    /**
     * Konstruktor speichert Referenz auf ein WortListe-Objekt und setzt das aktuelleWort auf 0
     *
     * @param liste die Referenz auf das WortListe-Objekt
     */
    public WortTrainer(WortListe liste) {
        setListe(liste);
        this.aktuellerEintrag = 0;
        this.statistik = new Statistik();
    }

    /**
     * Setter Methode für das Attribut liste
     *
     * @param liste das WortListe-Objekt
     */
    public void setListe(WortListe liste) {
        if (liste != null) {
            this.liste = liste;
        } else {
            throw new IllegalArgumentException("Parameter ist leer!");
        }
    }

    /**
     * gibt einen zufälligen Eintrag zurück und speichert den Index in das aktuelleWort Attribut
     * @return zufälliger Eintrag aus der Wortliste
     */
    public String getRandomEintrag() {
        Random generator = new Random();
        this.aktuellerEintrag = generator.nextInt(this.liste.getListeLaenge());
        return liste.getWort(this.aktuellerEintrag) + "; " + liste.getUrl(this.aktuellerEintrag);
    }

    /**
     * Getter Methode für das aktuelleWort Attribut
     * @return gibt den aktuellen Eintrag zurück
     */
    public String getAktuell() {
        return liste.getWort(this.aktuellerEintrag) + "; " + liste.getUrl(this.aktuellerEintrag);
    }

    /**
     * Überprüft, ob das eingegebene Wort mit dem wort Attribut des aktuellen Eintrags übereinstimmt
     * @param eingabe das vom User eingegebene Wort
     * @return gibt an, ob das richtige Wort angegeben wurde
     */
    public boolean check(String eingabe) {
        if (eingabe != null) {
            this.statistik.setAbgefragt();
            if(this.liste.getWort(this.aktuellerEintrag).equals(eingabe)){
                this.statistik.setRichtig();
                return true;
            }
            else {
                return false;
            }
        }
        throw new NullPointerException("Das Attribut aktuellerEintrag ist leer!");
    }

    /**
     * Überprüft, ob das eingegebene Wort mit dem wort Attribut des aktuellen Eintrags übereinstimmt, unabhängig
     * von der Groß- und Kleinschreibung
     * @param eingabe vom User eingegebene Wort
     * @return gibt an, ob das richtige Wort angegeben wurde
     */
    public boolean checkIgnoreCase(String eingabe) {
        if(eingabe != null){
            String eingabeKlein = eingabe.toLowerCase();
            String aktuellKlein = this.liste.getWort(this.aktuellerEintrag).toLowerCase();
            this.statistik.setAbgefragt();
            if (aktuellKlein.equals(eingabeKlein)) {
                this.statistik.setRichtig();
                return true;
            }
            else {
                return false;
            }
        }
        throw new IllegalArgumentException("Parameter ist leer!");
    }

    /**
     * statistik gibt die abgefragten und richtigen Wörter mithilfe der Methode getStatistik zurück.
     * @return der String mit den Attributen des Statistik-Objekts
     */
    public String statistik(){
        return this.statistik.toString();
    }

    /**
     * Gibt den Trainer als String zurück; verwendet bereits erstelle Methoden für die Attribute
     * @return der Trainer als String
     */
    @Override
    public String toString(){
        return this.liste.toString() + this.statistik();
    }

    /**
     * Methode schreiben ruft Methode speichern aus Klasse SpeicherundLaden auf
     * @throws IOException IOException
     */
    public void schreiben() throws IOException {
        SpeichernundLaden.speichern(this);
    }

    /**
     * Methode schreiben ruft Methode speichern aus Klasse SpeicherundLaden auf
     * @param pfad der String-Parameter für die Methode speichern
     * @throws IOException IOException
     */
    public void schreiben(String pfad) throws IOException {
        SpeichernundLaden.speichern(this, pfad);
    }

    /**
     * Methode laden ruft Methode laden aus Klasse SpeicherundLaden auf
     * @throws FileNotFoundException FileNotFoundException
     */
    public void laden() throws FileNotFoundException {
        SpeichernundLaden.laden(this, "Worttrainer.txt");
    }

    /**
     * Methode laden ruft Methode laden aus Klasse SpeicherundLaden auf
     * @param pfad der String-Parameter für die Methode laden
     * @throws FileNotFoundException FileNotFoundException
     */
    public void laden(String pfad) throws FileNotFoundException {
        SpeichernundLaden.laden(this, pfad);
    }

    /**
     * Hilfsmethode, womit ein neuer Eintrag dem Trainer hinzugefügt werden kann;
     * verwendet bereits erstelle Methode neuerEintrag aus Klasse Liste
     * @param wort String wort für Methode neuerEintrag
     * @param url String url für Methode neuerEintrag
     */
    public void addEintrag(String wort, String url){
        this.liste.neuerEintrag(wort, url);
    }

    /**
     * Hilfsmethode um abgelesene Statistik zu speichern
     * @param abgefragt int abefragt
     * @param richtig int richtig
     */
    public void setStatistik(int abgefragt, int richtig){
        for(;abgefragt > 0; abgefragt--){
            this.statistik.setAbgefragt();
        }
        for(;richtig > 0; richtig--){
            this.statistik.setRichtig();
        }
    }

    public String getURL(){
        return liste.getUrl(aktuellerEintrag);
    }

    public int getRichtige(){
        return statistik.getRichtig();
    }

    public int getAbgefragt(){
        return statistik.getAbgefragt();
    }
}
