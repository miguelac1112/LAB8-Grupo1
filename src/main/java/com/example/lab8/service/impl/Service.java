package com.example.lab8.service.impl;


import com.example.lab8.entity.Coins;
import com.example.lab8.repository.CoinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private CoinsRepository coinsRepository;
    public Page<Coins> findProductsWithPaginationAndSorting(int offset, int pageSize, String field){
        Page<Coins> products = coinsRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  products;
    }

}
