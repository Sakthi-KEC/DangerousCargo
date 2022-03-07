package net.microservices.unNumberAndGroup.repository;

import net.microservices.unNumberAndGroup.models.UnNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomRepoImpl implements UnNumberGroupCustomRepo
{
    @Autowired
    public ReactiveMongoTemplate mongoTemplate;

   @Override
    public Flux<UnNumber> findUnProperties(String unNumber,
                                           String unGroupCode,
                                           String unName,
                                           String createdBy,
                                           String createdDate)
    {

        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();

        if (unNumber != null && !unNumber.isEmpty())
            criteria.add(Criteria.where("unNumber").is(unNumber));

        if (unGroupCode != null && !unGroupCode.isEmpty())
            criteria.add(Criteria.where("unGroupCode").is(unGroupCode));

        if (unName != null && !unName.isEmpty())
            criteria.add(Criteria.where("unName").is(unName));

        if (createdBy != null && !createdBy.isEmpty())
            criteria.add(Criteria.where("createdBy").is(createdBy));

        if (createdDate != null && !createdDate.isEmpty())
            criteria.add(Criteria.where("createdDate").is(createdDate));

        if (!criteria.isEmpty())
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));

    return mongoTemplate.find(query, UnNumber.class);
    }
}
