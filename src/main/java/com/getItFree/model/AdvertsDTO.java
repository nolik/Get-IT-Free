package com.getItFree.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdvertsDTO {
    private List<AdvertDTO> items;
}
