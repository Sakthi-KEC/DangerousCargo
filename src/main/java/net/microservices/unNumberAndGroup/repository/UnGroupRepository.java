package net.microservices.unNumberAndGroup.repository;


import net.microservices.unNumberAndGroup.models.UnGroup;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface UnGroupRepository extends ReactiveMongoRepository<UnGroup,String>
{

}
