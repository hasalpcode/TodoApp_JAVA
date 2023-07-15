import java.util.Scanner;

public class GestionTache {
    private static GestionnaireTaches gestionnaire;
    private static Scanner scanner;

    public static void main(String[] args) {
        gestionnaire = new GestionnaireTaches(1);
        scanner = new Scanner(System.in);

        int choix;
        do {
            afficherMenu();
            choix = lireChoixUtilisateur();

            switch (choix) {
                case 1:
                    ajouterTache();
                    break;
                case 2:
                    modifierTache();
                    break;
                case 3:
                    supprimerTache();
                    break;
                case 4:
                    listerToutesTaches();
                    break;
                case 5:
                    listerTachesEnCours();
                    break;
                case 6:
                    listerTachesTerminees();
                    break;
                case 7:
                    listerTachesPrevues();
                    break;
                case 8:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }

            System.out.println();
        } while (choix != 8);

        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Ajouter une tâche");
        System.out.println("2. Modifier une tâche");
        System.out.println("3. Supprimer une tâche");
        System.out.println("4. Lister toutes les tâches");
        System.out.println("5. Lister les tâches en cours");
        System.out.println("6. Lister les tâches terminées");
        System.out.println("7. Lister les tâches prévues");
        System.out.println("8. Quitter");
        System.out.print("Choix : ");
    }

    private static int lireChoixUtilisateur() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Choix invalide. Veuillez réessayer : ");
        }
        return scanner.nextInt();
    }

    private static void ajouterTache() {
        scanner.nextLine(); // Vider la ligne vide restante après la lecture de l'entier

        System.out.print("Titre de la tâche : ");
        String titre = scanner.nextLine();
         System.out.print("Etat de la tâche : ");
        String etat = scanner.nextLine();
        Tache tache = new Tache(titre,etat);

        if (gestionnaire.ajouter(tache)) {
            
            System.out.println("Tâche ajoutée avec succès !");
        } else {
            System.out.println("Impossible d'ajouter la tâche. Le gestionnaire est plein.");
        }
    }

    private static void modifierTache() {
        scanner.nextLine(); // Vider la ligne vide restante après la lecture de l'entier

        System.out.print("Identifiant de la tâche à modifier : ");
        Integer identifiant = Integer.parseInt(scanner.nextLine()) ;

        System.out.print("Nouveau titre de la tâche : ");
        String nouveauTitre = scanner.nextLine();

        Tache tache = new Tache(nouveauTitre);
        tache.setIdentifiant(identifiant);

        if (gestionnaire.modifier(tache)) {
            System.out.println("Tâche modifiée avec succès !");
        } else {
            System.out.println("Impossible de modifier la tâche. L'identifiant est introuvable.");
        }
    }

    private static void supprimerTache() {
        scanner.nextLine(); // Vider la ligne vide restante après la lecture de l'entier

        System.out.print("Identifiant de la tâche à supprimer : ");
        Integer identifiant = Integer.parseInt(scanner.nextLine()) ;

        if (gestionnaire.supprimer(identifiant)) {
            System.out.println("Tâche supprimée avec succès !");
        } else {
            System.out.println("Impossible de supprimer la tâche. L'identifiant est introuvable.");
        }
    }

    private static void listerToutesTaches() {
        // Tache[] toutesTaches = gestionnaire.lister();

        System.out.println("===== Liste de toutes les tâches =====");
        gestionnaire.lister();
    }

    private static void listerTachesEnCours() {
        // Tache[] tachesEnCours = gestionnaire.listerTachesEnCours();

        System.out.println("===== Liste des tâches en cours =====");
        gestionnaire.listerTachesEnCours();
    }

    private static void listerTachesTerminees() {
  
        System.out.println("===== Liste des tâches terminées =====");
        gestionnaire.listerTachesTerminees();
    }

    private static void listerTachesPrevues() {
        System.out.println("===== Liste des tâches prévues =====");
        gestionnaire.listerTachesPrevues();
    }
}
