package be.ieps.poo.arnaud.model.decorator.accompagnement;

import be.ieps.poo.arnaud.model.decorator.PlatDecorator;
import be.ieps.poo.arnaud.model.plats.Plat;

public class PommeDeTerre extends PlatDecorator {

    private Double prix = 1.00;
    private String type = "pomme de terre";
    private String description = "pomme de terre";

    public PommeDeTerre(Plat platDecore) {
        super(platDecore);
    }

    public String getPreparation() {
        return platDecore.getPreparation() + " " + this.getType() + " " + this.getDescription();
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
        return platDecore.getPrix() + this.prix;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}

