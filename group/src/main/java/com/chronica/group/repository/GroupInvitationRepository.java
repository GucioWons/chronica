package com.chronica.group.repository;

import com.chronica.group.entity.GroupInvitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupInvitationRepository extends JpaRepository<GroupInvitation, Long> {
    GroupInvitation findByInvitedUserIdAndGroup_Id(Long invitedUserId, Long groupId);
}
