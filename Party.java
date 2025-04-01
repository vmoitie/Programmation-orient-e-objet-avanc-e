package rpg.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Représente une équipe de personnages.
 */
public class Party {
    private String name;
    private List<Character> members;
    
    public Party(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }
    
    /**
     * Ajoute un personnage à l'équipe.
     * @param character Le personnage à ajouter
     * @return true si l'ajout a réussi, false sinon
     */
    public boolean addCharacter(Character character) {
        return members.add(character);
    }
    
    /**
     * Supprime un personnage de l'équipe.
     * @param character Le personnage à supprimer
     * @return true si la suppression a réussi, false sinon
     */
    public boolean removeCharacter(Character character) {
        return members.remove(character);
    }
    
    /**
     * Supprime un personnage de l'équipe par son nom.
     * @param name Le nom du personnage à supprimer
     * @return true si la suppression a réussi, false sinon
     */
    public boolean removeCharacterByName(String name) {
        return members.removeIf(character -> character.getName().equals(name));
    }
    
    /**
     * Calcule la puissance totale de l'équipe.
     * @return La somme des niveaux de puissance de tous les membres
     */
    public int getTotalPowerLevel() {
        return members.stream()
                .mapToInt(Character::getPowerLevel)
                .sum();
    }
    
    /**
     * Trie les personnages par niveau de puissance.
     */
    public void sortByPowerLevel() {
        Collections.sort(members, Comparator.comparingInt(Character::getPowerLevel).reversed());
    }
    
    /**
     * Trie les personnages par nom.
     */
    public void sortByName() {
        Collections.sort(members, Comparator.comparing(Character::getName));
    }
    
    /**
     * Obtient la liste des membres de l'équipe.
     * @return La liste des personnages
     */
    public List<Character> getMembers() {
        return new ArrayList<>(members);
    }
    
    /**
     * Obtient le nombre de membres dans l'équipe.
     * @return Le nombre de personnages
     */
    public int getSize() {
        return members.size();
    }
    
    /**
     * Obtient le nom de l'équipe.
     * @return Le nom
     */
    public String getName() {
        return name;
    }
    
    /**
     * Simule un combat simple entre deux équipes.
     * @param opponent L'équipe adverse
     * @return true si cette équipe gagne, false sinon
     */
    public boolean battle(Party opponent) {
        int thisPower = this.getTotalPowerLevel();
        int opponentPower = opponent.getTotalPowerLevel();
        
        System.out.println("Combat: " + this.name + " (" + thisPower + ") VS " + 
                           opponent.getName() + " (" + opponentPower + ")");
        
        // L'équipe avec le niveau de puissance le plus élevé gagne
        if (thisPower > opponentPower) {
            System.out.println(this.name + " remporte la victoire!");
            return true;
        } else if (thisPower < opponentPower) {
            System.out.println(opponent.getName() + " remporte la victoire!");
            return false;
        } else {
            // En cas d'égalité, on considère que c'est un match nul (pas de gagnant)
            System.out.println("Match nul!");
            return false;
        }
    }
}