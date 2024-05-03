package es.jcyl.formacion.backendapi.persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "APP_TOKENS")
@Entity
public class Token {
    @Id
    @GeneratedValue
    @Column (name = "ID_TOKEN")
    private Integer id;

    @Column(name="TOKEN", length = 255, unique = true)
    private String token;

    @Column(name="F_CREACION")
    private LocalDateTime createdAt;
    @Column(name="F_EXPIRACION")
    private LocalDateTime expiresAt;
    @Column(name="F_VALIDACION")
    private LocalDateTime validatedAt;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private User user;
}
