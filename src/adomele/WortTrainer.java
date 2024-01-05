package adomele;

import java.util.Random;

public class WortTrainer {
    private WortListe wortListe;
    private Random random;

    public WortTrainer(WortListe wortListe) {
        this.wortListe = wortListe;
        random = new Random();
    }

    public WortEintrag waehleZufaelligenEintrag() {
        if (wortListe != null && wortListe.getAnzahlEintraege() > 0) {
            int zufaelligerIndex = random.nextInt(wortListe.getAnzahlEintraege());
            return wortListe.getWortEintrag(zufaelligerIndex);
        }
        return null;
    }

    public WortEintrag getAktuellenEintrag() {
        return waehleZufaelligenEintrag();
    }

    public boolean check(String eingabe) {
        WortEintrag aktuellerEintrag = getAktuellenEintrag();
        if (aktuellerEintrag != null) {
            return aktuellerEintrag.getWort().equals(eingabe);
        }
        return false;
    }

    public boolean checkIgnoreCase(String eingabe) {
        WortEintrag aktuellerEintrag = getAktuellenEintrag();
        if (aktuellerEintrag != null) {
            return aktuellerEintrag.getWort().equalsIgnoreCase(eingabe);
        }
        return false;
    }
}
