package com.sda.project;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
public class AnimalFactClient {

    public AnimalFact[] getAnimalFact(){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AnimalFact[]> exchange = restTemplate.exchange(
                "https://cat-fact.herokuapp.com/facts/random?animal_type=dog&amount=5",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                AnimalFact[].class
        );

        System.out.println("Status Code:" +exchange.getStatusCodeValue());
        Arrays.stream(exchange.getBody()).forEach(System.out::println);

        return exchange.getBody();

    }
}
