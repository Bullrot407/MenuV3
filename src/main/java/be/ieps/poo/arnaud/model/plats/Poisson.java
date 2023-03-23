package be.ieps.poo.arnaud.model.plats;

import java.util.Objects;

public class Poisson implements Plat {
    private int id;
    private Double prix = 2.00;
    private String type = "sole";
    private String description = "meuniere";

    public Poisson(String type) {
        this.type = type;
    }

    public Poisson() {
    }

    public Poisson(Double prix, String type, String description) {
        this.prix = prix;
        this.type = type;
        this.description = description;
    }

    public Poisson(int id, Double prix, String type, String description) {
        this.id = id;
        this.prix = prix;
        this.type = type;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public Double getAddition() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poisson poisson = (Poisson) o;
        return id == poisson.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
