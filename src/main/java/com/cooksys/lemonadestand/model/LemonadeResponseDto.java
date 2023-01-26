package com.cooksys.lemonadestand.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LemonadeResponseDto {

    // fields we want to return
    // they are named exactly like the fields in our Lemonade entity bc Mappers care about field names
    private Long id;
    private double price;

}
