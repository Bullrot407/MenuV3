package be.ieps.poo.arnaud.model.decorator.dessert;

import be.ieps.poo.arnaud.model.decorator.PlatDecorator;
import be.ieps.poo.arnaud.model.plats.Plat;

public class Patisserie extends PlatDecorator {

    private Double prix = 2.50;
    private String type = "eclaire";
    private String description = "avec des gourmandises";

    public Patisserie(Plat platDecore) {
        super(platDecore);
    }


    public String getPreparation() {
        return platDecore.getPreparation() + " " + this.getType() + " " + this.getDescription() + " " + getPrix() + "\n";
    }

    @Override
    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Double getPrix() {
        return this.prix;
    }
    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public Double getAddition() {
        return platDecore.getAddition() + this.prix;
    }
}

