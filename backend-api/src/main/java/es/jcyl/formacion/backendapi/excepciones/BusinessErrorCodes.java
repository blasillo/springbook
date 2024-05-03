package es.jcyl.formacion.backendapi.excepciones;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public enum BusinessErrorCodes {

    NO_CODE(0, NOT_IMPLEMENTED, "No implementado"),
    INCORRECT_CURRENT_PASSWORD(300, BAD_REQUEST, "Contraseña incorrecta"),
    NEW_PASSWORD_DOES_NOT_MATCH(301, BAD_REQUEST, "La contraseña no coincide"),
    ACCOUNT_LOCKED(302, FORBIDDEN, "Cuenta de usuario bloqueada"),
    ACCOUNT_DISABLED(303, FORBIDDEN, "Cuenta de usuario desabilitada"),
    BAD_CREDENTIALS(304, FORBIDDEN, "Nombre de usuario o contraseña incorrectos"),
    ;

    @Getter
    private final int code;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code, HttpStatus status, String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = status;
    }
}
