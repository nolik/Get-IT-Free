package com.getItFree.dto;

import com.getItFree.model.Advert;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private List<AdvertDTO> adverts;
}
