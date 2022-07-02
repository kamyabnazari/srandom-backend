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

    public Song(long id, String title, String author, long releaseYear, String songLink) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.songLink = songLink;
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

    public void setTitle(String titel) {
        this.title = title;
    }

    public void setAuthor(String autor) {
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
}
