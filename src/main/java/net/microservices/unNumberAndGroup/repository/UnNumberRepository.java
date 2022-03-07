package net.microservices.unNumberAndGroup.repository;

import net.microservices.unNumberAndGroup.models.UnNumber;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository

public interface UnNumberRepository extends ReactiveMongoRepository<UnNumber,String>
{
    Flux<UnNumber> findByunGroupCodeIgnoreCase(String code);
    Flux<UnNumber> findByStatus(boolean b);
}
