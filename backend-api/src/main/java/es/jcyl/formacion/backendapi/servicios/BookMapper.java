package es.jcyl.formacion.backendapi.servicios;


import es.jcyl.formacion.backendapi.controlador.BookRequest;
import es.jcyl.formacion.backendapi.persistencia.entidades.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book toBook (BookRequest req) {
        return Book.builder()
                .id(req.id())
                .title(req.title())
                .authorName(req.authorName())
                .isbn(req.isbn())
                .synopsis(req.synopsis())
                .archived(false)
                .shareable(req.shareable()).build();
    }
}
