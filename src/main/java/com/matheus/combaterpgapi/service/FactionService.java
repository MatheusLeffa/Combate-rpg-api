package com.matheus.combaterpgapi.service;

import com.matheus.combaterpgapi.exception.NotFoundException;
import com.matheus.combaterpgapi.model.Faction;
import com.matheus.combaterpgapi.repository.FactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class FactionService {

    private final FactionRepository factionRepository;

    public FactionService(FactionRepository factionRepository) {
        this.factionRepository = factionRepository;
    }

    public List<Faction> findAll(){
        return factionRepository.findAll();
    }

    public Faction findById(Integer id){
        return factionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID não localizado!"));
    }

    public Faction findOneByName(String name) {
        return factionRepository.findOneByName(name)
                .orElseThrow(() -> new NotFoundException("Facção não localizada por nome."));
    }

    public Faction create(Faction faction) {
        return factionRepository.save(faction);
    }

    public Faction update(Faction faction){
        Faction entity = this.findById(faction.getId());
        entity.setFactionName(faction.getFactionName());
        return factionRepository.save(entity);
    }

    public void deleteById(Integer id) {
        factionRepository.deleteById(this.findById(id).getId());
    }
}
