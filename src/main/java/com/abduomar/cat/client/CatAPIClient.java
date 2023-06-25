package com.abduomar.cat.client;

import com.abduomar.cat.model.Breed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CatAPIClient {
    private static final String API_BASE_URL = "https://api.thecatapi.com/";
    @Value("${cat.api.key}")
    private final String apiKey;

    private final RestTemplate restTemplate;

    public List<Breed> getAllBreeds() {
        String url = API_BASE_URL + "v1/breeds";
        ResponseEntity<Breed[]> response = restTemplate.getForEntity(url, Breed[].class);
        return Arrays.asList(response.getBody());
    }

    public Breed[] getBreedById() {
        String url = API_BASE_URL + "v1/breeds";
        ResponseEntity<Breed[]> response = restTemplate.getForEntity(url, Breed[].class);
        return response.getBody();
    }

}
