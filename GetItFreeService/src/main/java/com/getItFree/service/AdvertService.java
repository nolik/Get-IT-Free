package com.getItFree.service;

import com.getItFree.model.Advert;

import java.util.List;

public interface AdvertService {

    List<Advert> findAllAdverts();

    Advert addNewAdvert(Advert advert);
}