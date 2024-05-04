package es.jcyl.formacion.backendapi.servicios;

import es.jcyl.formacion.backendapi.controlador.FeedbackRequest;
import es.jcyl.formacion.backendapi.controlador.FeedbackResponse;
import es.jcyl.formacion.backendapi.persistencia.entidades.Book;
import es.jcyl.formacion.backendapi.persistencia.entidades.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackMapper {

    public Feedback toFeedback(FeedbackRequest request) {
        return Feedback.builder()
                .note(request.note())
                .comment(request.comment())
                .book(Book.builder()
                        .id(request.bookId())
                        .shareable(false) // Not required and has no impact :: just to satisfy lombok
                        .archived(false) // Not required and has no impact :: just to satisfy lombok
                        .build()
                )
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback) {
        return FeedbackResponse.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .ownFeedback( false )
                .build();
    }

}
