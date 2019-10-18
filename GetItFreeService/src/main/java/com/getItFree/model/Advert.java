package com.getItFree.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nolik on 03.07.17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advert {
    @Id
    @GeneratedValue
    private Long id;
    private String head;
    private String content;
    private Date date;
    private String imageUrl;
    private boolean ordered;
}
