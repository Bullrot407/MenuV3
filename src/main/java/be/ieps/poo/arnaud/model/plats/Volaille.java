package be.ieps.poo.arnaud.model.plats;

public class Volaille implements Plat {
    private int id;
    private Double prix = 15.00;
    private String type = "poulet";
    private String description = "en cuisse";

    public Volaille(String type) {
        this.type = type;
    }

    public Volaille() {
    }

    public String getPreparation() {
        return getType() + " " + getDescription() + " " + getPrix() +"\n";
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
    public Double getAddition() {
        return null;
    }
}
