package es.jcyl.formacion.backendapi.controlador;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.jcyl.formacion.backendapi.servicios.BookService;

@RestController
@RequestMapping ("books")
@RequiredArgsConstructor
//@Tag (name="Book")
public class BookController {

    private final BookService service;

    @GetMapping("{book_id}")
    public ResponseEntity<BookResponse> bookById (@PathVariable("book_id") Integer bookId ) {
        return ResponseEntity.ok(service.findById(bookId));
    }

    @PostMapping
    public ResponseEntity<Integer> saveBook (
            @Valid @RequestBody BookRequest request
    ) {
        return ResponseEntity.ok ( service.save(request) );
    }

    @GetMapping
    public ResponseEntity<PageResponse<BookResponse>> findAllBook (
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size )
    {

        return ResponseEntity.ok ( service.findAllBooks (page, size) );
    }


}
