package com.matheus.combaterpgapi.service;

import com.matheus.combaterpgapi.exception.NotFoundException;
import com.matheus.combaterpgapi.model.Character;
import com.matheus.combaterpgapi.model.Thing;
import com.matheus.combaterpgapi.repository.CharacterRepository;
import com.matheus.combaterpgapi.repository.ThingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> findAll(){
        return characterRepository.findAll();
    }

    public Character findById(Integer id){
        return characterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID não localizado!"));
    }

    public List<Character> findAllByName(String name){
        return characterRepository.findAllByName(name);
    }

    public Character create(Character character){
        return characterRepository.save(character);
    }

    public Character update(Character character){
        Character entity = findById(character.getId());
        entity.setName(character.getName());
        entity.setHealth(character.getHealth());
        entity.setPosition(character.getPosition());
        return characterRepository.save(entity);
    }

    public void deleteById(Integer id){
        characterRepository.deleteById(this.findById(id).getId());
    }
}
