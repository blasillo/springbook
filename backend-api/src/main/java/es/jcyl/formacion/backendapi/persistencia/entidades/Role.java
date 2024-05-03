package es.jcyl.formacion.backendapi.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_roles")
@EntityListeners(AuditingEntityListener.class)
public class Role extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="id_rol")
    private Integer id;

    @Column(name="nombre", nullable = false, unique = true)
    private String name;


    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<User> user;
}
