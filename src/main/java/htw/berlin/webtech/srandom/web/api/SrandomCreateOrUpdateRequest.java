package htw.berlin.webtech.srandom.web.api;

public class SrandomCreateOrUpdateRequest {

    private long id;
    private String titel;
    private String genre;
    // youtube oder spotify Link
    private String songLink;
    private String autor;
    private long erscheinungsdatum;

    public SrandomCreateOrUpdateRequest(String titel, String genre, String songLink, String autor, long erscheinungsdatum) {
        this.titel = titel;
        this.genre = genre;
        this.songLink = songLink;
        this.autor = autor;
        this.erscheinungsdatum = erscheinungsdatum;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYtLink() {
        return songLink;
    }

    public void setYtLink(String songLink) {
        this.songLink = songLink;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public long getErscheinungsdatum() {
        return erscheinungsdatum;
    }

    public void setErscheinungsdatum(long erscheinungsdatum) {
        this.erscheinungsdatum = erscheinungsdatum;
    }
}
