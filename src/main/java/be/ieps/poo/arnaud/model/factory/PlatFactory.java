package be.ieps.poo.arnaud.model.factory;

import be.ieps.poo.arnaud.model.decorator.PlatDecorator;
import be.ieps.poo.arnaud.model.decorator.accompagnement.Frites;
import be.ieps.poo.arnaud.model.decorator.accompagnement.Pates;
import be.ieps.poo.arnaud.model.decorator.accompagnement.PommeDeTerre;
import be.ieps.poo.arnaud.model.decorator.accompagnement.Riz;
import be.ieps.poo.arnaud.model.decorator.dessert.Cafe;
import be.ieps.poo.arnaud.model.decorator.dessert.Fruit;
import be.ieps.poo.arnaud.model.decorator.dessert.Glace;
import be.ieps.poo.arnaud.model.decorator.dessert.Patisserie;
import be.ieps.poo.arnaud.model.plats.Plat;
import be.ieps.poo.arnaud.model.plats.Poisson;
import be.ieps.poo.arnaud.model.plats.Viande;
import be.ieps.poo.arnaud.model.plats.Volaille;


public class PlatFactory {

    public static Plat getPlat(String categorie) {
        return switch (categorie) {
            case "poisson" -> new Poisson();
            case "viande" -> new Viande();
            case "volaille" -> new Volaille();
            default -> null;
        };
    }

    public static PlatDecorator getPlatDecorator(String categorie, Plat plat) {
        return switch (categorie) {
            case "frites" -> new Frites(plat);
            case "pates" -> new Pates(plat);
            case "pommes de terre" -> new PommeDeTerre(plat);
            case "riz"-> new Riz(plat);
            case "cafe" -> new Cafe(plat);
            case "fruit" -> new Fruit(plat);
            case "glace" -> new Glace(plat);
            case "patisserie" -> new Patisserie(plat);
            default -> null;
        };
    }
}

