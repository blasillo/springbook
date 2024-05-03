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

    @GetMapping
    public ResponseEntity<String> sayHello () {
        return ResponseEntity.ok("Hola");
    }

    @PostMapping
    public ResponseEntity<Integer> saveBook (
            @Valid @RequestBody BookRequest request
    ) {

        return ResponseEntity.ok ( service.save(request) );

    }


}
