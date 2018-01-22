package com.getItFree.controllers;


import com.getItFree.model.Advert;
import com.getItFree.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdvertController {

    private final AdvertService advertService;

    @Autowired
    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping("/adverts")
    public List<Advert> getListOfAdverts(){
        return advertService.findAllAdvertsFromDB();
    }

    @PostMapping("/add-advert")
    public Advert addAdvert(@RequestBody Advert advert){
       return advertService.addNewAdvert(advert);
    }
}
