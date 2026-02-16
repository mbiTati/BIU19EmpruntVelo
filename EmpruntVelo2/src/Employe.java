/**
 * Classe Employe - Représente un employé
 */
public class Employe {
    
    private String matricule;
    private String nom;
    private String motDePasse;
    
    public Employe(String matricule, String nom, String motDePasse) {
        this.matricule = matricule;
        this.nom = nom;
        this.motDePasse = motDePasse;
    }
    
    // Getters
    public String getMatricule() { 
    	return matricule; 
    	}
    
    public String getNom() { 
    	return nom; 
    	}
    
    public String toString() {
        return matricule + " - " + nom;
    }
    
    // Cherche un employé par matricule et mot de passe
    public static Employe connexion(Employe[] tab, String matricule, String mdp) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].matricule.equals(matricule) && tab[i].motDePasse.equals(mdp)) {
                return tab[i];
            }
        }
        return null;
    }
}