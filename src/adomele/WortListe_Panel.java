package adomele;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Panel Klasse mit allen Attributen erbt von JPanel
 * @author Alex Domele
 * @version 2023-12-12
 */
public class WortListe_Panel extends JPanel {

    private JPanel paneltop, panelcenter, panelbottom;
    private JLabel frage, richtigeW, anzahlW, richtigeWZahl, anzahlWZahl;
    private JTextField eingabe;
    private JButton refresh, addWort, laden, speichern;
    private JLabel bild;
    private WortListe_Control control;
    private ImageObserver observer;

    /**
     * Konstruktor für das Panel
     * @param control Control Klasse um den ActionListener an die Buttons anzuhängen
     * @param url ertes Url für das Bild
     * @throws MalformedURLException falls die URl nicht funktioniert
     */
    public WortListe_Panel(WortListe_Control control, String url) throws MalformedURLException {
        this.control = control;
        this.setLayout(new BorderLayout());

        paneltop = new JPanel();
        paneltop.setLayout(new GridLayout(2, 1));
        frage = new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Überprüfen)?");
        frage.setFont(new Font("font", Font.ITALIC, 18));
        paneltop.add(frage);
        eingabe = new JTextField();
        eingabe.setFont(new Font("font", Font.BOLD, 20));
        paneltop.add(eingabe);
        this.add(paneltop, BorderLayout.PAGE_START);

        panelcenter = new JPanel();
        panelcenter.setLayout(new GridLayout());
        bild = new JLabel();
