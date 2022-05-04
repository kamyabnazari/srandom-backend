/**
 * Interface welche zu Laufzeit funktionen zur Verfügung stellt, um mit dem Song Entity zu arbeiten
 * */

package htw.berlin.webtech.srandom.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {

    List<SongEntity> findAllByAutor(String autor);
}
