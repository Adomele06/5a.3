package adomele;

public class WortEintrag {
    private String wort;
    private String url;

    public WortEintrag(String wort, String url) {
        this.wort = wort;
        this.url = url;
    }

    public String getWort() {
        return wort;
    }

    public void setWort(String wort) {
        if(wort.length() <2){
            throw new IllegalArgumentException("Zu kurz");
        }
        this.wort = wort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if(!checkURL(url)){
            throw new IllegalArgumentException("URL nicht gültig");
        }
        this.url = url;
    }

    public static boolean checkURL(String url) {
        return url.matches("^(http|https)://[a-zA-Z]+\\.[a-zA-Z]+$");
    }

    @Override
    public String toString() {
        return wort + ";" + url;
    }
}

