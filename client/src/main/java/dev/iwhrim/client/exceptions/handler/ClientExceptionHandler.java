package dev.iwhrim.client.exceptions.handler;

import dev.iwhrim.client.exceptions.ClientNotFoundException;
import dev.iwhrim.client.exceptions.InvalidDateTimeFormatException;
import dev.iwhrim.client.exceptions.InvalidParameterValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientExceptionHandler {

    @ExceptionHandler(value = ClientNotFoundException.class)
    public ResponseEntity<Object> exception(ClientNotFoundException exception) {
        return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidParameterValueException.class)
    public ResponseEntity<Object> exception(InvalidParameterValueException exception) {
        return new ResponseEntity<>("Invalid parameter value", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidDateTimeFormatException.class)
    public ResponseEntity<Object> exception(InvalidDateTimeFormatException exception) {
        return new ResponseEntity<>("Invalid ISO Zoned Date Time Format", HttpStatus.BAD_REQUEST);
    }

}
