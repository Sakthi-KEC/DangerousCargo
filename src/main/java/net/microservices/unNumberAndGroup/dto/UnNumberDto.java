package net.microservices.unNumberAndGroup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnNumberDto
{
    private String id;
    private String unNumber;
    private String unGroupCode;
    private String unName;
    private Boolean status;
    private String createdBy;
    private String createdDate;
    private Boolean saved;
}
