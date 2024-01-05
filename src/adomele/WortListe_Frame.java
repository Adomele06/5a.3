package adomele;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

/**
 * Klasse Frame erstellt ein Fenster und fügt das panel in das Fenster ein.
 * WindowAdapter wird als WindowListener verwendet und ruft eine laden Methode auf beim
 * Schließen des Fensters
 * @author Alex Domele
 * @version 2023-11-17
 */
public class WortListe_Frame extends JFrame{

    /**
     * Konstruktor der Frame Klasse
     * @param panel das hinzufügende Panel
     * @param trainer Trainer Objekt um die Daten zu speichern
     */
    public WortListe_Frame(WortListe_Panel panel, WortTrainer trainer){
        super("Wort-Trainer");
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                try {
                    trainer.schreiben("Spieldaten.txt");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        add(panel);
        setVisible(true);
    }
}
