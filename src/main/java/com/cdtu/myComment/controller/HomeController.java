package com.cdtu.myComment.controller;

import com.cdtu.myComment.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class HomeController {
    @Resource
    private ShopService shopService;
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("shop",shopService.getAll());
        return "index";
    }
    @RequestMapping("/theShop")
    public String theShop(){

        return "shop";
    }
     @RequestMapping("/login")
    public  String logIndex(){
        return  "login";
     }

    @RequestMapping("/sign")
    public  String signIndex(){
        return  "sign";
    }

    @RequestMapping("/search")
    public String search(){

        return "search";
    }
}
