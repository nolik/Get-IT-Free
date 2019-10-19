package com.getItFree.dto;

import com.getItFree.model.Advert;
import lombok.Data;

import java.util.List;

@Data
public class UserAdverts {
    private List<Advert> userAdverts;
    private List<Advert> bookedAdverts;

    public UserAdverts(List<Advert> userAdverts, List<Advert> bookedAdverts) {
        this.userAdverts = userAdverts;
        this.bookedAdverts = bookedAdverts;
    }
}
