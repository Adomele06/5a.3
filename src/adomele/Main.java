package adomele;

public class Main {
    public static void main(String[] args) {
        WortEintrag eintrag1 = new WortEintrag("Gym", "https://gym.com");
        System.out.println(eintrag1.getWort());
        System.out.println(eintrag1.getUrl());
        eintrag1.setWort("Keine Gym");
        System.out.println(eintrag1.checkURL("http://keineGym.com"));
        System.out.println(eintrag1);

        WortEintrag eintrag2 = new WortEintrag("Auto", "https://auto.at");
        WortEintrag eintrag3 = new WortEintrag("fahren", "http://fahren.ru");

        WortListe wortListe = new WortListe(10);
        wortListe.fuegeWortEintragHinzu(eintrag1);
        wortListe.fuegeWortEintragHinzu(eintrag2);
        wortListe.fuegeWortEintragHinzu(eintrag3);
        System.out.println(wortListe);
        wortListe.loescheWortEintrag("Auto");
        System.out.println(wortListe);
    }
}