package com.matheus.combaterpgapi.mapper;


import com.matheus.combaterpgapi.dto.ThingDTO;
import com.matheus.combaterpgapi.model.Thing;
import org.modelmapper.ModelMapper;

public class ThingMapper {

    public static ThingDTO entityToDto(Thing thing){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(thing,ThingDTO.class);
    }

    public static Thing dtoToEntity(ThingDTO thingDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(thingDTO,Thing.class);
    }


}
