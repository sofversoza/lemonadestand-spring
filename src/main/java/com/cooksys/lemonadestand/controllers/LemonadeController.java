package com.cooksys.lemonadestand.controllers;

import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
import com.cooksys.lemonadestand.services.LemonadeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// HTTP REQUEST --> CONTROLLERS (DTOs) --> SERVICES (Mappers) --> REPOSITORIES

@RestController                     // tells Spring this Controller handles HTTP Requests & is set up in a RESTful manner (urls represented by nouns)
@RequestMapping("lemonades")        // handles endpoints that starts with /lemonades
@AllArgsConstructor                 // Inject the dependencies (all fields)
public class LemonadeController {

    private LemonadeService lemonadeService;                // LemonadeService depends on LemonadeRepository (so we can getAllLemonades())

    @GetMapping                                             // GET all Lemonades --> /lemonades
    public List<LemonadeResponseDto> getAllLemonades() {    // We're returning a Lemonade DTO
        return lemonadeService.getAllLemonades();           // CONTROLLERS DO NOT DIRECTLY INTERACT WITH THE REPOSITORIES; Pass Request to Service
    }

    @PostMapping                                                                                         // POST request to create a Lemonade
    public LemonadeResponseDto createLemonade(@RequestBody LemonadeRequestDto lemonadeRequestDto) {      // @RequestBody tells Spring we're receiving a json request which is a Lemonade Dto obj
        return lemonadeService.createLemonade(lemonadeRequestDto);                                       // Pass to Service
    }
}
