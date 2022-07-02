/**
 * Klasse benutzt um Songs zu erstellen und Updaten, ohne ID
 * */

package htw.berlin.webtech.srandom.web.api;

public class FavoriteCreateOrUpdateRequest {

    private long SongId;

    public FavoriteCreateOrUpdateRequest(long SongId) {
        this.SongId = SongId;
    }

    // Parameterlosen Konstruktor um Post Requests fürs CorsMapping zu erlauben
    public FavoriteCreateOrUpdateRequest() {}

    public long getSongId() {
        return SongId;
    }

    public void setSongId(long SongId) {
        this.SongId = SongId;
    }
}
