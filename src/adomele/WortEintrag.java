package adomele;
/**
 * Klasse WortEintrag mit allen dazugehörigen Methoden
 * @author Alex Domele
 * @version 2023-09-23
 */
public class WortEintrag {
    private String wort, url;

    /**
     * Konstrukor WortEintrag
     * @param wort Attribut wort als String
     * @param url Attribute url als String
     */
    public WortEintrag(String wort, String url) {
        setWort(wort);
        setUrl(url);
    }

    /**
     * Setter Methode für das wort Attribut
     * @param wort Parameter
     */
    public void setWort(String wort) {
        if(wort != null) {
            this.wort = wort;
        }
        else {
            throw new IllegalArgumentException("Parameter ist leer!");
        }
    }

    /**
     * Setter Methode für das url Attribut
     * @param url Parameter
     */
    public void setUrl(String url) {
        if(checkURL(url)){
            this.url = url;
        }
        else {
            throw new IllegalArgumentException("URL ist falsch");
        }
    }

    /**
     * Getter Methode für wort
     * @return gibt Stand des Attributs wort zurück
     */
    public String getWort() {
        return wort;
    }

    /**
     * Getter Methode für url
     * @return gibt Stand des Attributs url zurück
     */
    public String getUrl() {
        return url;
    }

    /**
     * Methode checkURL überprüft ob Parameter ein gültiges URL ist
     * @param url Parameter
     * @return gibt, an ob die URL gültig ist oder nicht
     */
    public static boolean checkURL(String url) {
        if(url != null) {
            if(url.length() > 9) {
                String substringshort = url.substring(0, 7);
                if(substringshort.equals("http://")){
                    if(Character.isLetter(url.charAt(7))) {
                        return true;
                    }
                }
                String substringlong = url.substring(0, 8);
                if(substringlong.equals("https://")) {
                    if(Character.isLetter(url.charAt(8))) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        throw new IllegalArgumentException("URL ist leer!");
    }

    /**
     * Überschriebene Methode toString
     * @return Attribute des Objekts getrennt mit einem Strichpunkt
     */
    @Override
    public String toString() {
        return this.wort + "; " + this.url;
    }
}
