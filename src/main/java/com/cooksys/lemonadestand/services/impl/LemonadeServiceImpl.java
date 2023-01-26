package com.cooksys.lemonadestand.services.impl;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.mappers.LemonadeMapper;
import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
import com.cooksys.lemonadestand.repositories.LemonadeRepository;
import com.cooksys.lemonadestand.services.LemonadeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 HTTP REQUEST --> CONTROLLERS (DTOs) --> SERVICES (Mappers) --> REPOSITORIES
 this implementation is a LemonadeService
 this is where we are implementing the logic of each of the methods that are defined in the LemonadeService interface
*/

@Service                    // to add the service class implementation (like how we used @Repository)
@AllArgsConstructor         // Inject Dependencies (all fields)
public class LemonadeServiceImpl implements LemonadeService {

    private LemonadeRepository lemonadeRepository;          // LemonadeService depends on LemonadeRepository
    private LemonadeMapper lemonadeMapper;                  // LemonadeService depends on LemonadeMapper


    // return list of all Lemonade entities
    @Override
    public List<LemonadeResponseDto> getAllLemonades() {
        return lemonadeMapper.entitiesToResponseDtos(lemonadeRepository.findAll());
    }


    // creates new request Lemonade dto, saves it in the DB, returns newly created Lemonade dto with generated id
    @Override
    public LemonadeResponseDto createLemonade(LemonadeRequestDto lemonadeRequestDto) {

        // map the request dto to a lemonade entity
        Lemonade lemonadeToSave = lemonadeMapper.requestDtoToEntity(lemonadeRequestDto);

        lemonadeToSave.setPrice(lemonadeToSave.getLemonJuice() * .20 +      // how were calculating the price
                lemonadeToSave.getWater() * .01 +
                lemonadeToSave.getSugar() * .15 +
                lemonadeToSave.getIceCubes() * .05 +
                .50);

        // save the new lemonade entity --> (lemonadeRepository.saveAndFlush(lemonadeToSave)
        // map newly saved entity with the generated id to a response dto & return it
        return lemonadeMapper.entityToResponseDto(lemonadeRepository.saveAndFlush(lemonadeToSave));
    }
}
