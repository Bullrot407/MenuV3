package be.ieps.poo.arnaud.model.carte;

public class Choix {

    private final String categorie;

    private final String type;

    private final Double prix;

    private final String description;

    public Choix(String categorie, String type, Double prix, String description) {
        this.categorie = categorie;
        this.type = type;
        this.prix = prix;
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }
    public String getType() {
        return type;
    }

    public Double getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }


}