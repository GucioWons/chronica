package com.chronica.snap.api.snap.logic;

import com.chronica.snap.api.snap.data.SnapRepository;
import com.chronica.snap.api.snap.entity.Snap;
import org.chronica.library.exception.NoEntityException;
import com.chronica.snap.api.snap.mapper.SnapMapper;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.snap.SnapDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SnapService {
    private final SnapRepository snapRepository;
    private final SnapMapper snapMapper;

    public SnapDTO getSnapById(Long id) {
        return snapRepository.findByIdAndDeprecatedFalse(id)
                .map(snapMapper::mapToDTO)
                .orElseThrow(() -> new NoEntityException(Snap.class.getName(), id));
    }

    public SnapDTO createSnap(SnapDTO snap) {
        return snapMapper.mapToDTO(snapRepository.save(snapMapper.mapToNewEntity(snap)));
    }

    public SnapDTO updateSnap(Long id, SnapDTO dto) {
        return snapMapper.mapToDTO(snapRepository
                .save(snapMapper
                        .mapToUpdateEntity(snapRepository
                                .findById(id)
                                .orElseThrow(() -> new NoEntityException(Snap.class.getSimpleName(), id)), dto)));
    }

    public String deprecateSnap(Long id) {
        return snapRepository.findByIdAndDeprecatedFalse(id)
                .map(this::handleSnapDeprecation)
                .orElseThrow(() -> new NoEntityException(Snap.class.getSimpleName(), id));
    }

    private String handleSnapDeprecation(Snap snap) {
        snap.setDeprecated(true);
        snapRepository.save(snap);
        return "Snap has been deprecated.";
    }

    public List<SnapDTO> getSnapsByChainId(Long chainId) {
        return snapRepository.findAllByChainIdAndDeprecatedFalse(chainId).stream()
                .map(snapMapper::mapToDTO)
                .toList();
    }
}
