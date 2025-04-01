package rpg.core;

/**
 * Classe de base représentant un personnage dans le jeu de rôle.
 */
public class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    // Constructeur protégé pour être utilisé par le Builder
    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    /**
     * Calcule le niveau de puissance du personnage.
     * @return Le niveau de puissance basé sur les caractéristiques
     */
    public int getPowerLevel() {
        return strength * 2 + agility + intelligence * 2;
    }

    /**
     * Retourne une description textuelle du personnage.
     * @return La description du personnage
     */
    public String getDescription() {
        return "Personnage: " + name + 
               "\nForce: " + strength + 
               "\nAgilité: " + agility + 
               "\nIntelligence: " + intelligence + 
               "\nNiveau de puissance: " + getPowerLevel();
    }

    // Getters et Setters
    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getTotalStats() {
        return strength + agility + intelligence;
    }
}