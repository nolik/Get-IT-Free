package com.getItFree.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by nolik on 03.07.17.
 */
@Data
@AllArgsConstructor
@Document
public class Advert {
    @Id
    private int id;
    private String head;
    private String content;
    private Date date;
    private String imageUrl;
}
