package com.sda.project;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class DogImageClient {


    public String getDogImage() {

        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject("https://random.dog/woof.json", JsonNode.class);
        return jsonNode.get("url").asText();
    }
}
