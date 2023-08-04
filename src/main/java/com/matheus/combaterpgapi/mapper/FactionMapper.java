package com.matheus.combaterpgapi.mapper;

import com.matheus.combaterpgapi.dto.FactionDTO;
import com.matheus.combaterpgapi.model.Faction;


public class FactionMapper {
    public static FactionDTO entityToDto(Faction faction) {
        FactionDTO factionDTO = new FactionDTO();
        factionDTO.setId(faction.getId());
        factionDTO.setFactionName(faction.getFactionName());
        return factionDTO;
    }

    public static Faction dtoToEntity (FactionDTO factionDTO){
        Faction faction = new Faction();
        faction.setId(factionDTO.getId());
        faction.setFactionName(factionDTO.getFactionName());
        return faction;
    }
}
