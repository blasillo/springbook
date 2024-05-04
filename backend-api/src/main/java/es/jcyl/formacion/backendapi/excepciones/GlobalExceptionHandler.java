package es.jcyl.formacion.backendapi.excepciones;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exp) {
        exp.printStackTrace();

        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body (ExceptionResponse
                        .builder()
                        .businessErrorDescription("Error en la aplicación, contacte con el CAU")
                        .error( exp.getMessage() )
                        .build()
                );
    }
}
