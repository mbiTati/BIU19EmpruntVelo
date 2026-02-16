/**
 * Classe Velo - Représente un vélo du parc
 */
public class Velo {
    
    private String code;
    private String type;
    private boolean disponible;
    
    // CONSTRUCTEUR
    public Velo(String code, String type) {
        this.code = code;
        this.type = type;
        this.disponible = true;
    }
    
    // Getters
    public String getCode() { 
    	return code; 
    	}
    
    public String getType() { 
    	return type; 
    	}
    
    public boolean isDisponible() { 
    	return disponible; 
    	}
    
    // Setter
    public void setDisponible(boolean d) { 
    	this.disponible = d; 
    	}
    
    public String toString() {
        String statut = disponible ? "Disponible" : "Emprunte";
        return code + " - " + type + " [" + statut + "]";
    }
    
    // Cherche un vélo disponible par son code
    public static Velo chercher(Velo[] tab, String code) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].getCode().equals(code) && tab[i].isDisponible()) {
                return tab[i];
            }
        }
        return null;
    }
    
    // Affiche les vélos disponibles
    public static void afficherDisponibles(Velo[] tab) {
        System.out.println("Velos disponibles :");
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].isDisponible()) {
                System.out.println("  " + tab[i]);
            }
        }
    }
    
    // Affiche tous les vélos
    public static void afficherTous(Velo[] tab) {
        System.out.println("\n=== LISTE DES VELOS ===");
        for (int i = 0; i < tab.length; i++) {
            System.out.println("  " + tab[i]);
        }
    }
}