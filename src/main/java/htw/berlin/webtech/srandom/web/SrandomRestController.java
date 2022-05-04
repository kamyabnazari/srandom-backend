/**
 * REST Controller um HTTP Methoden zu Mappen
 */

package htw.berlin.webtech.srandom.web;

import htw.berlin.webtech.srandom.service.SongService;
import htw.berlin.webtech.srandom.web.api.Song;
import htw.berlin.webtech.srandom.web.api.SongCreateOrUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class SrandomRestController {

    private final SongService srandomService;

    public SrandomRestController(SongService srandomService) {
        this.srandomService = srandomService;
    }

    @GetMapping(path = "/api/v1/srandom")
    public ResponseEntity<List<Song>> fetchSrandom() {
        return ResponseEntity.ok(srandomService.findAll());

    }

    @GetMapping(path = "/api/v1/srandom/{id}")
    public ResponseEntity<Song> fetchSrandomById(@PathVariable Long id) {
      var srandom = srandomService.findById(id);
      return srandom != null?  ResponseEntity.ok(srandom) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/srandom")
    public ResponseEntity<Void> createSrandom(@RequestBody SongCreateOrUpdateRequest request) throws URISyntaxException {
    var srandom = srandomService.create(request);
    URI uri = new URI( "/api/v1/srandom/" + srandom.getId());
    return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/srandom/{id}")
    public ResponseEntity<Song> updateSrandom(@PathVariable Long id, @RequestBody SongCreateOrUpdateRequest request){
        var srandom = srandomService.update(id, request);
        return srandom != null?  ResponseEntity.ok(srandom) : ResponseEntity.notFound().build();

    }

    @DeleteMapping(path = "/api/v1/srandom/{id}")
    public ResponseEntity<Void> deleteSandrom(@PathVariable Long id){
        boolean succesful = srandomService.deleteById(id);
        return succesful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
