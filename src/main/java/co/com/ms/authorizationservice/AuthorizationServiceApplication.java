package co.com.ms.authorizationservice;

import co.com.ms.authorizationservice.emuns.RoleName;
import co.com.ms.authorizationservice.entity.Role;
import co.com.ms.authorizationservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class AuthorizationServiceApplication implements CommandLineRunner {

	private final RoleRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role admin = Role.builder().role(RoleName.ROLE_ADMIN).build();
		Role user = Role.builder().role(RoleName.ROLE_USER).build();
		repository.save(admin);
		repository.save(user);
	}
}
