package adomele;
import java.io.*;
import java.util.Scanner;
public class SpeichernundLaden {

    /**
     * Methode speichern übernimmt einen Trainer und einen Pfad als String und speichert
     * den Trainer als Text file unter dem angegebenen Pfad
     * @param trainer Trainer Objekt aus Klasse WortTrainer
     * @param pfad der Pfad für das Text file als String
     * @throws IOException IOException
     */
    public static void speichern(WortTrainer trainer, String pfad) throws IOException {
        try(BufferedWriter outputStream = new BufferedWriter(new FileWriter(pfad))){
            outputStream.write(trainer.toString());
        }
    }

    /**
     * Methode speichern übernimmt einen Trainer und speichert
     * den Trainer als Text file im Ordner des Projekts
     * @param trainer Trainer Objekt aus Klasse WortTrainer
     * @throws IOException IOException
     */
    public static void speichern(WortTrainer trainer) throws IOException{
        speichern(trainer, "Worttrainer.txt");
    }

    /**
     * Methode laden liest Informationen des übergebenen Pfades aus, und speichert alle
     * gefundenen WortEintraege in den übergebenen Trainer
     * @param trainer Trainer Objekt aus Klasse WortTrainer
     * @param pfad der Pfad für das Text file als String
     * @throws FileNotFoundException IOException
     */
    public static void laden(WortTrainer trainer, String pfad) throws FileNotFoundException {
        try (Scanner s = new Scanner(new BufferedReader(new FileReader(pfad)))) {
            while (s.hasNextLine()) {
                String gelesen = s.nextLine();
                String[] arr = gelesen.split("; ", 2);
                if(!gelesen.contains("Abgefragte") && arr.length > 1) {
                    trainer.addEintrag(arr[0], arr[1]);
                }
                if(gelesen.contains("Abgefragte")){
                    String[] statistik = gelesen.split(";", 2);
                    int abgefragt = 0;
                    int richtig = 0;
                    Scanner abgefragtsc = new Scanner(statistik[0]);        //Abgefragte wörter
                    while (abgefragtsc.hasNext()) {
                        if (abgefragtsc.hasNextInt()) {
                            abgefragt = abgefragtsc.nextInt();
                        } else {
                            abgefragtsc.next();
                        }
                    }
                    Scanner richtigsc = new Scanner(statistik[1]);
                    while (richtigsc.hasNext()) {
                        if (richtigsc.hasNextInt()) {
                            richtig = richtigsc.nextInt();
                        } else {
                            richtigsc.next();
                        }
                    }
                    trainer.setStatistik(abgefragt, richtig);
                }
            }
        }
    }

    /**
     * Methode laden liest Informationen aus einem Text file aus, und speichert alle
     * gefundenen WortEintraege in den übergebenen Trainer
     * den Trainer als Text file im Ordner des Projekts
     * @param trainer Trainer Objekt aus Klasse WortTrainer
     * @throws FileNotFoundException IOException
     */
    public static void laden(WortTrainer trainer) throws FileNotFoundException {
        laden(trainer, "Worttrainer");
    }
}