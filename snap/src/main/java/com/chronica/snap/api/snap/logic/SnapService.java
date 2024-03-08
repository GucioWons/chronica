package com.chronica.snap.api.snap.logic;

import com.chronica.snap.api.snap.data.SnapRepository;
import com.chronica.snap.api.snap.dto.SnapDTO;
import com.chronica.snap.api.snap.mapper.SnapMapper;
import jakarta.persistence.NoResultException;
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
                .orElseThrow(NoResultException::new);
    }

    public SnapDTO createSnap(SnapDTO dto) {
        return snapMapper.mapToDTO(snapRepository.save(snapMapper.mapToSaveEntity(dto)));
    }
}
