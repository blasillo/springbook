package es.jcyl.formacion.backendapi;

import es.jcyl.formacion.backendapi.persistencia.entidades.Role;
import es.jcyl.formacion.backendapi.persistencia.entidades.User;
import es.jcyl.formacion.backendapi.persistencia.repositorios.RoleRepository;
import es.jcyl.formacion.backendapi.persistencia.repositorios.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Optional;

@EnableJpaAuditing (auditorAwareRef = "auditorAware")
@SpringBootApplication
public class BackendApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApiApplication.class, args);
    }


    @Bean
    public CommandLineRunner runner(RoleRepository roleRepo, UserRepository userRepo) {
        return args -> {
            if (roleRepo.findByName("USUARIO").isEmpty()) {
                roleRepo.save(Role.builder().name("USUARIO").build());
            }

            if (roleRepo.findByName("ADMINISTRADOR").isEmpty()) {
                roleRepo.save(Role.builder().name("ADMINISTRADOR").build());
            }

            if (!userRepo.existsByEmail ("admin@formacion.jcyl.es")) {
                userRepo.save (
                        User.builder()
                                .email("admin@formacion.jcyl.es")
                                .firstname("Admin")
                                .lastname("Istrador")
                                .enabled(true)
                                .password("CambiaLaClaveYa!")
                                .accountLocked(false)
                                .build());
            }

            List<Role> roles = roleRepo.findAll();
            User user = userRepo.findByEmail("admin@formacion.jcyl.es").get();
            user.setRoles( roles );
            userRepo.save(user);
        };
    }
}
