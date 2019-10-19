package com.getItFree.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
