package it.nextdevs.mattina.exceptions;

import it.nextdevs.mattina.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudenteNonTrovatoException.class)
    public ResponseEntity<Object> StudenteNonTrovatoHandler(StudenteNonTrovatoException e) {
        Error error = new Error();
        error.setMessaggio(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        error.setStatoErrore(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
