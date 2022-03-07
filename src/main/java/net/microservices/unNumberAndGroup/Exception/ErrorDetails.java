package net.microservices.unNumberAndGroup.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// To throw custom exception message
public class ErrorDetails
{
    private String errorMessage;
    private String Details;
}
