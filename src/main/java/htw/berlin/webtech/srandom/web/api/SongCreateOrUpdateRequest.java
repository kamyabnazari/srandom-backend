/**
 * Klasse benutzt um Songs zu erstellen und Updaten, ohne ID
 * */

package htw.berlin.webtech.srandom.web.api;

public class SongCreateOrUpdateRequest {

    private long id;
    private String titel;
    private String genre;
    // youtube oder spotify Link
    private String songLink;
    private String autor;
    private long erscheinungsdatum;

    public SongCreateOrUpdateRequest(String titel, String genre, String songLink, String autor, long erscheinungsdatum) {
        this.titel = titel;
        this.genre = genre;
        this.songLink = songLink;
        this.autor = autor;
        this.erscheinungsdatum = erscheinungsdatum;
    }

    // Parameterlosen Konstruktor um Post Requests fürs CorsMapping zu erlauben
    public SongCreateOrUpdateRequest() {}

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

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
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
