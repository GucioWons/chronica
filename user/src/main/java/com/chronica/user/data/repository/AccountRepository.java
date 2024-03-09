package com.chronica.user.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.chronica.user.data.entity.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findAccountEntityByMailAndIsActive(String mail, boolean isActive);

    Optional<Account> findAccountByMail(String mail);
}
