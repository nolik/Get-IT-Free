package com.getItFree.service.impl;

import com.getItFree.model.Advert;
import com.getItFree.repository.AdvertRepository;
import com.getItFree.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;

    public List<Advert> findAllAdvertsFromDB(){
        List<Advert> repositoryAll=  advertRepository.findAll();
        return repositoryAll;
    }

    public Advert addNewAdvert(Advert advert){
        return advertRepository.save(advert);
    }
}
