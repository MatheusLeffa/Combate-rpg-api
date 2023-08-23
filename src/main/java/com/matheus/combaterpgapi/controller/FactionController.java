package com.matheus.combaterpgapi.controller;

import com.matheus.combaterpgapi.dto.FactionDTO;
import com.matheus.combaterpgapi.mapper.FactionMapper;
import com.matheus.combaterpgapi.model.Faction;
import com.matheus.combaterpgapi.service.FactionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/factions")
@Slf4j
public class FactionController {

    private final FactionService factionService;

    public FactionController(FactionService factionService) {
        this.factionService = factionService;
    }

    @GetMapping
    public List<FactionDTO> findAll(){
        return factionService.findAll()
                .stream()
                .map(FactionMapper::entityToDto)
                .toList();
    }

    @GetMapping("/id/{id}")
    public FactionDTO findById(@PathVariable Integer id){
        return FactionMapper.entityToDto(factionService.findById(id));
    }

    @GetMapping("/name/{name}")
    public FactionDTO findByName(@PathVariable String name){
        return FactionMapper.entityToDto(factionService.findOneByName(name));
    }

    @PostMapping
    public FactionDTO create(@RequestBody @Valid FactionDTO faction){
        Faction entity = FactionMapper.dtoToEntity(faction);
        return FactionMapper.entityToDto(factionService.create(entity));
    }

    @PutMapping
    public FactionDTO update(@RequestBody @Valid FactionDTO faction){
        Faction entity = FactionMapper.dtoToEntity(faction);
        return FactionMapper.entityToDto(factionService.update(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        factionService.deleteById(id);
    }
}
