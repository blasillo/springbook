package es.jcyl.formacion.backendapi.controlador;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (name = "books")
@RequiredArgsConstructor
//@Tag (name="Book")
public class BookController {

    private final BookService service;

    @PostMapping
    public ResponseEntity<Integer> saveBook (
            @Valid @RequestBody BookRequest request
    ) {

        return ResponseEntity.ok ( );

    }


}
