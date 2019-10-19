package com.getItFree.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

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
    @Range(min = 1, max = 5)
    private Integer price;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private AdvertStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "giver_id")
    private User giver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taker_id")
    private User taker;
}
