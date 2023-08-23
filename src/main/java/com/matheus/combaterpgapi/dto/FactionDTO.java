package com.matheus.combaterpgapi.dto;

import com.matheus.combaterpgapi.model.BaseCharacterOriginal;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
public class FactionDTO {
    private Integer id;
    @NotEmpty
    private String factionName;
    private List<BaseCharacterOriginal> characterList;

}
