package es.jcyl.formacion.backendapi.controlador;

import es.jcyl.formacion.backendapi.servicios.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("feedbacks")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService service;

    @GetMapping("/book/{book-id}")
    public ResponseEntity<PageResponse<FeedbackResponse>> findAllFeedbacksByBook(
            @PathVariable("book-id") Integer bookId,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size )
    {
        return ResponseEntity.ok(service.findAllFeedbacksByBook(bookId, page, size));
    }

    @PostMapping
    public ResponseEntity<Integer> saveFeedback(
            @Valid @RequestBody FeedbackRequest req )
    {
        return ResponseEntity.ok(service.save(req));
    }


}
