package es.jcyl.formacion.backendapi.persistencia.repositorios;

import es.jcyl.formacion.backendapi.persistencia.entidades.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedBackRepository extends JpaRepository<Feedback, Integer> {

    @Query("""

            SELECT feedback
              FROM Feedback  feedback
             WHERE feedback.book.id = :bookId
           """)
    Page<Feedback> findAllByBookId(Integer bookId, Pageable pageable);
}
