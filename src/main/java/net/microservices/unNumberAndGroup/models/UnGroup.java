package net.microservices.unNumberAndGroup.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "unGroup")
public class UnGroup
{
    @Id
    private String unGroupCode;

    private String unGroupName;
    private String createdBy;
    private String createdDate;
}
