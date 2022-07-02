/**
 * Datenhaltungs Klasse Song mit Variablen, Setter und Getter Methoden
 * This is the Java Object containing all the Information for further processing
 */

package htw.berlin.webtech.srandom.web.api;

public class Favorite {
    private long id;
    private long songId;

    public Favorite(long id, long songId) {
        this.id = id;
        this.songId = songId;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }
}
