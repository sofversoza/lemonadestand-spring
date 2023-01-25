package com.cooksys.lemonadestand.services.impl;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.repositories.LemonadeRepository;
import com.cooksys.lemonadestand.services.LemonadeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 HTTP REQUEST --> CONTROLLERS --> SERVICES --> REPOSITORIES
 this implementation is a LemonadeService
 this is where we are implementing the logic of each of the methods that are defined in the LemonadeService interface
*/

@Service                    // to add the service class implementation (like how we used @Repository)
@AllArgsConstructor         // Inject Dependencies (all fields)
public class LemonadeServiceImpl implements LemonadeService {

    private LemonadeRepository lemonadeRepository;          // LemonadeService depends on LemonadeRepository (so we can getAllLemonades())

    @Override
    public List<Lemonade> getAllLemonades() {
        return lemonadeRepository.findAll();                // calls our Lemonade Repository (the one who interacts with our db)
    }

    @Override
    public Lemonade createLemonade(Lemonade lemonade) {
        lemonade.setPrice(lemonade.getLemonJuice() * .20 +  // we don't want the external user to be able to set any price
                lemonade.getWater() * .01 +
                lemonade.getSugar() * .15 +
                lemonade.getIceCubes() * .05 +
                .50);
        return lemonadeRepository.saveAndFlush(lemonade);   // returns the created lemonade with a generated id
    }
}
