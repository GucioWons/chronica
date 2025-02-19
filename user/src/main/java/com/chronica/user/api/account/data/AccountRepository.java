package com.chronica.user.api.account.data;

import com.chronica.user.api.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByMailAndActive(String mail, boolean isActive);
}
