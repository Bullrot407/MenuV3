package be.ieps.poo.arnaud;

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


import be.ieps.poo.arnaud.model.factory.PlatFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlat {
    private PlatFactory factory = new PlatFactory();

    @Test
    void testPlatSansDecorateur() {

        Plat plat = factory.getPlat("viande");

        assertAll("viande",
                () -> assertEquals("boeuf", plat.getType()),
                () -> assertEquals(3.00, plat.getPrix()),
                () -> assertEquals("boeuf blanc bleu", plat.getPreparation())
        );
    }

    @Test
    void testPlatAvecDecorateurFrites() {
        Plat plat = factory.getPlat("viande");
        //final Plat avecFrites = new Frites(plat);
        Plat avecFrites = factory.getPlatDecorator("frites", plat);
        assertAll("viande",
                () -> assertEquals(avecFrites.getPrix(), 5.00),
                () -> assertEquals("boeuf blanc bleu Frites maison", avecFrites.getPreparation()));
    }

    @Test
    void testPlatAvecDecorateurFritesCafe() {

        Plat plat = factory.getPlat("viande");

        final Plat avecFritesEtCafe = factory.getPlatDecorator("cafe", factory.getPlatDecorator("frites", plat));

        assertAll("viande",
                () -> assertEquals("boeuf blanc bleu Frites maison Café latte", avecFritesEtCafe.getPreparation()),
                () -> assertEquals(9.0, avecFritesEtCafe.getPrix()));
    }

    @Test
    void testPlatAvecDecorateurPommeDeTerreEtFruit() {
        Plat plat = factory.getPlat("poisson");
        final Plat avecPommeDeTerresEtFruit = factory.getPlatDecorator("fruit", factory.getPlatDecorator("pommes de terre", plat));


        assertAll("poisson",
                () -> assertEquals("sole meuniere pomme de terre pomme de terre pomme coupe de fruit", avecPommeDeTerresEtFruit.getPreparation()),
                () -> assertEquals(7.0, avecPommeDeTerresEtFruit.getPrix()));
    }

    @Test
    void testPlatAvecDecorateurPatesEtGlace() {
        Plat plat = factory.getPlat("volaille");
        final Plat avecPatesEtGlace = factory.getPlatDecorator("glace", factory.getPlatDecorator("pates", plat));


        assertAll("volaille",
                () -> assertEquals("poulet en cuisse spaghetti aldente vanille couverte de chocolat", avecPatesEtGlace.getPreparation()),
                () -> assertEquals(25, avecPatesEtGlace.getPrix()));
    }

    @Test
    void testPlatAvecDecorateurRizEtPatisserie() {
        Plat plat = factory.getPlat("poisson");
        final Plat avecRizEtPatisserie = factory.getPlatDecorator("riz", factory.getPlatDecorator("patisserie", plat));

        assertAll("poisson",
                () -> assertEquals("sole meuniere eclaire avec des gourmandises basmati cuit vapeur", avecRizEtPatisserie.getPreparation()),
                () -> assertEquals(8.50, avecRizEtPatisserie.getPrix()));
    }


    @Test
    void testPlatAvecDecorateurRizCafe() {
        Plat plat = factory.getPlat("poisson");
        final Plat avecRizEtCafe = factory.getPlatDecorator("riz", factory.getPlatDecorator("cafe", plat));


        assertAll("poisson",
                () -> assertEquals("sole meuniere Café latte basmati cuit vapeur", avecRizEtCafe.getPreparation()),
                () -> assertEquals(10, avecRizEtCafe.getPrix()));
    }
}

