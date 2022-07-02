/**
 * Interface welche zu Laufzeit funktionen zur Verfügung stellt, um mit dem Song Entity zu arbeiten
 * */

package htw.berlin.webtech.srandom.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long> {

}
