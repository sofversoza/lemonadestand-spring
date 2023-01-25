package com.cooksys.lemonadestand.services;

import com.cooksys.lemonadestand.entities.Lemonade;

import java.util.List;

/*
   Interface instead of Class so if we change our business logic, like getAllLemonades() for example,
   we can change our implementation in the LemonadeServiceImpl, and not have to worry if any method is available or exists.
   all the methods defined in this Interface will exist on a class which implements it.
   This allows future maintainability and flexibility. We can change the implementing class and be guaranteed that
   my Controller never has to change (ex. not having to change what methods im calling as long as im calling methods from the Service interface)
   the implementations of those methods can change, the Controller will never have to.
*/
public interface LemonadeService {

    List<Lemonade> getAllLemonades();

    Lemonade createLemonade(Lemonade lemonade);
}
