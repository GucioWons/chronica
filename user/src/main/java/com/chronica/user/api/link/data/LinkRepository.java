package com.chronica.user.api.link.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.chronica.user.api.link.entity.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link,Long> {
    Link findLinkEntityByGeneratedCode(String generatedCode);
}
