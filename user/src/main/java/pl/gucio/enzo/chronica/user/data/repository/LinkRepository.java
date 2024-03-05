package pl.gucio.enzo.chronica.user.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gucio.enzo.chronica.user.data.entity.LinkEntity;

@Repository
public interface LinkRepository extends JpaRepository<LinkEntity,Long> {
    LinkEntity findLinkEntityByGeneratedCode(String generatedCode);
}
