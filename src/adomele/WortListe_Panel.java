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
        bild.setLayout(new BorderLayout());
        bild.setPreferredSize(new Dimension(0, 200));

        ImageIcon icon = new ImageIcon(new URL(url));
        observer = new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        };
        Image image = icon.getImage();
        double width = image.getWidth(observer) * 250 / image.getHeight(observer); //berechnet die Breite des Bildes in Relation zur ursprünglichen Breite bei einer Höhenänderung zu 250px
        image = image.getScaledInstance((int) width, 250,  Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
        this.bild = new JLabel(new ImageIcon(image)); // anzeigen in einem JLabel
        this.panelcenter.add(this.bild);
        this.add(this.panelcenter, BorderLayout.CENTER);

        panelbottom = new JPanel();
        panelbottom.setLayout(new GridLayout(2, 3));
        richtigeW = new JLabel("Richtige Wörter:");
        richtigeW.setFont(new Font("font", Font.ITALIC, 15));
        panelbottom.add(richtigeW);

        richtigeWZahl = new JLabel("0");
        richtigeWZahl.setFont(new Font("font", Font.ITALIC, 15));
        richtigeWZahl.setHorizontalAlignment(SwingConstants.CENTER);
        panelbottom.add(richtigeWZahl);

        refresh = new JButton("Zurücksetzen");
        refresh.addActionListener(control);
        refresh.setActionCommand("refresh");
        panelbottom.add(refresh);

        anzahlW = new JLabel("Abgefragte Wörter:");
        anzahlW.setFont(new Font("font", Font.ITALIC, 15));
        panelbottom.add(anzahlW);

        anzahlWZahl = new JLabel("0");
        anzahlWZahl.setFont(new Font("font", Font.ITALIC, 15));
        anzahlWZahl.setHorizontalAlignment(SwingConstants.CENTER);
        panelbottom.add(anzahlWZahl);

        addWort = new JButton("Wort hinzufügen");
        addWort.addActionListener(control);
        addWort.setActionCommand("neu");
        panelbottom.add(addWort);
        this.add(panelbottom, BorderLayout.PAGE_END);
    }

    /**
     * Liefert den eingegeben Text zurück
     * @return der Text im JTextField
     */
    public String getEingabe(){
        return eingabe.getText();
    }

    /**
     * Refresh Methode wird aufgerufen nachdem der neues Wort Button gedrückt wird.
     * @param richtige anzahl der richtigen Wörter
     * @param abgefragt anzahl der abgefragten Wörter
     * @param url die URL für das Bild
     * @throws MalformedURLException falls die URL nicht aufgerufen werden kann
     */
    public void refresh(int richtige, int abgefragt, String url) throws MalformedURLException {
        richtigeWZahl.setText(Integer.toString(richtige));
        anzahlWZahl.setText(Integer.toString(abgefragt));
        eingabe.setText("");
        setBild(url);

    }

    /**
     * setBild wird aufgerufen jedes mal, wenn das Bild neugeladen werden soll
     * @param url die URL für das Bild
     * @throws MalformedURLException falls die URL nicht aufgerufen werden kann
     */
    public void setBild(String url) throws MalformedURLException {
        ImageIcon icon = new ImageIcon(new URL(url));
        Image image = icon.getImage();

        int width = image.getWidth(observer) * 250 / image.getHeight(observer); //berechnet die Breite des Bildes in Relation zur ursprünglichen Breite bei einer Höhenänderung zu 250px
        image = image.getScaledInstance(width, 250,  Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
        bild.setIcon(new ImageIcon(image));
    }
}
