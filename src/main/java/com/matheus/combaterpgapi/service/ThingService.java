package com.matheus.combaterpgapi.service;

import com.matheus.combaterpgapi.exception.NotFoundException;
import com.matheus.combaterpgapi.model.Thing;
import com.matheus.combaterpgapi.repository.ThingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ThingService {

    private final ThingRepository thingRepository;

    public ThingService(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    public List<Thing> findAll(){
        return thingRepository.findAll();
    }

    public Thing findById(Integer id){
        return thingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID não localizado!"));
    }

    public List<Thing> findAllByName(String name){
        return thingRepository.findAllByName(name);
    }

    public Thing create(Thing thing){
        return thingRepository.save(thing);
    }

    public Thing update(Thing thing){
        Thing entity = findById(thing.getId());
        entity.setName(thing.getName());
        entity.setHealth(thing.getHealth());
        entity.setPosition(thing.getPosition());
        return thingRepository.save(entity);
    }

    public void deleteById(Integer id){
        thingRepository.deleteById(this.findById(id).getId());
    }
}
