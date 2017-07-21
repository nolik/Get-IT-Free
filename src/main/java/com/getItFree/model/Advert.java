package com.getItFree.model;

import org.springframework.data.annotation.Id;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * Created by nolik on 03.07.17.
 */
@Data
public class Advert {
    @Id
    private int id;
    private byte[] image;
    private String head;
    private String content;
    private Timestamp date;

}
