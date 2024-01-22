package co.com.ms.authorizationservice.repository;

import co.com.ms.authorizationservice.emuns.RoleName;
import co.com.ms.authorizationservice.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(RoleName roleName);
}
