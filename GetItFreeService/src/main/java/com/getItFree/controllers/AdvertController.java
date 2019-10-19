package com.getItFree.controllers;


import com.getItFree.model.Advert;
import com.getItFree.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AdvertController {
    private final AdvertService advertService;

    @GetMapping("/adverts")
    public List<Advert> getListOfAdverts() {
        return advertService.findAllAdvertsFromDB();
    }

    @PostMapping("/add-advert")
    public Advert addAdvert(@RequestBody Advert advert) {
        return advertService.addNewAdvert(advert);
    }
}
