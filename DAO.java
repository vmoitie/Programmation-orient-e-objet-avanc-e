package rpg.dao;

import java.util.List;

/**
 * Interface générique pour l'accès aux données.
 * @param <T> Le type d'objet géré par le DAO
 */
public interface DAO<T> {
    
    /**
     * Sauvegarde un objet.
     * @param item L'objet à sauvegarder
     * @return true si la sauvegarde a réussi, false sinon
     */
    boolean save(T item);
    
    /**
     * Recherche un objet par son nom.
     * @param name Le nom à rechercher
     * @return L'objet trouvé ou null
     */
    T findByName(String name);
    
    /**
     * Récupère tous les objets.
     * @return Une liste de tous les objets
     */
    List<T> findAll();
}