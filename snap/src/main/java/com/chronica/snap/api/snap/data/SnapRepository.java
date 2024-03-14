package com.chronica.snap.api.snap.data;

import com.chronica.snap.api.snap.entity.Snap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SnapRepository extends JpaRepository<Snap,Long> {
    Optional<Snap> findByIdAndDeprecatedFalse(Long id);
    List<Snap> findAllByChainIdAndDeprecatedFalse(Long chainId);

}
