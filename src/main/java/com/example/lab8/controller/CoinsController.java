package com.example.lab8.controller;

import com.example.lab8.Dao.CoinsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coins")
public class CoinsController {
    @Autowired
    CoinsDao coinsDao;

    public void listar() {
        coinsDao.listarCoins();
        System.out.println(coinsDao.listarCoins());
    }
}
