/**
 * Datenhaltungs Klasse Song mit Variablen, Setter und Getter Methoden
 * This is the Java Object containing all the Information for further processing
 */

package htw.berlin.webtech.srandom.web.api;

public class Song {
    private long id;
    private String title;
    private String author;
    private long releaseYear;
    private String songLink;
    private boolean isOriginal;
    private boolean isFavorite;

    public Song(long id, String title, String author, long releaseYear, String songLink, boolean isOriginal, boolean isFavorite) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.songLink = songLink;
        this.isOriginal = isOriginal;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public boolean getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(boolean isOriginal) {
        this.isOriginal = isOriginal;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
