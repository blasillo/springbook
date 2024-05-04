package es.jcyl.formacion.backendapi.servicios;

import es.jcyl.formacion.backendapi.controlador.BookRequest;
import es.jcyl.formacion.backendapi.controlador.BookResponse;
import es.jcyl.formacion.backendapi.controlador.PageResponse;
import es.jcyl.formacion.backendapi.persistencia.entidades.Book;
import es.jcyl.formacion.backendapi.persistencia.entidades.User;
import es.jcyl.formacion.backendapi.persistencia.repositorios.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public PageResponse<BookResponse> findAllBooks (int page, int size) {

        // User user =  TODO
        Pageable pageable = PageRequest.of ( page, size);
        Page<Book> books = repo.findAllDisplayableBooks(pageable);

        List<BookResponse> booksResponse = books.stream()
                .map(bookMapper::toBookResponse)
                .toList();

        return new PageResponse<>(
                booksResponse,
                books.getNumber(),
                books.getSize(),
                books.getTotalElements(),
                books.getTotalPages(),
                books.isFirst(),
                books.isLast()
        );
    }
}
