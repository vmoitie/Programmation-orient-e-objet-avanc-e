package rpg.main;

import rpg.builder.CharacterBuilder;
import rpg.core.Character;
import rpg.core.Party;
import rpg.dao.CharacterDAO;
import rpg.decorator.FireResistance;
import rpg.decorator.Invisibility;
import rpg.decorator.Telepathy;
import rpg.settings.GameSettings;

/**
 * Classe principale pour démontrer le fonctionnement du système.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Démarrage du générateur de personnages pour jeu de rôle");
        System.out.println("----------------------------------------------------");
        
        // Configuration des règles du jeu
        GameSettings settings = GameSettings.getInstance();
        settings.setMaxStatPoints(100);
        System.out.println("Règles du jeu: Maximum de points de statistiques = " + settings.getMaxStatPoints());
        
        // Création du DAO pour les personnages
        CharacterDAO characterDAO = new CharacterDAO();
        
        try {
            // Création de quelques personnages avec le Builder
            System.out.println("\nCréation des personnages de base:");
            
            Character warrior = new CharacterBuilder()
                .setName("Aragorn")
                .setStrength(40)
                .setAgility(30)
                .setIntelligence(20)
                .build();
            
            Character mage = new CharacterBuilder()
                .setName("Gandalf")
                .setStrength(15)
                .setAgility(25)
                .setIntelligence(50)
                .build();
            
            Character rogue = new CharacterBuilder()
                .setName("Legolas")
                .setStrength(25)
                .setAgility(45)
                .setIntelligence(20)
                .build();
            
            // Sauvegarde des personnages
            characterDAO.save(warrior);
            characterDAO.save(mage);
            characterDAO.save(rogue);
            
            // Affichage des personnages créés
            System.out.println("\nPersonnages créés:");
            System.out.println(warrior.getDescription());
            System.out.println("\n" + mage.getDescription());
            System.out.println("\n" + rogue.getDescription());
            
            // Application de capacités spéciales (Decorator)
            System.out.println("\nApplication des capacités spéciales:");
            
            Character invisibleWarrior = new Invisibility(warrior);
            Character fireResistantMage = new FireResistance(mage);
            Character telepathicRogue = new Telepathy(rogue);
            
            // Affichage des personnages améliorés
            System.out.println("\nPersonnages avec capacités spéciales:");
            System.out.println(invisibleWarrior.getDescription());
            System.out.println("\n" + fireResistantMage.getDescription());
            System.out.println("\n" + telepathicRogue.getDescription());
            
            // Création d'un personnage avec plusieurs capacités
            Character superHero = new CharacterBuilder()
                .setName("SuperHero")
                .setStrength(30)
                .setAgility(30)
                .setIntelligence(30)
                .build();
            
            // Ajout de plusieurs capacités en cascade
            Character ultimateHero = new Telepathy(new FireResistance(new Invisibility(superHero)));
            characterDAO.save(ultimateHero);
            
            System.out.println("\nPersonnage avec multiples capacités:");
            System.out.println(ultimateHero.getDescription());
            
            // Test de récupération depuis le DAO
            System.out.println("\nRécupération des personnages depuis le DAO:");
            Character retrievedMage = characterDAO.findByName("Gandalf");
            if (retrievedMage != null) {
                System.out.println("Personnage trouvé: " + retrievedMage.getName());
                System.out.println(retrievedMage.getDescription());
            }
            
            // Création de parties et test de combat
            System.out.println("\nCréation d'équipes et simulation de combat:");
            
            Party heroes = new Party("Les Héros");
            heroes.addCharacter(invisibleWarrior);
            heroes.addCharacter(fireResistantMage);
            
            Party villains = new Party("Les Vilains");
            villains.addCharacter(telepathicRogue);
            villains.addCharacter(ultimateHero);
            
            // Affichage des équipes
            System.out.println("\nÉquipe " + heroes.getName() + " (Puissance: " + heroes.getTotalPowerLevel() + "):");
            for (Character member : heroes.getMembers()) {
                System.out.println("- " + member.getName() + " (Puissance: " + member.getPowerLevel() + ")");
            }
            
            System.out.println("\nÉquipe " + villains.getName() + " (Puissance: " + villains.getTotalPowerLevel() + "):");
            for (Character member : villains.getMembers()) {
                System.out.println("- " + member.getName() + " (Puissance: " + member.getPowerLevel() + ")");
            }
            
            // Simulation d'un combat
            System.out.println("\nSimulation de combat:");
            heroes.battle(villains);
            
            // Test de tri des personnages
            System.out.println("\nTri des personnages par puissance:");
            heroes.sortByPowerLevel();
            for (Character member : heroes.getMembers()) {
                System.out.println("- " + member.getName() + " (Puissance: " + member.getPowerLevel() + ")");
            }
            
            // Test d'un personnage invalide
            try {
                System.out.println("\nTest de validation des règles du jeu:");
                Character invalidCharacter = new CharacterBuilder()
                    .setName("Trop Puissant")
                    .setStrength(50)
                    .setAgility(50)
                    .setIntelligence(50)
                    .build();
                System.out.println("Personnage créé avec succès (ne devrait pas arriver)");
            } catch (IllegalStateException e) {
                System.out.println("Erreur attendue: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("Une erreur est survenue: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\nFin du programme");
    }
}