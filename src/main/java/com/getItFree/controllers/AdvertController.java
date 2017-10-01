package com.getItFree.controllers;


import com.getItFree.model.Advert;
import com.getItFree.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    @GetMapping("/adverts")
    public List<Advert> getListOfAdverts(){
        return advertService.findAllAdvertsFromDB();
    }
}
