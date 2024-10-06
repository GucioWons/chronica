package com.chronica.group.mapper;

import com.chronica.group.entity.GroupInvitation;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.dto.group.GroupInvitationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "jakarta")
public interface GroupInvitationMapper extends BaseMapper<GroupInvitation, GroupInvitationDTO> {
    GroupInvitationDTO mapToDTO(GroupInvitation entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deprecated", ignore = true)
    GroupInvitation mapToNewEntity(GroupInvitationDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deprecated", ignore = true)
    GroupInvitation mapToUpdateEntity(@MappingTarget GroupInvitation toUpdate, GroupInvitationDTO dto);
}
