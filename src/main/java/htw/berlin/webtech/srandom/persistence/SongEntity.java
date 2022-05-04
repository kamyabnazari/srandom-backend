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
    @Column(name = "id")
    private long id;

    @Column(name = "titel", nullable = false)
    private String titel;

    @Column(name = "genre")
    private String genre;

    @Column(name = "songLink", nullable = false)
    private String songLink;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "erscheinungsdatum")
    private long erscheinungsdatum;

    public SongEntity(String titel, String genre, String songLink, String autor, long erscheinungsdatum) {
        this.titel = titel;
        this.genre = genre;
        this.songLink = songLink;
        this.autor = autor;
        this.erscheinungsdatum = erscheinungsdatum;
    }

    // Parameterlose Konstruktor, welches Hybernate braucht
    protected SongEntity() {
    }

    public Long getId() {
        return id;
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

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
