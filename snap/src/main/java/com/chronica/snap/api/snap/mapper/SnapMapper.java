package com.chronica.snap.api.snap.mapper;

import com.chronica.snap.api.snap.entity.Snap;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.dto.snap.SnapDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class SnapMapper implements BaseMapper<Snap, SnapDTO> {
    public abstract SnapDTO mapToDTO(Snap entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    public abstract Snap mapToNewEntity(SnapDTO dto);

    @Mapping(target = "id", ignore = true)
    public abstract Snap mapToUpdateEntity(@MappingTarget Snap toUpdate, SnapDTO dto);
}
