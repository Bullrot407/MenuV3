package be.ieps.poo.arnaud;

import be.ieps.poo.arnaud.model.carte.Commande;
import be.ieps.poo.arnaud.model.factory.PlatFactory;
import be.ieps.poo.arnaud.model.plats.Plat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMenu {
    private PlatFactory factory = new PlatFactory();
    int nbMenuTable1, nbMenuTable2;
    Plat menu;
    private Commande commande = new Commande();

    @Test
    void testAucunMenu() {
        nbMenuTable1 = commande.getCommandes("Table 1").size();
        nbMenuTable2 = commande.getCommandes("Table 2").size();

        assertEquals(0, nbMenuTable1 + nbMenuTable2);
    }

    @Test
    void testUnMenu() {
        menu = factory.getPlat("viande");
        menu = factory.getPlatDecorator("riz", factory.getPlatDecorator("patisserie", menu));

        commande.ajoutMenuCommande("Table 1", menu);

        nbMenuTable1 = commande.getCommandes("Table 1").size();
        nbMenuTable2 = commande.getCommandes("Table 2").size();
        assertEquals(1, nbMenuTable1 + nbMenuTable2);
        assertEquals(1, nbMenuTable1);
        assertEquals(0, nbMenuTable2);
    }

    @Test
    void testUnMenuParTable() {
        menu = factory.getPlat("viande");
        menu = factory.getPlatDecorator("riz", factory.getPlatDecorator("cafe", menu));

        commande.ajoutMenuCommande("Table 1", menu);

        menu = factory.getPlat("poisson");
        menu = factory.getPlatDecorator("riz", factory.getPlatDecorator("patisserie", menu));
        commande.ajoutMenuCommande("Table 2", menu);
        nbMenuTable1 = commande.getCommandes("Table 1").size();
        nbMenuTable2 = commande.getCommandes("Table 2").size();
        assertEquals(1, nbMenuTable1);
        assertEquals(1, nbMenuTable2);
    }
    @Test
    void testUnMenuTable1DeuxMenuTable2() {
        menu = factory.getPlat("viande");
        menu = factory.getPlatDecorator("fruit", factory.getPlatDecorator("patisserie", menu));

        commande.ajoutMenuCommande("Table 1", menu);

        menu = factory.getPlat("poisson");
        menu = factory.getPlatDecorator("riz", factory.getPlatDecorator("cafe", menu));
        commande.ajoutMenuCommande("Table 2", menu);

        menu = factory.getPlat("poisson");
        menu = factory.getPlatDecorator("fruit", factory.getPlatDecorator("pommes de terre", menu));
        commande.ajoutMenuCommande("Table 2", menu);

        nbMenuTable1 = commande.getCommandes("Table 1").size();
        nbMenuTable2 = commande.getCommandes("Table 2").size();

        assertEquals(3, nbMenuTable1 + nbMenuTable2);
        assertEquals(1, nbMenuTable1);
        assertEquals(2, nbMenuTable2);
    }

    @Test
    void testFonctionNombreCommandeTotal() {
        menu = factory.getPlat("viande");
        menu = factory.getPlatDecorator("glace", factory.getPlatDecorator("pates", menu));

        commande.ajoutMenuCommande("Table 1", menu);

        menu = factory.getPlat("poisson");
        menu = factory.getPlatDecorator("fruit", factory.getPlatDecorator("pommes de terre", menu));
        commande.ajoutMenuCommande("Table 2", menu);

        menu = factory.getPlat("poisson");

        menu = factory.getPlatDecorator("cafe", factory.getPlatDecorator("frites", menu));
        commande.ajoutMenuCommande("Table 2", menu);

        assertEquals(3,commande.nombreMenuCommande());
        assertEquals(13,commande.prixTotalCommande("Table 1"));
        assertEquals(15,commande.prixTotalCommande("Table 2"));
    }
    @Test
    void testFonctionPrixCommandeTotalTable() {
        menu = factory.getPlat("viande");
        menu = factory.getPlatDecorator("riz", factory.getPlatDecorator("patisserie", menu));

        commande.ajoutMenuCommande("Table 1", menu);

        menu = factory.getPlat("poisson");
        menu = factory.getPlatDecorator("riz", factory.getPlatDecorator("cafe", menu));
        commande.ajoutMenuCommande("Table 2", menu);

        menu = factory.getPlat("volaille");
        menu = factory.getPlatDecorator("glace", factory.getPlatDecorator("pates", menu));
        commande.ajoutMenuCommande("Table 2", menu);

        assertEquals(9.5,commande.prixTotalCommande("Table 1"));
        assertEquals(35,commande.prixTotalCommande("Table 2"));
    }
}
