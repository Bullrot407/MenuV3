package be.ieps.poo.arnaud.model.plats;

public class Viande implements Plat {
    private int id;
    private Double prix = 3.00;
    private String type = "boeuf";
    private String description = "blanc bleu";

    public Viande(String type) {
        this.type = type;
    }

    public Viande() {
    }

    public String getPreparation() {
        return getType() + " " + getDescription();
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Double getPrix() {
        return prix;
    }

    @Override
    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
