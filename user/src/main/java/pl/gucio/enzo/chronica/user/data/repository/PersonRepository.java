package pl.gucio.enzo.chronica.user.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gucio.enzo.chronica.user.data.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
}
