import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 * Classe Emprunt - Représente un emprunt de vélo
 * 
 * FORMAT DATE/HEURE :
 * - dd = jour, MM = mois (MAJUSCULE), yyyy = année
 * - HH = heure 24h (MAJUSCULE), mm = minutes (minuscule)
 */
public class Emprunt {
    
    private int id;
    private Employe employe;
    private Velo velo;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    
    private static int compteur = 0;
    public static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    //CONSTRUCTEUR
    public Emprunt(Employe employe, Velo velo) {
        this.id = ++compteur;
        this.employe = employe;
        this.velo = velo;
        this.dateDebut = LocalDateTime.now();
        this.dateFin = null;
    }
 

	// Getters
    public int getId() { 
    	return id; 
    }
    
    public Velo getVelo() { 
    	return velo; 
    }
    
    public boolean isEnCours() {
    	return dateFin == null; 
    }
    
    // Terminer l'emprunt (UPDATE)
    public void terminer() {
        this.dateFin = LocalDateTime.now();
    }
    
    public String toString() {
        String debut = dateDebut.format(FORMAT);
        String fin = (dateFin != null) ? dateFin.format(FORMAT) : "---";
        String statut = isEnCours() ? "EN COURS" : "TERMINE";
        return "#" + id + " | " + employe.getNom() + " | " + velo.getCode() + 
               " | " + debut + " | " + fin + " [" + statut + "]";
    }
    
    // Cherche un emprunt en cours par son ID
    public static Emprunt chercher(LinkedList<Emprunt> liste, int id) {
        for (Emprunt e : liste) {
            if (e.getId() == id && e.isEnCours()) {
                return e;
            }
        }
        return null;
    }
    
    // Affiche les emprunts en cours
    public static void afficherEnCours(LinkedList<Emprunt> liste) {
        System.out.println("Emprunts en cours :");
        for (Emprunt e : liste) {
            if (e.isEnCours()) {
                System.out.println("  " + e);
            }
        }
    }
    
    // Affiche tous les emprunts
    public static void afficherTous(LinkedList<Emprunt> liste) {
        System.out.println("\n=== LISTE DES EMPRUNTS ===");
        if (liste.isEmpty()) {
            System.out.println("  Aucun emprunt.");
            return;
        }
        for (Emprunt e : liste) {
            System.out.println("  " + e);
        }
    }
}