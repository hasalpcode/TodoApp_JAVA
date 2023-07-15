

/**
 * GestionnaireTaches
 */
public class GestionnaireTaches {

    private Tache taches[];
    private int nombreTache ;


    public GestionnaireTaches(int nombreMax) {
        this.nombreTache = 0;
        taches = new Tache[nombreMax];
      
    }

    // System.out.println('yes')
    Boolean ajouter(Tache tache){
        // this.nombreTache = this.taches.length;
        if (this.nombreTache < taches.length) {
            taches[nombreTache] = tache;
            nombreTache++;
            return true;
        }else{
            // System.out.println("Le tableau de tâches est plein. Impossible d'ajouter une nouvelle tache.");
            return false;

        }
    }

    // modifier
    Boolean modifier(Tache tache){
        for (int i = 0; i < nombreTache; i++) {
            if (taches[i].getIdentifiant().equals(tache.getIdentifiant())) {
                taches[i].setTitre(tache.getTitre());
                taches[i].setEtat(tache.getEtat());
                taches[i].setDateCreation(tache.getDateCreation());
                return true;
            }
        }
        return false;
    }

    // supprimer
    Boolean supprimer(int id){
        for (int i = 0; i < nombreTache; i++) {
            if (taches[i].getIdentifiant().equals(id)) {
                for (int j = i; j < nombreTache - 1; j++) {
                    taches[j] = taches[j + 1];
                }
                taches[nombreTache - 1] = null; // enlever reference
                nombreTache--; 
                return true;
            }
        }
        return false;
    }

    // lister les taches
    void lister(){
        if (taches.length != 0) {
            for (Tache tache : taches) {
                System.out.println(tache);
            }
        }else{
            System.out.println("Aucune tache!");
        }

    }

     // lister les taches en cours
    void listerTachesEnCours(){
        if (taches.length != 0) {
            for (Tache tache : taches) {
                if (tache != null) {
                    if (tache.getEtat().equals("EN_COURS")) {
                    System.out.println(tache); 
                    }
                }
            }
        }else{
            System.out.println("Aucune tache!");
        }
    
    }

     // lister les taches TERMINEES
    void listerTachesTerminees(){
        if (taches.length != 0) {

            for (Tache tache : taches) {
                if (tache != null) {
                    if (tache.getEtat().equals("TERMINE")) {
                    System.out.println(tache); 
                    }
                }
            }
        }else{
            System.out.println("Aucune tache!");
        }
    }

    // lister les taches prevu
    void listerTachesPrevues(){
        if (taches.length != 0) {
            for (Tache tache : taches) {
                if (tache != null) {
                    if (tache.getEtat().equals("PREVU")) {
                    System.out.println(tache); 
                    }
                }

            }
        }else{
            System.out.println("Aucune tache!");
        }
    }
}