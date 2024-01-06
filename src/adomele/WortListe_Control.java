package adomele;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Control Klasse implementiert ActionListener verbindet die GUI mit dem WortTrainer
 * @author Alex Domele
 * @version 2023-12-12
 */
public class WortListe_Control implements ActionListener {
    private WortTrainer trainer;
    private WortListe_Frame frame;
    private WortListe_Panel panel;

    /**
     * Konstruktor für Control erzeugt einen Trainer ein neues JFrame und ein neues JPanel
     */
    public WortListe_Control(){
        try{
            trainer = new WortTrainer(new WortListe(2));
            trainer.laden("C:\\Users\\alexa\\IdeaProjects\\Verschluesselung\\Spieldaten.txt");
            panel = new WortListe_Panel(this, trainer.getURL());
            new WortListe_Frame(panel, this.trainer);
        }
        catch (NumberFormatException numberFormatException){
            System.err.println(numberFormatException.getMessage());
        }
        catch(IllegalArgumentException illegalArgumentException){
            System.err.println(illegalArgumentException.getMessage());
        }
        catch (NullPointerException nullPointerException){
            System.err.println(nullPointerException.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Kein File!");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Methode aus ActionListener bestimmt den Ablauf nach dem Drücken eines Buttons
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
        if(action.equals("refresh")){
            trainer.getRandomEintrag();
            trainer.resetStatistik();
            try {
                panel.refresh(0, 0, trainer.getURL());
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (action.equals("neu")){
            String eingabe = panel.getEingabe();
            trainer.check(eingabe);
            trainer.getRandomEintrag();
            try {
                SpeichernundLaden.speichern(trainer);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            try {
                panel.refresh(trainer.getRichtige(), trainer.getAbgefragt(), trainer.getURL());
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Main Methode
     * @param args
     */
    public static void main(String[] args){
        new WortListe_Control();
    }
}
