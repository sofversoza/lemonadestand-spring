package com.cooksys.lemonadestand.controllers;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.services.LemonadeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// HTTP REQUEST --> CONTROLLERS --> SERVICES --> REPOSITORIES

@RestController                 // tells Spring this Controller handles HTTP Requests & is set up in a RESTful manner (urls represented by nouns)
@RequestMapping("lemonades")    // handles endpoints that starts with /lemonades
@AllArgsConstructor             // Inject the dependencies (all fields)
public class LemonadeController {

    private LemonadeService lemonadeService;            // LemonadeService depends on LemonadeRepository (so we can getAllLemonades())

    @GetMapping                                         // GET all Lemonades --> /lemonades
    public List<Lemonade> getAllLemonades() {           // no params, GET Requests don't send a body
        return lemonadeService.getAllLemonades();       // CONTROLLERS DO NOT DIRECTLY INTERACT WITH THE REPOSITORIES; Pass Request to Service
    }

    @PostMapping                                                          // POST request to create a Lemonade
    public Lemonade createLemonade(@RequestBody Lemonade lemonade) {      // @RequestBody tells Spring we're receiving a json request which is a Lemonade obj
        return lemonadeService.createLemonade(lemonade);                  // Pass to Service
    }
}
