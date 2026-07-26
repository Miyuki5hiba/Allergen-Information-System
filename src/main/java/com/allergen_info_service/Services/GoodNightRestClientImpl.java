package com.allergen_info_service.Services;

import com.allergen_info_service.AllergenInformationSystem;
import com.fasterxml.jackson.databind.JsonNode;
//import tools.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service
public class GoodNightRestClientImpl implements GoodNightRestClient {
    private static final Logger log = LoggerFactory.getLogger(AllergenInformationSystem.class);

    @Value("${goodnight.url:http://localhost:8085}")
    private String goodNightUrl;

    public void getNight(){
        RestTemplate template = new RestTemplate();
        try {
            ResponseEntity<String> response = template.getForEntity(goodNightUrl + "/night", String.class);
            log.info("Response from /night endpoint: {}", response.getBody());
        } catch (Exception e) {
            log.error("Error calling /night endpoint at {}", goodNightUrl, e);
        }
    }

    public void fatter(){
        RestTemplate template = new RestTemplate();
        try {
            ResponseEntity<Object> response = template.getForEntity(goodNightUrl + "/fat", Object.class);
            log.info("Response from /fat endpoint: {}", response.getBody());
        } catch (Exception e) {
            log.error("Error calling /fat endpoint at {}", goodNightUrl, e);
        }
    }

    public String getSnack(JsonNode rawJson){
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                goodNightUrl + "/snack", 
                rawJson, 
                String.class
            );
            log.info("Response from /snack endpoint: {}", response.getBody());
            return response.getBody();
        } catch (Exception e) {
            log.error("Error calling /snack endpoint at {}", goodNightUrl, e);
            return "Error: " + e.getMessage();
        }
    }

}
