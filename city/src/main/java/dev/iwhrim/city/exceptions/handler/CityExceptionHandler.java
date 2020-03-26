package dev.iwhrim.city.exceptions.handler;

import dev.iwhrim.city.exceptions.InvalidParameterValueException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CityExceptionHandler {

    @ExceptionHandler(value = {InvalidParameterValueException.class,
                                MethodArgumentNotValidException.class})
    public ResponseEntity<Object> exception(InvalidParameterValueException exception) {
        return new ResponseEntity<>("Invalid parameter value", HttpStatus.BAD_REQUEST);
    }

}
