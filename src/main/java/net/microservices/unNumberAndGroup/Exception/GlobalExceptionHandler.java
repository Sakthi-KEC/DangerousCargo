package net.microservices.unNumberAndGroup.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

// This is Global exception handler
public class GlobalExceptionHandler
{
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDetails> mapException(CustomException ex)
    {
        ErrorDetails errorDetails
                = new ErrorDetails("404 NOT FOUND", ex.getMessage());

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> mapException4(Exception e)
    {
        ErrorDetails error = new ErrorDetails("Your Input is Invalid", "Kindly check the Details and Enter them correctly");
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
