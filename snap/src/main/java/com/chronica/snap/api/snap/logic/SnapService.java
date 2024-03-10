package com.chronica.snap.api.snap.logic;

import com.chronica.snap.api.snap.data.SnapRepository;
import com.chronica.snap.api.snap.dto.SnapDTO;
import com.chronica.snap.api.snap.entity.Snap;
import com.chronica.snap.api.snap.exceptions.NoSnapException;
import com.chronica.snap.api.snap.mapper.SnapMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SnapService {
    private final SnapRepository snapRepository;
    private final SnapMapper snapMapper;

    public SnapDTO getSnapById(Long id) {
        return snapRepository.findById(id)
                .map(snapMapper::mapToDTO)
                .orElseThrow(() -> new NoSnapException("Cannot find Snap with id " + id));
    }

    public SnapDTO createSnap(SnapDTO snap) {
        return snapMapper.mapToDTO(snapRepository.save(snapMapper.mapToEntity(snap)));
    }

    public SnapDTO updateSnap(Long id, SnapDTO snap) {
        Snap toUpdate = snapMapper.mapToEntity(snap);
        toUpdate.setId(id);
        return snapMapper.mapToDTO(snapRepository.save(toUpdate));
    }

    public String deprecateSnap(Long id) {
        return snapRepository.findById(id)
                .map(this::handleSnapDeprecation)
                .orElseThrow(() -> new NoSnapException("Cannot find Snap with id " + id));
    }

    private String handleSnapDeprecation(Snap snap) {
        snap.setDeprecated(true);
        snapRepository.save(snap);
        return "Snap has been deprecated.";
    }
}
