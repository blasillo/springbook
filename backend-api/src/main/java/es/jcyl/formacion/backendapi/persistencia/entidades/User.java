package es.jcyl.formacion.backendapi.persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_usuarios")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue
    @Column(name="ID_USUARIO")
    private Integer id;

    @Column(name="NOMBRE",length = 100, nullable = false)
    private String firstname;

    @Column(name="APELLIDOS", length = 150, nullable = false)
    private String lastname;

    @Column(name="F_NACIMIENTO")
    private LocalDate dateOfBirth;

    @Column(name="CORREO", length = 200, nullable = false, unique = true)
    private String email;
    @Column(name="CONTRASENA", length = 255, nullable = false )
    private String password;

    @Column(name="BLOQUEADO")
    private boolean accountLocked;

    @Column(name="ACTIVADO")
    private boolean enabled;

    @ManyToMany( fetch = EAGER )
    @JoinTable(
            name = "app_usuarios_roles", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private List<Role> roles;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    @OneToMany(mappedBy = "user")
    private List<BookTransactionHistory> histories;
}
