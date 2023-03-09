package be.ieps.poo.arnaud;

import be.ieps.poo.arnaud.model.carte.Choix;
import be.ieps.poo.arnaud.model.carte.loader.XMLLoader;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCarte {
    private XMLLoader loader = new XMLLoader();
    private Element racine =
            new Element("carte")
                    .addContent(
                            new Element("plats")
                                    .addContent(
                                            new Element("plat")
                                                    .addContent(new Element("categorie").setText("poisson"))
                                                    .addContent(new Element("type").setText("sole"))
                                                    .addContent(new Element("prix").setText("15.00"))
                                                    .addContent(new Element("description").setText("au feu de bois"))
                                    )
                                    .addContent(
                                            new Element("plat")
                                                    .addContent(new Element("categorie").setText("viande"))
                                                    .addContent(new Element("type").setText("boeuf"))
                                                    .addContent(new Element("prix").setText("15.00"))
                                                    .addContent(new Element("description").setText("au grill"))
                                    )
                                    .addContent(
                                            new Element("plat")
                                                    .addContent(new Element("categorie").setText("volaille"))
                                                    .addContent(new Element("type").setText("dinde"))
                                                    .addContent(new Element("prix").setText("15.00"))
                                                    .addContent(new Element("description").setText("de Noel farcie"))
                                    )
                    )
                    .addContent(
                            new Element("accompagnements")
                                    .addContent(
                                            new Element("accompagnement")
                                                    .addContent(new Element("categorie").setText("pates"))
                                                    .addContent(new Element("type").setText("spaghetti"))
                                                    .addContent(new Element("prix").setText("5.00"))
                                                    .addContent(new Element("description").setText("aldente"))
                                    )
                                    .addContent(
                                            new Element("accompagnement")
                                                    .addContent(new Element("categorie").setText("riz"))
                                                    .addContent(new Element("type").setText("basmati"))
                                                    .addContent(new Element("prix").setText("5.00"))
                                                    .addContent(new Element("description").setText("à la japonaise"))
                                    )
                                    .addContent(
                                            new Element("accompagnement")
                                                    .addContent(new Element("categorie").setText("pommes de terre"))
                                                    .addContent(new Element("type").setText("Nicolas"))
                                                    .addContent(new Element("prix").setText("5.00"))
                                                    .addContent(new Element("description").setText("en chemise au four"))
                                    )
                                    .addContent(
                                            new Element("accompagnement")
                                                    .addContent(new Element("categorie").setText("frites"))
                                                    .addContent(new Element("type").setText("large"))
                                                    .addContent(new Element("prix").setText("5.00"))
                                                    .addContent(new Element("description").setText("faites maison"))
                                    )
                    )
                    .addContent(
                            new Element("desserts")
                                    .addContent(
                                            new Element("dessert")
                                                    .addContent(new Element("categorie").setText("cafe"))
                                                    .addContent(new Element("type").setText("latte"))
                                                    .addContent(new Element("prix").setText("5.00"))
                                                    .addContent(new Element("description").setText("avec des gourmandises"))
                                    )
                                    .addContent(
                                            new Element("dessert")
                                                    .addContent(new Element("categorie").setText("fruit"))
                                                    .addContent(new Element("type").setText("pomme"))
                                                    .addContent(new Element("prix").setText("5.00"))
                                                    .addContent(new Element("description").setText("pomme sucrée"))
                                    )
                                    .addContent(
                                            new Element("dessert")
                                                    .addContent(new Element("categorie").setText("glace"))
                                                    .addContent(new Element("type").setText("vanille"))
                                                    .addContent(new Element("prix").setText("5.00"))
                                                    .addContent(new Element("description").setText("enrobé de chocolat"))
                                    )
                                    .addContent(
                                            new Element("dessert")
                                                    .addContent(new Element("categorie").setText("patisserie"))
                                                    .addContent(new Element("type").setText("eclair"))
                                                    .addContent(new Element("prix").setText("5.00"))
                                                    .addContent(new Element("description").setText("eclair fondant chocolat"))
                                    )
                    );

    @Test
    public void testLoadingXML() throws IOException, JDOMException, URISyntaxException {
        Element result = loader.loadResourceToXml("carteTest.xml");
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getCompactFormat());
        String myElementString = xmlOutputter.outputString(racine);
        String testElementString = xmlOutputter.outputString(result).replace("&gt;", "");
        assertEquals(result.getName(), racine.getName());
        assertEquals( racine.getChild("plats").getChildren().size(),result.getChild("plats").getChildren().size());
        assertEquals(myElementString, testElementString);
    }

    @Test
    public void testLoadingPlats() {

        ArrayList<Choix> listePlats = loader.recuperationPlats(racine);
        assertEquals(3, listePlats.size());

        Choix platTest = listePlats.get(1);
        assertEquals("viande", platTest.getCategorie());
        assertEquals("boeuf", platTest.getType());
        assertEquals(15.0, platTest.getPrix());
        assertEquals("au grill", platTest.getDescription());
    }

    @Test
    public void testLoadingAccompagnements() {

        ArrayList<Choix> listeAccompagnements = loader.recuperationAccompagnements(racine);
        assertEquals(4, listeAccompagnements.size());

        Choix platTest = listeAccompagnements.get(1);
        assertEquals("riz", platTest.getCategorie());
        assertEquals("basmati", platTest.getType());
        assertEquals(5.0, platTest.getPrix());
        assertEquals("à la japonaise", platTest.getDescription());
    }

    @Test
    public void testLoadingDesserts() {

        ArrayList<Choix> listeDesserts = loader.recuperationDesserts(racine);
        assertEquals(4, listeDesserts.size());

        Choix platTest = listeDesserts.get(1);
        assertEquals("fruit", platTest.getCategorie());
        assertEquals("pomme", platTest.getType());
        assertEquals(5.0, platTest.getPrix());
        assertEquals("pomme sucrée", platTest.getDescription());
    }
}

