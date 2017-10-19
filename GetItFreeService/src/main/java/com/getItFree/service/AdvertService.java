package com.getItFree.service;

import com.getItFree.model.Advert;
import com.getItFree.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class AdvertService {

    private final AdvertRepository advertRepository;

    //temporary initialization of db
    private static List<Advert> adverts = new ArrayList<>();

    static {
        adverts.add(new Advert(1, "пивко", "забирай добрый люд пивко", Calendar.getInstance().getTime(),
                "https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg"));
        adverts.add(new Advert(2, "пивко2", "забирай добрый люд пивко", Calendar.getInstance().getTime(),
                "https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg"));
        adverts.add(new Advert(3, "пивко3", "забирай добрый люд пивко", Calendar.getInstance().getTime(),
                "https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg"));
    }

    @Autowired
    public AdvertService(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @PostConstruct
    public void init(){
        advertRepository.save(adverts);
    }


    public List<Advert> findAllAdvertsFromDB(){
      List<Advert> repositoryAll=  advertRepository.findAll();
        return repositoryAll;
    }
}
