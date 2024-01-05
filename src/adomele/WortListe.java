package adomele;

public class WortListe {
    private WortEintrag[] eintraege;
    private int anzahlEintraege;

    public WortListe(int kapazitaet) {
        eintraege = new WortEintrag[kapazitaet];
        anzahlEintraege = 0;
    }

    public int getAnzahlEintraege() {
        return anzahlEintraege;
    }

    public WortEintrag getWortEintrag(int index) {
        if (index >= 0 && index < anzahlEintraege) {
            return eintraege[index];
        }
        return null;
    }
//Dd
    public boolean fuegeWortEintragHinzu(WortEintrag eintrag) {
        if (anzahlEintraege < eintraege.length) {
            eintraege[anzahlEintraege] = eintrag;
            anzahlEintraege++;
            return true;
        }
        return false;
    }

    public boolean loescheWortEintrag(String wort) {
        for (int i = 0; i < anzahlEintraege; i++) {
            if (eintraege[i].getWort().equals(wort)) {
                eintraege[i] = null;
                // Verschiebe die restlichen Einträge nach vorne
                for (int j = i; j < anzahlEintraege - 1; j++) {
                    eintraege[j] = eintraege[j + 1];
                }
                eintraege[anzahlEintraege - 1] = null;
                anzahlEintraege--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < anzahlEintraege; i++) {
            builder.append(eintraege[i].toString()).append("\n");
        }
        return builder.toString();
    }
}
