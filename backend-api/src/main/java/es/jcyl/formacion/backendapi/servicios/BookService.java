package es.jcyl.formacion.backendapi.servicios;

import es.jcyl.formacion.backendapi.controlador.BookRequest;
import es.jcyl.formacion.backendapi.controlador.BookResponse;
import es.jcyl.formacion.backendapi.persistencia.entidades.Book;
import es.jcyl.formacion.backendapi.persistencia.repositorios.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repo;
    private final BookMapper bookMapper;

    public Integer save(BookRequest request) {

        Book book = bookMapper.toBook (request);
        //book.setOwner();
        return repo.save(book).getId();
    }

    public BookResponse findById (Integer id) {
        return repo.findById(id)
                   .map(bookMapper::toBookResponse)
                   .orElseThrow( () -> new EntityNotFoundException("No se encontrado el libro con el id"));
    }
}
