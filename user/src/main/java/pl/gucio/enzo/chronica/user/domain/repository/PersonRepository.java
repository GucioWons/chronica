package pl.gucio.enzo.chronica.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gucio.enzo.chronica.user.domain.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
}
