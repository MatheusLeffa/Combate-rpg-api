package com.matheus.combaterpgapi.mapper;

import com.matheus.combaterpgapi.dto.CharacterDTO;
import com.matheus.combaterpgapi.dto.ThingDTO;
import com.matheus.combaterpgapi.model.Character;
import org.modelmapper.ModelMapper;

public class CharacterMapper {

    public static CharacterDTO entityToDto(Character character){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(character,CharacterDTO.class);
    }

    public static Character dtoToEntity(CharacterDTO characterDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(characterDTO,Character.class);
    }

}
