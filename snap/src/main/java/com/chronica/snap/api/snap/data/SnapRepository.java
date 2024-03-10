package com.chronica.snap.api.snap.data;

import com.chronica.snap.api.snap.entity.Snap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnapRepository extends JpaRepository<Snap,Long> {

}
