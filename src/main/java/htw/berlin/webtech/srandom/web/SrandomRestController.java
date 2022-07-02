/**
 * REST Controller durch Springframework um HTTP Methoden zu Mappen
 */

package htw.berlin.webtech.srandom.web;

import htw.berlin.webtech.srandom.service.FavoriteService;
import htw.berlin.webtech.srandom.service.SongService;
import htw.berlin.webtech.srandom.web.api.Favorite;
import htw.berlin.webtech.srandom.web.api.FavoriteCreateOrUpdateRequest;
import htw.berlin.webtech.srandom.web.api.Song;
import htw.berlin.webtech.srandom.web.api.SongCreateOrUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class SrandomRestController {

    private final SongService songService;
    private final FavoriteService favoriteService;

    public SrandomRestController(SongService songService, FavoriteService favoriteService) {
        this.songService = songService;
        this.favoriteService = favoriteService;
    }

    @GetMapping(path = "/api/v1/songs")
    public ResponseEntity<List<Song>> fetchSongs() {
        return ResponseEntity.ok(songService.findAll());
    }

    @GetMapping(path = "/api/v1/songs/{id}")
    public ResponseEntity<Song> fetchSongsById(@PathVariable Long id) {
        var song = songService.findById(id);
        return song != null ? ResponseEntity.ok(song) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/songs")
    public ResponseEntity<Void> createSong(@RequestBody SongCreateOrUpdateRequest request) throws URISyntaxException {
        var song = songService.create(request);
        URI uri = new URI("/api/v1/songs/" + song.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/songs/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody SongCreateOrUpdateRequest request) {
        var song = songService.update(id, request);
        return song != null ? ResponseEntity.ok(song) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/songs/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        boolean successful = songService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/api/v1/favorites")
    public ResponseEntity<List<Favorite>> fetchFavorites() {
        return ResponseEntity.ok(favoriteService.findAll());
    }

    @GetMapping(path = "/api/v1/favorites/{id}")
    public ResponseEntity<Favorite> fetchFavoritesById(@PathVariable Long id) {
        var favorite = favoriteService.findById(id);
        return favorite != null ? ResponseEntity.ok(favorite) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/favorites")
    public ResponseEntity<Void> createFavorite(@RequestBody FavoriteCreateOrUpdateRequest request) throws URISyntaxException {
        var favorite = favoriteService.create(request);
        URI uri = new URI("/api/v1/favorites/" + favorite.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/favorites/{id}")
    public ResponseEntity<Favorite> updateSong(@PathVariable Long id, @RequestBody FavoriteCreateOrUpdateRequest request) {
        var favorite = favoriteService.update(id, request);
        return favorite != null ? ResponseEntity.ok(favorite) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/favorites/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long id) {
        boolean successful = favoriteService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
