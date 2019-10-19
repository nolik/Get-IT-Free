package com.getItFree.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String phone;
    private List<AdvertDTO> adverts;
    private List<AdvertDTO> tookAdverts;
}
