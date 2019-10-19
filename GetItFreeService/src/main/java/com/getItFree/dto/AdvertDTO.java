package com.getItFree.dto;

import com.getItFree.model.AdvertStatus;
import lombok.Data;

import java.util.Date;

@Data
public class AdvertDTO {
    private Long id;
    private String head;
    private String content;
    private Date date;
    private String imageUrl;
    private AdvertStatus status;
}
