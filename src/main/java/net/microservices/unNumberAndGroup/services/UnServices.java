package net.microservices.unNumberAndGroup.services;

import net.microservices.unNumberAndGroup.Exception.CustomException;
import net.microservices.unNumberAndGroup.appUtils.AppUtils;
import net.microservices.unNumberAndGroup.dto.UnGroupDto;
import net.microservices.unNumberAndGroup.dto.UnNumberDto;
import net.microservices.unNumberAndGroup.repository.UnGroupRepository;
import net.microservices.unNumberAndGroup.repository.UnNumberGroupCustomRepo;
import net.microservices.unNumberAndGroup.repository.UnNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnServices
{
    @Autowired
    private UnGroupRepository groupRepo;
    @Autowired
    private UnNumberGroupCustomRepo customRepo;
    @Autowired
    private UnNumberRepository numberRepo;


//// UN Number


    // Adding un-number into repo
    public Mono<UnNumberDto> addNumber(Mono<UnNumberDto> number)
    {
        return number.map(AppUtils::numberDtoToEntity)
                .flatMap(numberRepo::insert).map(AppUtils::numberEntityToDto);
    }

    // Editing the un-number by updating old record and inserting the new record
    public Mono<UnNumberDto> editUnNumber(Mono<UnNumberDto> unNumber, String id)
    {
        Mono<UnNumberDto> r = numberRepo.findById(id).map(AppUtils::numberEntityToDto);

        numberRepo.findById(id)
                .flatMap(p -> r.map(AppUtils::numberDtoToEntity))
                .doOnNext(e -> e.setStatus(false))
                .flatMap(numberRepo::save)
                .map(AppUtils::numberEntityToDto).subscribe();

        return unNumber.map(AppUtils::numberDtoToEntity)
                .flatMap(numberRepo::insert)
                .map(AppUtils::numberEntityToDto);
    }

    // Updating the Saved Status for the searched RsCommodity
    public Mono<UnNumberDto> addSearchedNumber(Mono<UnNumberDto> Number)
    {
        return  Number.map(AppUtils::numberDtoToEntity)
                .flatMap(numberRepo::save)
                .map(AppUtils::numberEntityToDto);
    }

    // getting all active UnNumber
    public Flux<UnNumberDto> getUnNumber()
    {
        return numberRepo
                .findByStatus(true)
                .map(AppUtils::numberEntityToDto);
    }

    // Getting un-number by dynamic search
    public Flux<UnNumberDto> getUnNmberByDynamicSearch(String unNumber, String unGroupCode, String unName, String createdBy, String createdDate)
    {
        return customRepo
                .findUnProperties(unNumber,unGroupCode,unName,createdBy,createdDate)
                .filter(a->a.getStatus()==true)
                .map(AppUtils::numberEntityToDto);
    }

    // Getting all saved ungroupCodes
    public Mono<List<String>> getAllSavedUnGroupCodes()
    {
        return numberRepo
                .findAll()
                .filter(a->a.getSaved()==true)
                .filter(a->a.getStatus()==true)
                .map(AppUtils::numberEntityToDto)
                .map(a->a.getUnGroupCode())
                .distinct()
                .collect(Collectors.toList());
    }

    // Getting un-number by using group code
    public Flux<UnNumberDto> getSavedUnNumberByUnGroupCode(String code)
    {
        return numberRepo.findByunGroupCodeIgnoreCase(code)
                .filter(a->a.getStatus()==true)
                .filter(a->a.getSaved()==true)
                .map(AppUtils::numberEntityToDto)
                .switchIfEmpty(Mono.defer(()->Mono.error(new CustomException("UnGroup Code Not Found"))));
    }


//// UN Group


    // Adding un-group into repo
    public Mono<UnGroupDto> addUnGroup(Mono<UnGroupDto> group)
    {
        return group.map(AppUtils::groupDtoToEntity)
                .flatMap(groupRepo::insert).map(AppUtils::groupEntityToDto);
    }

    // Getting all un-group codes
    public Mono<List<String>> getAllUnGroupCodes()
    {
        return groupRepo
                .findAll()
                .map(AppUtils::groupEntityToDto)
                .map(a->a.getUnGroupCode())
                .collect(Collectors.toList());
    }


}
