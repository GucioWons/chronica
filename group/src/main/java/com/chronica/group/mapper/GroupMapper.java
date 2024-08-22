package com.chronica.group.mapper;

import com.chronica.group.entity.Group;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.group.dto.GroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "jakarta")
public interface GroupMapper extends BaseMapper<Group, GroupDTO> {

    GroupDTO mapToDTO(Group entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deprecated", ignore = true)
    Group mapToNewEntity(GroupDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deprecated", ignore = true)
    Group mapToUpdateEntity(@MappingTarget Group toUpdate, GroupDTO dto);
}
