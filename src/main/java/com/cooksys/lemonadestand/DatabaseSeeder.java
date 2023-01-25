package com.cooksys.lemonadestand;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.repositories.CustomerRepository;
import com.cooksys.lemonadestand.repositories.LemonadeRepository;
import com.cooksys.lemonadestand.repositories.LemonadeStandRepository;
import com.cooksys.lemonadestand.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component              // tells Spring this is a Component Class, which then Spring will manage/instantiate; we're inverting control to Spring
@AllArgsConstructor     // instead of creating a constructor that takes all the dependencies we've defined; where Dependency Injection happens
public class DatabaseSeeder implements CommandLineRunner {

    // we define Dependencies by using object composition (DatabaseSeeder has a LemonadeRepository, etc)
    private LemonadeRepository lemonadeRepository;
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private LemonadeStandRepository lemonadeStandRepository;

    /*
     this constructor is where Dependency Injection happens, but we can just use the @AllArgsConstructor instead
     telling Spring the only way to create a DatabaseSeeder is to pass in the dependencies we've defined

        public DatabaseSeeder(LemonadeRepository lemonadeRepository) {
            this.lemonadeRepository = lemonadeRepository;
        }
    */

    // CommandLineRunner will run this method when the Application starts; between startup of the Server & running my Web Service
    // this method will populate the db with whatever code we have in the block
    // THIS IS THE ONLY PLACE WHERE WE'LL USE THE 'new' KEYWORD
    @Override
    public void run(String... args) throws Exception {
        Lemonade lemonade = new Lemonade();
        lemonade.setLemonJuice(3.25);
        lemonade.setWater(2.5);
        lemonade.setSugar(1.25);
        lemonade.setIceCubes(5);
        lemonade.setPrice(4.50);

        // using our LemonadeRepository after Dependency Injection to create new Lemonade in DB
        lemonadeRepository.saveAndFlush(lemonade);

        System.out.println(lemonadeRepository.findAll());
    }
}
