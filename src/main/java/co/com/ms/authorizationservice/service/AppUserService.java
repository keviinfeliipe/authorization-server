package co.com.ms.authorizationservice.service;

import co.com.ms.authorizationservice.dto.CreateAppUser;
import co.com.ms.authorizationservice.dto.Message;
import co.com.ms.authorizationservice.emuns.RoleName;
import co.com.ms.authorizationservice.entity.AppUser;
import co.com.ms.authorizationservice.entity.Role;
import co.com.ms.authorizationservice.repository.AppUserRepository;
import co.com.ms.authorizationservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    public Message createUser(CreateAppUser user){
        Set<Role> roles = user.roles().stream()
                .map(RoleName::valueOf)
                .map(rol -> roleRepository.findByRole(rol)
                        .orElseThrow(() -> new RuntimeException("Role Not Found")))
                .collect(Collectors.toSet());
        AppUser appUser = AppUser.builder()
                .username(user.username())
                .password(passwordEncoder.encode(user.password()))
                .roles(roles)
                .build();
        appUserRepository.save(appUser);
        return new Message("user " + appUser.getUsername() + " save");
    }
}
