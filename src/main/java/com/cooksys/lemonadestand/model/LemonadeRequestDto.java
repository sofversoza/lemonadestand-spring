package com.cooksys.lemonadestand.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/* DTOs (Data Transfer Objects) & Mappers
   DTOs exists on the Controller layer, it's what the external client knows about, it's what they send(request) & receive back(response) (input/output from our web service)
   We use our DTO classes on the Controller side (Controllers interacts with external clients)
   DTOs abstracts the external client away from the internal workings of our web service (we can hide certain data both for their request & response)
   Mappers are a part of the Service layer, exist so DTOs don't have to know about our Entities (Repositories) (we cant go 2 layers down)
   a Mapper class serves the class that'll convert from a DTO to an Entity, saves it to the DB, then converts it to a result DTO that we send back to the client
*/
@NoArgsConstructor      // DTO classes follows the JavaBean convention
@Data                   // Getters, Setters, toString, hashCode, .equals
public class LemonadeRequestDto {

    private double lemonJuice;
    private double water;
    private double sugar;
    private int iceCubes;
}
