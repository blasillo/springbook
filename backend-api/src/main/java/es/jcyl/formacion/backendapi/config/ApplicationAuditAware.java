package es.jcyl.formacion.backendapi.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class ApplicationAuditAware implements AuditorAware<Integer> {
    @Override
    public Optional<Integer> getCurrentAuditor() {
        // Authentication auth = ...

        final var result  = Optional.of(new Integer("0"));
        return result ;
    }
}
