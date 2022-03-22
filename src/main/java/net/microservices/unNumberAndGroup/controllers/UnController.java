package net.microservices.unNumberAndGroup.controllers;


import net.microservices.unNumberAndGroup.dto.UnGroupDto;
import net.microservices.unNumberAndGroup.dto.UnNumberDto;
import net.microservices.unNumberAndGroup.services.UnServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

// Controller class
@RestController
@CrossOrigin(origins = "*")
public class UnController
{

    @Autowired
    private UnServices service;


//// UN Number

    @PostMapping("/unnumber")
    public Mono<UnNumberDto> addNumber(@RequestBody Mono<UnNumberDto> number)
    {
        return service.addNumber(number);
    }

    @PutMapping("/unnumber/edit/{id}")
    public Mono<UnNumberDto> editUnNumber(@RequestBody Mono<UnNumberDto> unNumber, @PathVariable String id)
    {
        return service.editUnNumber(unNumber,id);
    }

    @PutMapping("/unnumber/savedsearch")
    public Mono<UnNumberDto> addSearchedNumber(@RequestBody Mono<UnNumberDto> commodity)
    {
        return service.addSearchedNumber(commodity);
    }

    @GetMapping("/unnumber")
    public Flux<UnNumberDto> getAllUnNumber()
    {
        return service.getUnNumber();
    }

    @GetMapping("/unnumber/search")
    public Flux<UnNumberDto> getUnNmberByDynamicSearch(@RequestParam(required = false) String unNumber,
                                                       @RequestParam(required = false) String unGroupCode,
                                                       @RequestParam(required = false) String unName,
                                                       @RequestParam(required = false) String createdBy,
                                                       @RequestParam(required = false) String createdDate)
    {
        return service.getUnNmberByDynamicSearch(unNumber,unGroupCode,unName,createdBy,createdDate);
    }

    @GetMapping("/unnumber/savedsearch/codes")
    public Mono<List<String>> getAllSavedUnGroupCodes()
    {
        return service.getAllSavedUnGroupCodes();
    }

    @GetMapping("/unnumber/code/{code}")
    public Flux<UnNumberDto> getSavedUnNumberByUnGroupCode(@PathVariable String code)
    {
        return service.getSavedUnNumberByUnGroupCode(code);
    }


//// UN Group


    @PostMapping("/ungroup")
    public Mono<UnGroupDto> addUnGroup(@RequestBody Mono<UnGroupDto> group)
    {
        return service.addUnGroup(group);
    }

    @GetMapping("/ungroup/groupcodes")
    public Mono<List<String>> getAllUnGroupCodes()
    {
        return service.getAllUnGroupCodes();
    }


}
