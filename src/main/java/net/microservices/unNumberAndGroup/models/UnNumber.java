package net.microservices.unNumberAndGroup.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UnNumber")
public class UnNumber
{
    @Id
    private String id;

    private String unNumber;
    private String unGroupCode;
    private String unName;
    private Boolean status;
    private String createdBy;
    private String createdDate;
    private Boolean saved;
}
