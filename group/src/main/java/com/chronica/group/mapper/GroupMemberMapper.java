package com.chronica.group.mapper;

import com.chronica.group.entity.GroupMember;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.dto.group.GroupMemberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "jakarta")
public interface GroupMemberMapper extends BaseMapper<GroupMember, GroupMemberDTO> {
    GroupMemberDTO mapToDTO(GroupMember entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deprecated", ignore = true)
    GroupMember mapToNewEntity(GroupMemberDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deprecated", ignore = true)
    GroupMember mapToUpdateEntity(@MappingTarget GroupMember toUpdate, GroupMemberDTO dto);
}
