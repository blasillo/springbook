package es.jcyl.formacion.backendapi;

import es.jcyl.formacion.backendapi.persistencia.entidades.Role;
import es.jcyl.formacion.backendapi.persistencia.repositorios.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BackendApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApiApplication.class, args);
    }


    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName("USUARIO").isEmpty()) {
                roleRepository.save(Role.builder().name("USUARIO").build());
            }

            if (roleRepository.findByName("ADMINISTRADOR").isEmpty()) {
                roleRepository.save(Role.builder().name("ADMINISTRADOR").build());
            }
        };
    }
}
