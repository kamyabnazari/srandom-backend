package htw.berlin.webtech.srandom.web;

import htw.berlin.webtech.srandom.service.SrandomService;
import htw.berlin.webtech.srandom.web.api.Srandom;
import htw.berlin.webtech.srandom.web.api.SrandomCreateOrUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class SrandomRestController {

    private final SrandomService srandomService;

    public SrandomRestController(SrandomService srandomService) {
        this.srandomService = srandomService;
    }

    @GetMapping(path = "/api/v1/srandom")
    public ResponseEntity<List<Srandom>> fetchSrandom() {
        return ResponseEntity.ok(srandomService.findAll());

    }

    @GetMapping(path = "/api/v1/srandom/{id}")
    public ResponseEntity<Srandom> fetchSrandomById(@PathVariable Long id) {
      var srandom = srandomService.findById(id);
      return srandom != null?  ResponseEntity.ok(srandom) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/srandom")
    public ResponseEntity<Void> createSrandom(@RequestBody SrandomCreateOrUpdateRequest request) throws URISyntaxException {
    var srandom = srandomService.create(request);
    URI uri = new URI( "/api/v1/srandom/" + srandom.getId());
    return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/srandom/{id}")
    public ResponseEntity<Srandom> updateSrandom(@PathVariable Long id, @RequestBody SrandomCreateOrUpdateRequest request){
        var srandom = srandomService.update(id, request);
        return srandom != null?  ResponseEntity.ok(srandom) : ResponseEntity.notFound().build();

    }
}
