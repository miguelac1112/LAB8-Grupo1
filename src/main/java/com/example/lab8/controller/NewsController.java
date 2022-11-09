package com.example.lab8.controller;

import com.example.lab8.dao.NewsDao;
import com.example.lab8.entity.Coins;
import com.example.lab8.service.impl.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    private Service service;
    @GetMapping(value = {"/list",""})
    public String findAll(@RequestParam(name="buscarx" , required = false) String buscarx, @RequestParam Map<String,Object> params, Model model){
        int page = params.get("page") != null ?(Integer.valueOf(params.get("page").toString())-1):0;

        if (buscarx != null){
            Page<Coins> pageIncidencia = service.findProductsWithPaginationAndSorting(page,5,buscarx);
            int totalPage  = pageIncidencia.getTotalPages();

            if (totalPage>0){
                List<Integer> pages  = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
            }
            model.addAttribute("lista",pageIncidencia.getContent());
            model.addAttribute("current",page+1);
            model.addAttribute("next",page+2);
            model.addAttribute("prev",page);
            model.addAttribute("last",totalPage);

            model.addAttribute("ordenarpor",buscarx);
        }else {
            Page<Coins> pageIncidencia = service.findProductsWithPaginationAndSorting(page,10,"title");
            int totalPage  = pageIncidencia.getTotalPages();

            if (totalPage>0){
                List<Integer> pages  = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
            }
            model.addAttribute("lista",pageIncidencia.getContent());
            model.addAttribute("current",page+1);
            model.addAttribute("next",page+2);
            model.addAttribute("prev",page);
            model.addAttribute("last",totalPage);

            model.addAttribute("ordenarpor","title");
        }


        return "listanoticias";
    }


    @Autowired
    NewsDao newsDao;

    @GetMapping({"/list", "", "/"})
    public String listarNoticias(Model model) {
        model.addAttribute("listaNoticios", newsDao.listarNoticias());

        return "listanoticias";
    }
}
