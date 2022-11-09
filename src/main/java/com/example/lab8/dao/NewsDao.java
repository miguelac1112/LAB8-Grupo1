package com.example.lab8.dao;

import com.example.lab8.entity.News;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class NewsDao {

    public List<News> listarNoticias() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<News[]> responseEntity = restTemplate.getForEntity(
                "https://api.coinstats.app/public/v1/news", News[].class);

        if(responseEntity.getStatusCode() == HttpStatus.OK){
            News[] productsList = responseEntity.getBody();
            return Arrays.asList(productsList);
        }else{
            return new ArrayList<>();
        }

    }
}
