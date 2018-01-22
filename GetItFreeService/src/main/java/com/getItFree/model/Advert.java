package com.getItFree.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
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
    private ObjectId id;
    private String head;
    private String content;
    private Date date;
    private String imageUrl;
    private boolean ordered;

    public Advert(String head, String content, Date date, String imageUrl, boolean ordered) {
        this.id = new ObjectId();
        this.head = head;
        this.content = content;
        this.date = date;
        this.imageUrl = imageUrl;
        this.ordered = ordered;
    }
}
