package com.matheus.combaterpgapi.controller;

import com.matheus.combaterpgapi.dto.ThingDTO;
import com.matheus.combaterpgapi.mapper.ThingMapper;
import com.matheus.combaterpgapi.model.Thing;
import com.matheus.combaterpgapi.service.ThingService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/thing")
@Slf4j
public class ThingController {

    private final ThingService thingService;

    public ThingController(ThingService thingService) {
        this.thingService = thingService;
    }

    @GetMapping
    public List<ThingDTO> findAll(){
        return thingService.findAll()
                .stream()
                .map(ThingMapper::entityToDto)
                .toList();
    }

    @GetMapping("/id/{id}")
    public ThingDTO findById(@PathVariable Integer id){
        return ThingMapper.entityToDto(thingService.findById(id));
    }

    @GetMapping("/name/{name}")
    public List<ThingDTO> findByNome(@PathVariable String name){
        return thingService.findAllByName(name)
                .stream()
                .map(ThingMapper::entityToDto)
                .toList();
    }

    @PostMapping
    public ThingDTO create(@RequestBody @Valid ThingDTO thing){
        Thing entity = ThingMapper.dtoToEntity(thing);
        return ThingMapper.entityToDto(thingService.create(entity));
    }

    @PutMapping
    public ThingDTO update(@RequestBody @Valid ThingDTO thing){
        Thing entity = ThingMapper.dtoToEntity(thing);
        return ThingMapper.entityToDto(thingService.update(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        thingService.deleteById(id);
    }
}
