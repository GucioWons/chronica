package pl.gucio.enzo.chronica.user.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
    Optional<AccountEntity> findAccountEntityByMailAndIsActive(String mail, boolean isActive);

    Optional<AccountEntity> findAccountByMail(String mail);
}
