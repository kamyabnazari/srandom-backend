/**
 * Funktionen und Methoden für den Song Entity
 */

package htw.berlin.webtech.srandom.service;

import htw.berlin.webtech.srandom.persistence.SongEntity;
import htw.berlin.webtech.srandom.persistence.SongRepository;
import htw.berlin.webtech.srandom.web.api.Song;
import htw.berlin.webtech.srandom.web.api.SongCreateOrUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAll() {
        List<SongEntity> song = songRepository.findAll();
        return song.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Song findById(Long id) {
        var songEntity = songRepository.findById(id);
        return songEntity.map(this::transformEntity).orElse(null);
    }

    public Song create(SongCreateOrUpdateRequest request) {
        var songEntity = new SongEntity(request.getTitel(), request.getGenre(), request.getSongLink(), request.getAutor(), request.getErscheinungsdatum());
        songEntity = songRepository.save(songEntity);
        return transformEntity(songEntity);
    }

    public Song update(Long id, SongCreateOrUpdateRequest request) {
        var songEntityOptional = songRepository.findById(id);
        if (songEntityOptional.isEmpty()) {
            return null;
        }
        var songEntity = songEntityOptional.get();
        songEntity.setAutor(request.getAutor());
        songEntity.setErscheinungsdatum(request.getErscheinungsdatum());
        songEntity.setSongLink(request.getSongLink());
        songEntity.setGenre(request.getGenre());
        songRepository.save(songEntity);

        return transformEntity(songEntity);
    }

    public boolean deleteById(Long id) {
        if (!songRepository.existsById(id)) {
            return false;
        }
        songRepository.deleteById(id);
        return true;
    }

    private Song transformEntity(SongEntity songEntity) {
        return new Song(

                songEntity.getId(),
                songEntity.getTitel(),
                songEntity.getGenre(),
                songEntity.getSongLink(),
                songEntity.getAutor(),
                songEntity.getErscheinungsdatum());
    }
}
