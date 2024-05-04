package es.jcyl.formacion.backendapi.servicios;

import es.jcyl.formacion.backendapi.controlador.FeedbackRequest;
import es.jcyl.formacion.backendapi.controlador.FeedbackResponse;
import es.jcyl.formacion.backendapi.controlador.PageResponse;
import es.jcyl.formacion.backendapi.excepciones.OperationNotPermittedException;
import es.jcyl.formacion.backendapi.persistencia.entidades.Book;
import es.jcyl.formacion.backendapi.persistencia.entidades.Feedback;
import es.jcyl.formacion.backendapi.persistencia.repositorios.*;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedBackRepository feedBackRepo;
    private final BookRepository bookRepo;
    private final FeedbackMapper feedbackMapper;

    public Integer save(FeedbackRequest req) {

        Book book = bookRepo.findById( req.bookId() )
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el libro con id :: " + req.bookId()));

        if (book.isArchived() || !book.isShareable()) {
            throw new OperationNotPermittedException("No se pueden hacer comentarios de este libros");
        }

        Feedback feedback = feedbackMapper.toFeedback(req);
        return feedBackRepo.save(feedback).getId();

    }

    public PageResponse<FeedbackResponse> findAllFeedbacksByBook(Integer bookId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Feedback> feedbacks = feedBackRepo.findAllByBookId (bookId, pageable);
        List<FeedbackResponse> feedbackResponses = feedbacks.stream()
                .map(feedbackMapper::toFeedbackResponse)
                .toList();

        return new PageResponse<>(
                feedbackResponses,
                feedbacks.getNumber(),
                feedbacks.getSize(),
                feedbacks.getTotalElements(),
                feedbacks.getTotalPages(),
                feedbacks.isFirst(),
                feedbacks.isLast()
        );

    }
}
