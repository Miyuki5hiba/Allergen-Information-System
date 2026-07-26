package com.allergen_info_service.Services;

import com.allergen_info_service.AllergenInformationSystem;
import com.fasterxml.jackson.databind.JsonNode;
//import tools.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service
public class GoodNightRestClientImpl implements GoodNightRestClient {
    private static final Logger log = LoggerFactory.getLogger(AllergenInformationSystem.class);

//    @Bean
//    @Override
//    public RestTemplate getAPI() {
////        org.springframework.web.client.RestClient restClient = builder.baseUrl("http://localhost:8085").build();
//
//        return new RestTemplate();
////        return args -> {
////            String response = restClient.get().uri("/night").retrieve().body(String.class);
////            log.info("Response from /night endpoint: {}", response);
////            return builder.baseUrl("http://localhost:8085").build();
////        };
//    }
//
//    @Bean
    public void getNight(){
        org.springframework.web.client.RestClient.Builder builder;
        RestTemplate template = new RestTemplate();
        template.getForEntity("http://localhost:8085/night", String.class);
    }
    public void fatter(){
        org.springframework.web.client.RestClient.Builder builder;
        RestTemplate template = new RestTemplate();
        template.getForEntity("http://localhost:8085/fat", Object.class);
    }

//    public ResponseEntity<JsonNode> getSnack(JsonNode rawJson){
//        org.springframework.web.client.RestClient.Builder builder;
//        RestTemplate template = new RestTemplate();
//        return template.getForEntity("http://localhost:8085/snack", JsonNode.class);
////        return template.getForEntity("http://localhost:8085/snack", rawJson);
//    }

    public String getSnack(JsonNode rawJson){
        org.springframework.web.client.RestClient.Builder builder;
        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8085/snack", String.class);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8085/snack", rawJson, String.class);
//        HttpStatusCode statusCode = response.getStatusCode();
//        HttpHeaders headers = response.getHeaders();
        return response.getBody();
//        return restTemplate.getForEntity("http://localhost:8085/snack", rawJson);
    }

}
