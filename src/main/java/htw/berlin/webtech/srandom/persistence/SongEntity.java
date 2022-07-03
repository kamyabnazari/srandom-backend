/**
 * Entitätenklasse zum Konvertieren von Objekten in SQL-Tabellen mit Ruhezustand
 * dies ist eine Art der Zuordnung zwischen Java-Klassen und SQL-Tabellen
 */

package htw.berlin.webtech.srandom.persistence;

import javax.persistence.*;

@Entity(name = "songs")
public class SongEntity {

    // numerischer Wert, sobald ein neuer Datensatz hinzugefügt wird → Strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "releaseYear")
    private long releaseYear;

    @Column(name = "songLink", nullable = false)
    private String songLink;

    @Column(name = "isOriginal", nullable = false)
    private boolean isOriginal;

    @Column(name = "isFavorite", nullable = false)
    private boolean isFavorite;

    public SongEntity(String title, String author, long releaseYear, String songLink, boolean isOriginal, boolean isFavorite) {
        this.title = title;
        this.author = author;
        this.songLink = songLink;
        this.releaseYear = releaseYear;
        this.isOriginal = isOriginal;
        this.isFavorite = isFavorite;
    }

    // Parameterlose Konstruktor, welches Hybernate braucht
    protected SongEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
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
