package adomele;
/**
 * Klasse WortListe mit allen dazugehörigen Methoden
 * @author Alex Domele
 * @version 2023-09-23
 */
public class WortListe {
    private WortEintrag[] worteintraege;

    /**
     * Konstruktor erstellt ein WortEintrag Array mit setListenLaenge und speichert es in das Attribut worteintraege
     * @param laenge gibt die Länge des Arrays an
     */
    public WortListe(int laenge) {
        setListenLaenge(laenge);
    }

    /**
     * Methode zum Ertellen des WortListen Arrays
     * @param laenge int wert für die Länge des Arrays; darf nicht unter 2 sein
     */
    public void setListenLaenge(int laenge) {
        if (laenge > 1) {
            this.worteintraege = new WortEintrag[laenge];
        } else {
            throw new NumberFormatException("Mindestlänge des Arrays muss 2 betragen!");
        }
    }

    /**
     * Getter Methode für die Länge der Liste
     * @return Länge der Liste als int Wert
     */
    public int getListeLaenge() {
        return this.worteintraege.length;
    }

    /**
     * Fügt einen neuen Eintrag in das Array hinzu, falls es keinen Platz gibt wird das Array verlängert
     * @param wort der zu hinzufügende Eintrag
     * @param  url url des eintrages
     */
    public void neuerEintrag(String wort, String url) {
        if (wort == null || url == null) {
            throw new IllegalArgumentException("Parameter ist leer!");
        }
        WortEintrag eintrag = new WortEintrag(wort, url);
        boolean platz = false;
        if (eintrag.getWort() != null && eintrag.checkURL(eintrag.getUrl())) {
            for (int i = 0; i < this.worteintraege.length && !platz; i++) {
                if (this.worteintraege[i] == null) {
                    this.worteintraege[i] = eintrag;
                    platz = true;
                }
            }
            if (!platz) {
                WortEintrag[] laenger = new WortEintrag[this.worteintraege.length + 1];
                for (int i = 0; i < this.worteintraege.length; i++) {
                    laenger[i] = this.worteintraege[i];
                }
                laenger[laenger.length - 1] = eintrag;
                this.worteintraege = laenger;
            }
        }
    }

    /**
     * Gibt den Eintrag an der Stelle des übergebenen Indexes zurück.
     * Bei dieser Methode kommt es zu keine out of bounds, da in einem solchen
     * Fall das letzte Objekt zurückgegeben wird.
     *
     * @param index der Index des zurück zugebenen Eintrages
     * @return der gesuchte Eintrag
     */
    public String getWort(int index) {
        if (this.worteintraege != null) {
            if (index >= this.worteintraege.length) {
                for (int i = this.worteintraege.length; i > 0; i--) {
                    if (this.worteintraege[i - 1] != null) {
                        return this.worteintraege[i - 1].getWort();
                    }
                }
            }
            return this.worteintraege[index].getWort();
        }
        throw new NumberFormatException();
    }

    public String getUrl(int index){
        if (this.worteintraege != null) {
            if (index >= this.worteintraege.length) {
                for (int i = this.worteintraege.length; i > 0; i--) {
                    if (this.worteintraege[i - 1] != null) {
                        return this.worteintraege[i - 1].getUrl();
                    }
                }
            }
            return this.worteintraege[index].getUrl();
        }
        throw new NumberFormatException();
    }

    /**
     * Löscht einen Eintrag aus dem Array, wenn das wort Attribut
     * dem übergebenen String Parameter entspricht
     *
     * @param eingabe String, dass mit dem wort Attribut eines Eintrages im Array übereinstimmen soll
     * @return gibt an, ob der Löschvorgang erfolgreich war oder nicht
     */
    public boolean loeschEintrag(String eingabe) {
        if (eingabe != null && this.worteintraege != null) {
            for (int i = 0; i < this.worteintraege.length; i++) {
                if (eingabe.equals(this.worteintraege[i].getWort())) {
                    this.worteintraege[i] = null;
                    WortEintrag[] kuerzer = new WortEintrag[this.worteintraege.length - 1];
                    for (int j = 0; j < this.worteintraege.length; j++) {
                        if (this.worteintraege[j] != null) {
                            kuerzer[j] = this.worteintraege[j];
                        }
                    }
                    this.worteintraege = kuerzer;
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("");
    }

    /**
     * Ueberschriebene Methode toString, verwendet die toString von
     * Klasse WortEintrag und macht zwischen jedem Eintrag eine neue Zeile
     * @return das Array als String
     */
    @Override
    public String toString() {
        if (this.worteintraege != null) {
            String ausgabe = "";
            for (int i = 0; i < this.worteintraege.length; i++) {
                if (this.worteintraege[i] != null) {
                    ausgabe += this.worteintraege[i].toString() + "\n";
                }
            }
            return ausgabe;
        }
        return "Objekt oder Array hat Wert null";
    }
}
