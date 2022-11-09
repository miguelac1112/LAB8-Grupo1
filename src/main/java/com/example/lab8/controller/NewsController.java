package com.example.lab8.controller;

import com.example.lab8.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    NewsDao newsDao;

    @GetMapping({"/list", "", "/"})
    public String listarNoticias(Model model) {
        model.addAttribute("listaNoticios", newsDao.listarNoticias());

        return "listanoticias";
    }
}
