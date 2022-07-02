/**
 * Funktionen und Methoden für den Song Entity
 */

package htw.berlin.webtech.srandom.service;

import htw.berlin.webtech.srandom.persistence.FavoriteEntity;
import htw.berlin.webtech.srandom.persistence.FavoriteRepository;
import htw.berlin.webtech.srandom.web.api.Favorite;
import htw.berlin.webtech.srandom.web.api.FavoriteCreateOrUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public List<Favorite> findAll() {
        List<FavoriteEntity> favorite = favoriteRepository.findAll();
        return favorite.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Favorite findById(Long id) {
        var favoriteEntity = favoriteRepository.findById(id);
        return favoriteEntity.map(this::transformEntity).orElse(null);
    }

    public Favorite create(FavoriteCreateOrUpdateRequest request) {
        var favoriteEntity = new FavoriteEntity(request.getSongId());
        favoriteEntity = favoriteRepository.save(favoriteEntity);
        return transformEntity(favoriteEntity);
    }

    public Favorite update(Long id, FavoriteCreateOrUpdateRequest request) {
        var favoriteEntityOptional = favoriteRepository.findById(id);
        if (favoriteEntityOptional.isEmpty()) {
            return null;
        }
        var favoriteEntity = favoriteEntityOptional.get();
        favoriteEntity.setSongs(request.getSongId());
        favoriteRepository.save(favoriteEntity);

        return transformEntity(favoriteEntity);
    }

    public boolean deleteById(Long id) {
        if (!favoriteRepository.existsById(id)) {
            return false;
        }
        favoriteRepository.deleteById(id);
        return true;
    }

    private Favorite transformEntity(FavoriteEntity favoriteEntity) {
        return new Favorite(
                favoriteEntity.getId(),
                favoriteEntity.getSongs());
    }
}
