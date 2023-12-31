import java.util.Date;

public class Tache {
    private Integer identifiant;
    private static Integer dernierId = 1;
    private String titre;
    private String etat;
    private Date dateCreation;

    public Tache(String titre) {
        this.titre = titre;
        this.identifiant = dernierId;
        this.etat = "PREVU";
        this.dateCreation = new Date();
        dernierId++; 
    }

    public Tache(String titre, String etat) {
        this.titre = titre;
        this.identifiant = dernierId;
        this.etat = etat;
        this.dateCreation = new Date();
        dernierId++; 
    }

    public Tache(String titre, String etat, Date dateCreation) {
        this.titre = titre;
        this.identifiant = dernierId;
        this.etat = etat;
        this.dateCreation = dateCreation;
        dernierId++; 
    }

    // Getters et Setters

    public Integer getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Integer identifiant) {
        this.identifiant = identifiant;
    }

    public static Integer getDernierId() {
        return dernierId;
    }

    public static void setDernierId(Integer dernierId) {
        Tache.dernierId = dernierId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Tache [identifiant=" + identifiant + ", titre=" + titre + ", etat=" + etat + ", dateCreation="
                + dateCreation + "]";
    }
}
