package co.com.ms.authorizationservice.repository;

import co.com.ms.authorizationservice.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String username);
}
