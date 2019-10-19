package com.getItFree.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserAdvertsDTO {
    private List<AdvertDTO> userAdverts;
    private List<AdvertDTO> bookedAdverts;
}
