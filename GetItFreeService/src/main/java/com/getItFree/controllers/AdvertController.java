package com.getItFree.controllers;


import com.getItFree.dto.AdvertDTO;
import com.getItFree.model.Advert;
import com.getItFree.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AdvertController {
    private final AdvertService advertService;
    private final ModelMapper modelMapper;

    @GetMapping("/adverts")
    public List<AdvertDTO> getListOfAdverts() {
        return advertService.findAllAdvertsFromDB().stream()
                .map(advert -> modelMapper.map(advert, AdvertDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/add-advert")
    public Advert addAdvert(@RequestBody Advert advert) {
        return advertService.addNewAdvert(advert);
    }
}
