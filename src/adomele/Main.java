package adomele;
import java.io.IOException;
/**
 * Klasse Test testet alle Methoden der drei KLassen WortEintrag, -Liste und -Trainer.
 * @author Alex Domele
 * @version 2023-09-23
 */
public class Main {
    public static void main(String[] args) {
        try {
            WortEintrag test = new WortEintrag("Gym", "http://a.d");
            System.out.println(test.checkURL("https://w.a"));
            System.out.println(test.getWort());
            System.out.println(test);
            System.out.println();
            System.out.println();
            System.out.println("Zweite Klasse:");


            WortListe liste = new WortListe(3);
            liste.neuerEintrag("Hantel", "http://a.d");
            liste.neuerEintrag("Stange", "http://a.d");
            liste.neuerEintrag("Maschine", "https://a.d");

            System.out.println(liste.getWort(3));
            System.out.println(liste.loeschEintrag("Katze"));
            System.out.println(liste.getWort(5));
            System.out.println("\ntoString: \n" + liste);

            WortTrainer trainer = new WortTrainer(liste);
            System.out.println("Dritte Klasse: ");
            System.out.println( trainer.getRandomEintrag());
            System.out.println(trainer.getAktuell());
            System.out.println(trainer.check("Hund"));
            System.out.println(trainer.checkIgnoreCase("Hund"));
            System.out.println(trainer.statistik());

            trainer.schreiben();
            trainer.laden();
            System.out.println(trainer);



        }
        catch (NumberFormatException numberFormatException){
            System.err.println(numberFormatException.getMessage());
        }
        catch(IllegalArgumentException illegalArgumentException){
            System.err.println(illegalArgumentException.getMessage());
        }
        catch (NullPointerException nullPointerException){
            System.err.println(nullPointerException.getMessage());
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
