package com.matheus.combaterpgapi.service;

import com.matheus.combaterpgapi.exception.AlreadyExistsException;
import com.matheus.combaterpgapi.exception.NotFoundException;
import com.matheus.combaterpgapi.model.Faction;
import com.matheus.combaterpgapi.repository.FactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class FactionService {

    private final FactionRepository factionRepository;

    public FactionService(FactionRepository factionRepository) {
        this.factionRepository = factionRepository;
    }

    public List<Faction> findAll() {
        return factionRepository.findAll();
    }

    public Faction findById(Integer id){
        return factionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID não localizado!"));
    }

    public Faction create(Faction faction) {
        if (this.findByName(faction.getFactionName()).isPresent()){
            log.error("A facção já existe!");
            throw new AlreadyExistsException("A facção já existe!");
        }
        return factionRepository.save(faction);
    }

    public Faction update(Faction faction){
        Faction entity = this.findById(faction.getId());
        if (this.findByName(faction.getFactionName()).isPresent()) {
            log.error("O nome da facção já é " + faction.getFactionName() + ".");
            throw new AlreadyExistsException("O nome da facção já é " + faction.getFactionName() + ".");
        }
        entity.setFactionName(faction.getFactionName());
        return factionRepository.save(entity);
    }

    public void deleteById(Integer id) {
        factionRepository.deleteById(this.findById(id).getId());
    }

    public Optional<Faction> findByName(String factionName) {
        return factionRepository.findOneByFactionName(factionName);
    }
}
