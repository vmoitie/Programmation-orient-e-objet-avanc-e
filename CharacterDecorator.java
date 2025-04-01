package rpg.decorator;

import rpg.core.Character;

/**
 * Classe abstraite de base pour les décorateurs de personnages.
 * Elle permet d'ajouter des capacités spéciales aux personnages.
 */
public abstract class CharacterDecorator extends Character {
    protected Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter) {
        // Appel du constructeur de la classe parente avec les attributs du personnage décoré
        super(decoratedCharacter.getName(), 
              decoratedCharacter.getStrength(), 
              decoratedCharacter.getAgility(), 
              decoratedCharacter.getIntelligence());
        this.decoratedCharacter = decoratedCharacter;
    }

    /**
     * Modifie le niveau de puissance du personnage selon la capacité.
     * @return Le niveau de puissance modifié
     */
    @Override
    public int getPowerLevel() {
        return decoratedCharacter.getPowerLevel();
    }

    /**
     * Modifie la description du personnage pour inclure la capacité.
     * @return La description modifiée
     */
    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription();
    }

    @Override
    public int getStrength() {
        return decoratedCharacter.getStrength();
    }

    @Override
    public int getAgility() {
        return decoratedCharacter.getAgility();
    }

    @Override
    public int getIntelligence() {
        return decoratedCharacter.getIntelligence();
    }

    @Override
    public int getTotalStats() {
        return decoratedCharacter.getTotalStats();
    }
}