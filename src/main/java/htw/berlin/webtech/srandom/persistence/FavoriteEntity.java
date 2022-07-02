/**
 * Entitätenklasse zum Konvertieren von Objekten in SQL-Tabellen mit Ruhezustand
 * dies ist eine Art der Zuordnung zwischen Java-Klassen und SQL-Tabellen
 */

package htw.berlin.webtech.srandom.persistence;

import javax.persistence.*;

@Entity(name = "favorites")
public class FavoriteEntity {

    // numerischer Wert, sobald ein neuer Datensatz hinzugefügt wird → Strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "songId", nullable = false)
    private long songId;

    public FavoriteEntity(long songId) {
        this.songId = songId;
    }

    // Parameterlose Konstruktor, welches Hybernate braucht
    protected FavoriteEntity() {
    }

    public Long getId() {
        return id;
    }

    public long getSongs() {
        return songId;
    }

    public void setSongs(long songId) {
        this.songId = songId;
    }
}
