package htw.berlin.webtech.srandom.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SrandomRepository extends JpaRepository<SrandomEntity, Long> {

    List<SrandomEntity> findAllByAutor(String autor);

}
