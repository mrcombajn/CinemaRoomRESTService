package cinema.controllers.handlers;


import cinema.exceptions.TicketPurchaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = TicketPurchaseException.class)
    public ResponseEntity<Object> handleTicketPurchaseException(TicketPurchaseException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error", ex.getMessage());
        return new ResponseEntity<>(body , HttpStatus.BAD_REQUEST);
    }
}
