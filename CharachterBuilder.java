package rpg.builder;

import rpg.core.Character;
import rpg.settings.GameSettings;

/**
 * Builder pour construire des personnages étape par étape.
 */
public class CharacterBuilder {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    public CharacterBuilder() {
        // Valeurs par défaut
        this.name = "Unknown";
        this.strength = 10;
        this.agility = 10;
        this.intelligence = 10;
    }

    /**
     * Définit le nom du personnage.
     * @param name Le nom du personnage
     * @return Le builder pour chaînage
     */
    public CharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Définit la force du personnage.
     * @param strength La force du personnage
     * @return Le builder pour chaînage
     */
    public CharacterBuilder setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    /**
     * Définit l'agilité du personnage.
     * @param agility L'agilité du personnage
     * @return Le builder pour chaînage
     */
    public CharacterBuilder setAgility(int agility) {
        this.agility = agility;
        return this;
    }

    /**
     * Définit l'intelligence du personnage.
     * @param intelligence L'intelligence du personnage
     * @return Le builder pour chaînage
     */
    public CharacterBuilder setIntelligence(int intelligence) {
        this.intelligence = intelligence;
        return this;
    }

    /**
     * Construit un personnage avec les attributs définis.
     * @return Un nouveau personnage
     * @throws IllegalStateException si le personnage ne respecte pas les règles du jeu
     */
    public Character build() {
        Character character = new Character(name, strength, agility, intelligence);
        
        // Vérification des règles du jeu
        if (!GameSettings.getInstance().isValid(character)) {
            throw new IllegalStateException("Le personnage ne respecte pas les règles du jeu.");
        }
        
        return character;
    }
}