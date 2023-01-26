package com.cooksys.lemonadestand.mappers;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

/*
   DTOs (Data Transfer Objects) & Mappers
   DTOs exists on the Controller layer, it's what the external client knows about, it's what they send(request) & receive back(response) (input/output from our web service)
   We use our DTO classes on the Controller side (Controllers interacts with external clients)
   DTOs abstracts the external client away from the internal workings of our web service (we can hide certain data both for their request & response)
   Mappers are a part of the Service layer, exist so DTOs don't have to know about our Entities (Repositories) (we cant go 2 layers down)
   a Mapper class serves the class that'll convert from a DTO to an Entity, saves it to the DB, then converts it to a result DTO that we send back to the client

   Interface bc im not implementing the logic, Mapstruck (the library who's generating our Mappers) is the one to generate an implementation for this class
   MAPSTRUCK DOESN'T RUN WHEN SPRING RUNS, WE HAVE TO RUN A MAVEN BUILD TO BE ABLE TO GENERATE THIS IMPLEMENTING CLASS
*/

@Mapper(componentModel="spring")           // tells Mapstruck its working with Spring
public interface LemonadeMapper {

    // method to map from a LemonadeRequestDto to a Lemonade Entity
    Lemonade requestDtoToEntity(LemonadeRequestDto lemonadeRequestDto);

    // method that takes a Lemonade Entity as a param & returns a LemonadeResponseDto
    LemonadeResponseDto entityToResponseDto(Lemonade lemonade);

    // method that returns a List of LemonadeResponseDto & takes a List of Lemonade Entities
    List<LemonadeResponseDto> entitiesToResponseDtos(List<Lemonade> lemonades);
}
