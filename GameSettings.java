package rpg.settings;

import rpg.core.Character;

/**
 * Singleton contenant les règles globales du jeu.
 */
public class GameSettings {
    private static GameSettings instance;
    
    // Règles du jeu
    private int maxStatPoints;
    
    // Constructeur privé pour empêcher l'instanciation directe
    private GameSettings() {
        this.maxStatPoints = 100; // Valeur par défaut
    }
    
    /**
     * Obtient l'instance unique de GameSettings.
     * @return L'instance unique
     */
    public static synchronized GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }
    
    /**
     * Vérifie si un personnage respecte les règles du jeu.
     * @param character Le personnage à vérifier
     * @return true si le personnage est valide, false sinon
     */
    public boolean isValid(Character character) {
        // Vérifier que la somme des statistiques ne dépasse pas le maximum autorisé
        return character.getTotalStats() <= maxStatPoints;
    }
    
    /**
     * Définit la valeur maximale pour la somme des statistiques.
     * @param maxStatPoints La nouvelle valeur maximale
     */
    public void setMaxStatPoints(int maxStatPoints) {
        this.maxStatPoints = maxStatPoints;
    }
    
    /**
     * Obtient la valeur maximale pour la somme des statistiques.
     * @return La valeur maximale
     */
    public int getMaxStatPoints() {
        return maxStatPoints;
    }
}