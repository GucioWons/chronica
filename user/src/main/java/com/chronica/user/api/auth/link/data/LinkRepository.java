package com.chronica.user.api.auth.link.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.chronica.user.api.auth.link.entity.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link,Long> {
    Link findLinkEntityByGeneratedCode(String generatedCode);
}
