package com.cooksys.lemonadestand.repositories;

import com.cooksys.lemonadestand.entities.Lemonade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository      // tells Spring this is a repository class, which does the conversion between the Entities and DB tables
                 // @Repository is a child of @Component (top level Annotation we use in DatabaseSeeder class)
public interface LemonadeRepository extends JpaRepository<Lemonade, Long> {   // <Entity, Entity's ID Type>
}
