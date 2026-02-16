import java.util.LinkedList;

/**
 * Programme principal - Gestion des emprunts de vélos
 * 
 * STRUCTURE : LinkedList<Emprunt>
 */
public class Main {
    
    public static void main(String[] args) {
        
        // Données
        Velo[] velos = {
            new Velo("V001", "VTT"),
            new Velo("V002", "Ville"),
            new Velo("V003", "Electrique"),
            new Velo("V004", "Pliant")
        };
        
        Employe[] employes = {
            new Employe("E001", "Dupont", "1234"),
            new Employe("E002", "Martin", "1234"),
            new Employe("E003", "Bernard", "1234"),
            new Employe("E004", "Petit", "1234")
        };
        
        LinkedList<Emprunt> emprunts = new LinkedList<Emprunt>();
        
        // Menu
        Menu menu = new Menu();
        
        // Connexion
        if (!menu.connexion(employes)) {
            System.out.println("Echec connexion !");
            return;
        }
        System.out.println("Bienvenue " + menu.getEmployeConnecte().getNom() + " !");
        
        // Boucle menu
        int choix;
        do {
            menu.afficher();
            choix = menu.lireChoix();
            
            switch (choix) {
                case 1: 
                	menu.emprunter(velos, emprunts); 
                break;
                case 2: 
                	menu.rendre(emprunts); 
                break;
                case 3: 
                	Emprunt.afficherTous(emprunts); 
                break;
                case 4: 
                	Velo.afficherTous(velos); 
                break;
                
                case 0: System.out.println("Au revoir !"); break;
                default: System.out.println("Choix invalide");
            }
        } while (choix != 0);
        
        menu.fermer();
    }
}