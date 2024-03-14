package com.chronica.user.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.chronica.user.data.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
