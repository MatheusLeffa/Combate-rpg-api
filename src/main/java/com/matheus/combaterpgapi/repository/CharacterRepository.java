package com.matheus.combaterpgapi.repository;

import com.matheus.combaterpgapi.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    List<Character> findAllByName(String name);
}
