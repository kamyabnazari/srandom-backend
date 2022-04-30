package htw.berlin.webtech.srandom.web.api.api;

public class Srandom {
    private long id;
    private String titel;
    private String genre;
    //private String imageUrl;
    // youtubeLink oder spotify je nach dem
    private String ytLink;
    private String autor;
    private long erscheinungsdatum;

    public Srandom(long id, String titel, String genre, String ytLink , String autor, long erscheinungsdatum) {
        this.id = id;
        this.titel = titel;
        this.genre = genre;
        this.autor = autor;
        this.ytLink = ytLink;
        this.erscheinungsdatum = erscheinungsdatum;
       // this.imageUrl = imageUrl;

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }
   /* public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }  */

   public String getYtLink() {
        return ytLink;
    }

    public void setYtLink(String ytLink) {
        this.ytLink = ytLink;
    }

    public long getErscheinungsdatum() {
        return erscheinungsdatum;
    }

    public void setErscheinungsdatum(long erscheinungsdatum) {
        this.erscheinungsdatum = erscheinungsdatum;
    }
}
