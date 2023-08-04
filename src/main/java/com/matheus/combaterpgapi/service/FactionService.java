package com.matheus.combaterpgapi.service;

import com.matheus.combaterpgapi.mapper.FactionMapper;
import com.matheus.combaterpgapi.model.Faction;
import com.matheus.combaterpgapi.repository.FactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactionService {

    private final FactionRepository factionRepository;

    public FactionService(FactionRepository factionRepository) {
        this.factionRepository = factionRepository;
    }

    public List<Faction> findAll() {
        return factionRepository.findAll();
    }

    public Faction findById(Integer id) {
        return factionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID não localizado!"));
    }

    public Faction create(Faction faction) {
        return factionRepository.save(faction);
    }

    public Faction update(Faction faction){
        Faction entity = this.findById(faction.getId());
        // TODO: implementar alterações
        return factionRepository.save(entity);
    }

    //TODO: implementar o delete

}
