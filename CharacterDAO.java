package rpg.dao;

import rpg.core.Character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implémentation du DAO pour les personnages.
 * Utilise une simulation de stockage en mémoire.
 */
public class CharacterDAO implements DAO<Character> {
    
    // Simulation d'une base de données en mémoire
    private final Map<String, Character> characterDatabase = new HashMap<>();
    
    @Override
    public boolean save(Character character) {
        try {
            characterDatabase.put(character.getName(), character);
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors de la sauvegarde du personnage: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public Character findByName(String name) {
        return characterDatabase.get(name);
    }
    
    @Override
    public List<Character> findAll() {
        return new ArrayList<>(characterDatabase.values());
    }
}