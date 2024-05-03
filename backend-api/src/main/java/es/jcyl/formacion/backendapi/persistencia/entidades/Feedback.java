package es.jcyl.formacion.backendapi.persistencia.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "APP_COMENTARIOS")
@Entity
public class Feedback extends BaseEntity {

    @Id
    @GeneratedValue
    @Column (name="ID_COMENTARIO")
    private Integer id;

    @Column (name="NOTA")
    private Double note;
    @Column (name="DESCRIPCION",length=1000)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "ID_LIBRO", nullable = false)
    private Book book;

}
