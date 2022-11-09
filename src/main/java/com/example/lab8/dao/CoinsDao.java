package com.example.lab8.dao;

import com.example.lab8.Dto.CoinTotalDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoinsDao {

    public CoinTotalDto[] listarCoins() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CoinTotalDto[]> response = restTemplate.getForEntity(
                "https://api.coinstats.app/public/v1/coins?skip=0&limit=10&currency=EUR", CoinTotalDto[].class);

        return response.getBody();
    }
}
