package rpg.decorator;

import rpg.core.Character;

/**
 * Décorateur ajoutant la télépathie à un personnage.
 */
public class Telepathy extends CharacterDecorator {

    public Telepathy(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    /**
     * Augmente le niveau de puissance grâce à la télépathie.
     * @return Le niveau de puissance augmenté
     */
    @Override
    public int getPowerLevel() {
        // La télépathie augmente le niveau de puissance de 12 points
        return super.getPowerLevel() + 12;
    }

    /**
     * Ajoute l'information sur la capacité de télépathie à la description.
     * @return La description modifiée
     */
    @Override
    public String getDescription() {
        return super.getDescription() + "\n+ Capacité spéciale: Télépathie (peut lire et communiquer par la pensée)";
    }
}