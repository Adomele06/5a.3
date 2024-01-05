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
            trainer.laden("C:\\Users\\julia\\OneDrive\\OneDrive - tgm - Die Schule der Technik\\Dokumente\\3AHIT_burisic\\WortTrainer.txt");
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
