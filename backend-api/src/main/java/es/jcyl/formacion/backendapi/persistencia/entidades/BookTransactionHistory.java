package es.jcyl.formacion.backendapi.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_historico")
public class BookTransactionHistory extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="id_historico")
    private Integer id;


    @ManyToOne
    @JoinColumn (name="id_usuario")
    private User user;

    @ManyToOne
    @JoinColumn (name ="id_libro")
    private Book book;

    @Column(name="DEVUELTO")
    private boolean returned;
    @Column(name="DEVOLUCION_APROBADA")
    private boolean returnApproved;


}
