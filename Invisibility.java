package rpg.decorator;

import rpg.core.Character;

/**
 * Décorateur ajoutant la capacité d'invisibilité à un personnage.
 */
public class Invisibility extends CharacterDecorator {

    public Invisibility(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    /**
     * Augmente le niveau de puissance grâce à l'invisibilité.
     * @return Le niveau de puissance augmenté
     */
    @Override
    public int getPowerLevel() {
        // L'invisibilité augmente le niveau de puissance de 15 points
        return super.getPowerLevel() + 15;
    }

    /**
     * Ajoute l'information sur la capacité d'invisibilité à la description.
     * @return La description modifiée
     */
    @Override
    public String getDescription() {
        return super.getDescription() + "\n+ Capacité spéciale: Invisibilité (peut disparaître temporairement)";
    }
}