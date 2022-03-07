package net.microservices.unNumberAndGroup.repository;

import net.microservices.unNumberAndGroup.models.UnNumber;
import reactor.core.publisher.Flux;

public interface UnNumberGroupCustomRepo
{
        Flux<UnNumber> findUnProperties(String unNumber,
                                        String unGroupCode,
                                        String unName,
                                        String createdBy,
                                        String createdDate);

}
