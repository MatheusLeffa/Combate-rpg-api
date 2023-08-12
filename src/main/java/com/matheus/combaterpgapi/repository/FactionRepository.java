package com.matheus.combaterpgapi.repository;

import com.matheus.combaterpgapi.model.Faction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactionRepository extends JpaRepository<Faction, Integer>{

    Optional<Faction> findOneByFactionName (String factionName);

}
