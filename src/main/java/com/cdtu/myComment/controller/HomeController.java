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
    @RequestMapping("/shop")
    public String Shop(){
        return "shop";
    }
}
