package rpg.decorator;

import rpg.core.Character;

/**
 * Décorateur ajoutant la résistance au feu à un personnage.
 */
public class FireResistance extends CharacterDecorator {

    public FireResistance(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    /**
     * Augmente le niveau de puissance grâce à la résistance au feu.
     * @return Le niveau de puissance augmenté
     */
    @Override
    public int getPowerLevel() {
        // La résistance au feu augmente le niveau de puissance de 10 points
        return super.getPowerLevel() + 10;
    }

    /**
     * Ajoute l'information sur la capacité de résistance au feu à la description.
     * @return La description modifiée
     */
    @Override
    public String getDescription() {
        return super.getDescription() + "\n+ Capacité spéciale: Résistance au feu (immunité aux dégâts de feu)";
    }
}