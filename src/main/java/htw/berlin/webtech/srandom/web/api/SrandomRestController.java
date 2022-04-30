package htw.berlin.webtech.srandom.web.api;

import htw.berlin.webtech.srandom.web.api.api.Srandom;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SrandomRestController {

    private List<Srandom> songs;

    public SrandomRestController(){
        songs = new ArrayList<>();
        songs.add(new Srandom(1, "Love me more", "Pop",
                "https://www.youtube.com/watch?v=H1hDzq98WIY", "Sam Smith", 2022));
        songs.add(new Srandom(2, "Beautiful girl", "Hip-Hop",
                "https://www.youtube.com/watch?v=BWUR1e6fMtw", "Luciano", 2022));
        songs.add(new Srandom(3, "Lieben wir", "R&B",
                "https://www.youtube.com/watch?v=zuyN8KshIf4", "Shirin David",  2021));
    }
    @GetMapping(path = "/api/v1/songs")
   public ResponseEntity <List<Srandom>> fetchSongs (){
        return ResponseEntity.ok(songs);
    }

}
