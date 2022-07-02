package com.cdtu.myComment.controller;

import com.cdtu.myComment.entity.User;
import com.cdtu.myComment.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @Resource
    private ShopService shopService;
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){

        model.addAttribute("shop",shopService.getAll());
        model.addAttribute("username",request.getSession().getAttribute("username"));
        if (request.getSession().getAttribute("user")!= null){
            User user = (User) request.getSession().getAttribute("user");
            model.addAttribute("usertype",user.getUsertype());
        }

        if (request.getSession().getAttribute("username") != null){
            model.addAttribute("islogin",true);
        }else{
            model.addAttribute("islogin",false);
        }
        System.out.println("----------------controller启动-------------------");
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

    @RequestMapping("/classify")
    public  String classifyIndex(){
        return  "classify";
    }

    @RequestMapping("/myshop")
    public  String myshop(){
        return  "myshop";
    }
}
