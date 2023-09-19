package com.matheus.combaterpgapi.dto;

import com.matheus.combaterpgapi.model.Character;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
public class FactionDTO {
    private Integer id;
    @NotEmpty
    private String factionName;
    private List<Character> characterList;
}
