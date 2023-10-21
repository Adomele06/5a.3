package adomele;

public class Main {
    public static void main(String[] args) {
        WortEintrag eintrag1 = new WortEintrag("Gym", "https://gym.com");
        System.out.println(eintrag1.getWort());
        System.out.println(eintrag1.getUrl());
        eintrag1.setWort("Keine Gym");
        System.out.println(eintrag1.checkURL("http://keineGym.com"));
        System.out.println(eintrag1);
    }
}