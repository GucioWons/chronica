package com.chronica.snap.api.snap.logic;

import com.chronica.snap.api.snap.data.SnapRepository;
import com.chronica.snap.api.snap.dto.SnapDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SnapService {
    private final SnapRepository snapRepository;

    public SnapDTO getSnapById(Long id) {
        return null;
    }

    public SnapDTO createSnap(SnapDTO snap) {
        return null;
    }
}
