import java.util.Scanner;
import java.util.LinkedList;

/**
 * Classe Menu - Gère l'affichage et les actions
 */
public class Menu {
    
    private Scanner scanner;
    private Employe employeConnecte;
    
    public Menu() {
        this.scanner = new Scanner(System.in);
        this.employeConnecte = null;
    }
    
    // Getters
    public Employe getEmployeConnecte() { return employeConnecte; }
    
    // Affiche le menu
    public void afficher() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Emprunter (CREATE)");
        System.out.println("2. Rendre    (UPDATE)");
        System.out.println("3. Emprunts  (READ)");
        System.out.println("4. Velos     (READ)");
        System.out.println("0. Quitter");
    }
    
    // Lit un choix
    public int lireChoix() {
        System.out.print("Choix : ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
    
    // Lit un texte
    public String lireTexte(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }
    
    // Lit un entier
    public int lireEntier(String msg) {
        System.out.print(msg);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
    
    // Connexion
    public boolean connexion(Employe[] employes) {
        System.out.println("\n=== CONNEXION ===");
        String mat = lireTexte("Matricule : ");
        String mdp = lireTexte("Mot de passe : ");
        
        employeConnecte = Employe.connexion(employes, mat, mdp);
        return employeConnecte != null;
    }
    
    // CREATE : Emprunter un vélo
    public void emprunter(Velo[] velos, LinkedList<Emprunt> emprunts) {
        System.out.println("\n=== EMPRUNTER (CREATE) ===");
        
        Velo.afficherDisponibles(velos);
        String code = lireTexte("Code du velo : ");
        
        Velo velo = Velo.chercher(velos, code);
        if (velo == null) {
            System.out.println("Velo non disponible !");
            return;
        }
        
        Emprunt e = new Emprunt(employeConnecte, velo);
        emprunts.add(e);
        velo.setDisponible(false);
        
        System.out.println("OK : " + e);
    }
    
    // UPDATE : Rendre un vélo
    public void rendre(LinkedList<Emprunt> emprunts) {
        System.out.println("\n=== RENDRE (UPDATE) ===");
        
        Emprunt.afficherEnCours(emprunts);
        int id = lireEntier("ID de l'emprunt : ");
        
        Emprunt e = Emprunt.chercher(emprunts, id);
        if (e == null) {
            System.out.println("Emprunt non trouve !");
            return;
        }
        
        e.terminer();
        e.getVelo().setDisponible(true);
        
        System.out.println("OK : " + e);
    }
    
    // Ferme le scanner
    public void fermer() {
        scanner.close();
    }
}