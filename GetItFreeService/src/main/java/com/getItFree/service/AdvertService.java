package com.getItFree.service;

import com.getItFree.model.Advert;

import java.util.List;

public interface AdvertService {

    public List<Advert> findAllAdvertsFromDB();

    public Advert addNewAdvert(Advert advert);
}