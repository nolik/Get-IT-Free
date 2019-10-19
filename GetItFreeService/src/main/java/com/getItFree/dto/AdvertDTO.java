package com.getItFree.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AdvertDTO {
    private Long id;
    private String head;
    private String content;
    private Date date;
    private String imageUrl;
    private boolean ordered;
}
