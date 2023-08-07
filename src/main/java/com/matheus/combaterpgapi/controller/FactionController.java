package com.matheus.combaterpgapi.controller;

import com.matheus.combaterpgapi.dto.FactionDTO;
import com.matheus.combaterpgapi.mapper.FactionMapper;
import com.matheus.combaterpgapi.model.Faction;
import com.matheus.combaterpgapi.service.FactionService;
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

    @GetMapping("/{id}")
    public FactionDTO findById(@PathVariable Integer id){
        return FactionMapper.entityToDto(factionService.findById(id));
    }

    @PostMapping
    public FactionDTO create(@RequestBody FactionDTO faction){
        Faction entity = FactionMapper.dtoToEntity(faction);
        return FactionMapper.entityToDto(factionService.create(entity));
    }

    @PutMapping
    public FactionDTO update(@RequestBody FactionDTO faction){
        Faction entity = FactionMapper.dtoToEntity(faction);
        return FactionMapper.entityToDto(factionService.update(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        factionService.deleteById(id);
    }
}
