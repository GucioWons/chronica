package pl.gucio.enzo.chronica.user.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gucio.enzo.chronica.user.data.entity.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link,Long> {
    Link findLinkEntityByGeneratedCode(String generatedCode);
}
