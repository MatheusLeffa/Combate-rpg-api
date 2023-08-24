package com.matheus.combaterpgapi.repository;

import com.matheus.combaterpgapi.model.Thing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ThingRepository extends JpaRepository<Thing, Integer> {

    List<Thing> findAllByName(String name);

}
