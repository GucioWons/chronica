package pl.gucio.enzo.chronica.user.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gucio.enzo.chronica.user.domain.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
}
