package htw.berlin.webtech.srandom.web;

import htw.berlin.webtech.srandom.persistence.SrandomRepository;
import htw.berlin.webtech.srandom.service.SrandomService;
import htw.berlin.webtech.srandom.web.api.Srandom;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SrandomRestController {

   private final SrandomService srandomService;

    public SrandomRestController(SrandomService srandomService) {
        this.srandomService = srandomService;
    }

    @GetMapping(path = "/api/v1/srandom")
   public ResponseEntity <List<Srandom>> fetchSrandom (){
        return ResponseEntity.ok(srandomService.findAll());

    }
}
