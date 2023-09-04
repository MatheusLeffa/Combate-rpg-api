package com.matheus.combaterpgapi.controller;

import com.matheus.combaterpgapi.dto.CharacterDTO;
import com.matheus.combaterpgapi.dto.ThingDTO;
import com.matheus.combaterpgapi.mapper.CharacterMapper;
import com.matheus.combaterpgapi.mapper.ThingMapper;
import com.matheus.combaterpgapi.model.Character;
import com.matheus.combaterpgapi.model.Thing;
import com.matheus.combaterpgapi.service.CharacterService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/character")
@Slf4j
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<CharacterDTO> findAll(){
        return characterService.findAll()
                .stream()
                .map(CharacterMapper::entityToDto)
                .toList();
    }

    @GetMapping("/id/{id}")
    public CharacterDTO findById(@PathVariable Integer id){
        return CharacterMapper.entityToDto(characterService.findById(id));
    }

    @GetMapping("/name/{name}")
    public List<CharacterDTO> findByNome(@PathVariable String name){
        return characterService.findAllByName(name)
                .stream()
                .map(CharacterMapper::entityToDto)
                .toList();
    }

    @PostMapping
    public CharacterDTO create(@RequestBody CharacterDTO character){
        Character entity = CharacterMapper.dtoToEntity(character);
        return CharacterMapper.entityToDto(characterService.create(entity));
    }

    @PutMapping
    public CharacterDTO update(@RequestBody CharacterDTO character){
        Character entity = CharacterMapper.dtoToEntity(character);
        return CharacterMapper.entityToDto(characterService.update(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        characterService.deleteById(id);
    }



}
