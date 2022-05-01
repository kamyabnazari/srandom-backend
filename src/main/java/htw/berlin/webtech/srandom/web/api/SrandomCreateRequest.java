package htw.berlin.webtech.srandom.web.api;

public class SrandomCreateRequest {

    private long id;
    private String titel;
    private String genre;
    //private String imageUrl;
    // youtubeLink oder spotify je nach dem
    private String ytLink;
    private String autor;
    private long erscheinungsdatum;

    public SrandomCreateRequest(String titel, String genre, String ytLink, String autor, long erscheinungsdatum){
        this.titel = titel;
        this.genre = genre;
        this.ytLink = ytLink;
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
        return ytLink;
    }

    public void setYtLink(String ytLink) {
        this.ytLink = ytLink;
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
