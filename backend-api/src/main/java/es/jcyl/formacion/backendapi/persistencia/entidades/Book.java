package es.jcyl.formacion.backendapi.persistencia.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "APP_LIBROS")
@Entity
public class Book extends BaseEntity {

    @Id
    @GeneratedValue
    @Column (name = "ID_LIBRO", length = 512)
    private Integer id;

    @Column (name = "TITULO", length = 512)
    private String title;

    @Column (name = "AUTOR", length = 512)
    private String authorName;

    @Column (name = "ISBN", length = 64)
    private String isbn;

    @Column (name = "RESUMEN", length = 1024)
    private String synopsis;

    @Column (name = "PORTADA", length = 512)
    private String bookCover;

    @Column (name = "ARCHIVADO")
    private boolean archived;

    @Column (name = "ACTIVO")
    private boolean shareable;


    @ManyToOne
    @JoinColumn(name="id_propietario")
    private User owner;

    @OneToMany(mappedBy = "book")
    private List<Feedback>  feedbacks;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory>  histories;

    @Transient
    public double getRate () {
        // TODO: calcular el promedio de las notas
        return 0.0;
    }

}
