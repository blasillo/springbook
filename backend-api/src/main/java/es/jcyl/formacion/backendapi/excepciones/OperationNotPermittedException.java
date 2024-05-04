package es.jcyl.formacion.backendapi.excepciones;

public class OperationNotPermittedException extends RuntimeException {

    public OperationNotPermittedException() {}

    public OperationNotPermittedException(String message) {
        super(message);
    }
}
