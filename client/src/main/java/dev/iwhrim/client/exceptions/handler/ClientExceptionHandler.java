package dev.iwhrim.client.exceptions.handler;

import dev.iwhrim.client.exceptions.ClientNotFoundException;
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

}
