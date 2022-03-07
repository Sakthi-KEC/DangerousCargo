//package net.apmoller.microservices.unNumberAndGroup;
//
//import static org.mockito.Mockito.when;
//
//import net.apmoller.microservices.unNumberAndGroup.controllers.UnController;
//import net.apmoller.microservices.unNumberAndGroup.dto.UnGroupDto;
//import net.apmoller.microservices.unNumberAndGroup.dto.UnNumberDto;
//import net.apmoller.microservices.unNumberAndGroup.services.UnServices;
//import org.junit.jupiter.api.Test;
//
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//@ExtendWith(SpringExtension.class)
//@WebFluxTest(controllers = UnController.class)
//@Import(UnServices.class)
//class UnNumberAndGroupApplicationTests
//{
//    @Autowired
//    private WebTestClient webTestClient;
//    @MockBean
//    private UnServices service;
//
//    @Test
//    public void addProductTest() {
//        Mono<UnGroupDto> productDtoMono = Mono.just(new UnGroupDto("1","Liquid","JKR","12-08-2021"));
//        when(service.addGroup(productDtoMono)).thenReturn(productDtoMono);
//
//        webTestClient.post().uri("/addgroup")
//                .body(Mono.just(productDtoMono),UnGroupDto.class)
//                .exchange()
//                .expectStatus().isOk();//200
//
//    }
//
//    @Test
//    public void addNumberTest() {
//        Mono<UnNumberDto> productDtoMono = Mono.just(new UnNumberDto("1","Liquid","oil","JKR","12-08-2021"));
//        when(service.addNumber(productDtoMono)).thenReturn(productDtoMono);
//
//        webTestClient.post().uri("/addgroup")
//                .body(Mono.just(productDtoMono),UnNumberDto.class)
//                .exchange()
//                .expectStatus().isOk();//200
//
//    }
//
//    @Test
//    public void getGroupProductsTest(){
//        Flux<UnGroupDto> productDtoFlux=Flux.just(new UnGroupDto("1","Liquid","JKR","12-08-2021"));
//
//        when(service.getAllGroup()).thenReturn(productDtoFlux);
//
//        Flux<UnGroupDto> responseBody = webTestClient.get().uri("/")
//                .exchange()
//                .expectStatus().isOk()
//                .returnResult(UnGroupDto.class)
//                .getResponseBody();
//
//        StepVerifier.create(responseBody)
//                .expectSubscription()
//                .expectNext(new UnGroupDto("1","Liquid","JKR","12-08-2021"))
//                .verifyComplete();
//
//    }
//    @Test
//    public void getGroupProductTest(){
//        Flux<UnGroupDto> productDtoFlux=Flux.just(new UnGroupDto("1","Liquid","JKR","12-08-2021"));
//
//        when(service.getAllGroup()).thenReturn(productDtoFlux);
//
//        Flux<UnGroupDto> responseBody = webTestClient.get().uri("/")
//                .exchange()
//                .expectStatus().isOk()
//                .returnResult(UnGroupDto.class)
//                .getResponseBody();
//
//        StepVerifier.create(responseBody)
//                .expectSubscription()
//                .expectNextMatches(p->p.getUnGroupName().equals("Liquid"))
//                .verifyComplete();
//
//    }
//
//    @Test
//    public void getGroupCodeTest(){
//        Flux<UnGroupDto> productDtoFlux=Flux.just(new UnGroupDto("1","Liquid","JKR","12-08-2021"));
//
//        when(service.getAllGroup()).thenReturn(productDtoFlux);
//
//        Flux<UnGroupDto> responseBody = webTestClient.get().uri("/")
//                .exchange()
//                .expectStatus().isOk()
//                .returnResult(UnGroupDto.class)
//                .getResponseBody();
//
//        StepVerifier.create(responseBody)
//                .expectSubscription()
//                .expectNextMatches(p->p.getUnGroupCode().equals("1"))
//                .verifyComplete();
//
//    }
//    @Test
//    public void getNumberTest(){
//        Flux<UnNumberDto> productDtoFlux=Flux.just(new UnNumberDto("1","Liquid","oil","JKR","12-08-2021"));
//
//        when(service.getAllNumbers()).thenReturn(productDtoFlux);
//
//        Flux<UnNumberDto> responseBody = webTestClient.get().uri("/unnumber")
//                .exchange()
//                .expectStatus().isOk()
//                .returnResult(UnNumberDto.class)
//                .getResponseBody();
//
//        StepVerifier.create(responseBody)
//                .expectSubscription()
//                .expectNextMatches(p->p.getUnNumber().equals("1"))
//                .verifyComplete();
//
//    }
//
//    @Test
//    public void getNumberCodeTest(){
//        Flux<UnNumberDto> productDtoFlux=Flux.just(new UnNumberDto("1","Liquid","oil","JKR","12-08-2021"));
//
//        when(service.getAllNumbers()).thenReturn(productDtoFlux);
//
//        Flux<UnNumberDto> responseBody = webTestClient.get().uri("/unnumber")
//                .exchange()
//                .expectStatus().isOk()
//                .returnResult(UnNumberDto.class)
//                .getResponseBody();
//
//        StepVerifier.create(responseBody)
//                .expectSubscription()
//                .expectNextMatches(p->p.getUnGroupCode().equals("Liquid"))
//                .verifyComplete();
//
//    }
//    @Test
//    public void getUnNameTest(){
//    Flux<UnNumberDto> productDtoFlux=Flux.just(new UnNumberDto("1","Liquid","oil","JKR","12-08-2021"));
//
//    when(service.getAllNumbers()).thenReturn(productDtoFlux);
//
//    Flux<UnNumberDto> responseBody = webTestClient.get().uri("/unnumber")
//            .exchange()
//            .expectStatus().isOk()
//            .returnResult(UnNumberDto.class)
//            .getResponseBody();
//
//    StepVerifier.create(responseBody)
//            .expectSubscription()
//            .expectNextMatches(p->p.getUnName().equals("oil"))
//            .verifyComplete();
//
//}
//    @Test
//    public void getCreatedByTest(){
//        Flux<UnNumberDto> productDtoFlux=Flux.just(new UnNumberDto("1","Liquid","oil","JKR","12-08-2021"));
//
//        when(service.getAllNumbers()).thenReturn(productDtoFlux);
//
//        Flux<UnNumberDto> responseBody = webTestClient.get().uri("/unnumber")
//                .exchange()
//                .expectStatus().isOk()
//                .returnResult(UnNumberDto.class)
//                .getResponseBody();
//
//        StepVerifier.create(responseBody)
//                .expectSubscription()
//                .expectNextMatches(p->p.getCreatedBy().equals("JKR"))
//                .verifyComplete();
//
//    }
//
//}
