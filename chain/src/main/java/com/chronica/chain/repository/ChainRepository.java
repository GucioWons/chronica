package com.chronica.chain.repository;

import com.chronica.chain.entity.Chain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainRepository extends JpaRepository<Chain, Long> {
}
