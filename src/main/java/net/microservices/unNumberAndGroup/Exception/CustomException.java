package net.microservices.unNumberAndGroup.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// User defined NotFound exception
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomException extends Exception
{
    public CustomException(String message)
    {
        super(message);
    }
}
