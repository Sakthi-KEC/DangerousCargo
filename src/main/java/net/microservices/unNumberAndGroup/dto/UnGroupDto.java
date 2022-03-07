package net.microservices.unNumberAndGroup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnGroupDto
{
    private String unGroupCode;
    private String unGroupName;
    private String createdBy;
    private String createdDate;
}
