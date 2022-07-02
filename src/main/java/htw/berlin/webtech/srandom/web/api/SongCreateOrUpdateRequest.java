/**
 * Klasse benutzt um Songs zu erstellen und Updaten, ohne ID
 * */

package htw.berlin.webtech.srandom.web.api;

public class SongCreateOrUpdateRequest {

    private String title;
    private String author;
    // youtube oder spotify Link
    private String songLink;
    private long releaseYear;
    private boolean isOriginal;
    private boolean isFavorite;
    public SongCreateOrUpdateRequest(String title, String author, long releaseYear, String songLink, boolean isOriginal, boolean isFavorite) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.songLink = songLink;
        this.isOriginal = isOriginal;
        this.isFavorite = isFavorite;
    }

    // Parameterlosen Konstruktor um Post Requests fürs CorsMapping zu erlauben
    public SongCreateOrUpdateRequest() {}

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

    public boolean setIsOriginal(boolean isOriginal) {
        return this.isOriginal = isOriginal;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
