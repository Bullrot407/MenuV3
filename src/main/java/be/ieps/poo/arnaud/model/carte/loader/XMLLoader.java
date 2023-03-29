/*
package be.ieps.poo.arnaud.model.carte.loader;

import be.ieps.poo.arnaud.model.carte.Carte;
import be.ieps.poo.arnaud.model.carte.Choix;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLLoader implements Loader {

    @Override
    public Carte load(File file) throws LoadingException {

        try {
            return recuperationCarte(loadFileToXML(file));
        } catch (IOException | JDOMException | NullPointerException e) {
            throw new LoadingException(e);
        }
    }

    public Element loadFileToXML(File file) throws IOException, JDOMException {
        SAXBuilder saxBuilder = new SAXBuilder();

        return saxBuilder.build(file).getRootElement();
    }

    public Carte recuperationCarte(Element racine) {
        return new Carte(recuperationPlats(racine), recuperationAccompagnements(racine), recuperationDesserts(racine));
    }

    public ArrayList<Choix> recuperationPlats(Element racine) {
        ArrayList<Choix> choix = new ArrayList<>();

        List<Element> listePlat = racine.getChild("plats").getChildren("plat");

        for (Element plat : listePlat) {
            String categorie = plat.getChild("categorie").getText();
            String type = plat.getChild("type").getText();
            Double prix = Double.valueOf(plat.getChild("prix").getText());
            String description = plat.getChild("description").getText();
            Choix obj = new Choix(categorie, type, prix, description);
            choix.add(obj);
        }

        return choix;
    }
    public ArrayList<Choix> recuperationAccompagnements(Element racine) {
        ArrayList<Choix> choix = new ArrayList<>();

        List<Element> listeAccompagnement = racine.getChild("accompagnements").getChildren("accompagnement");

        for (Element accompagnement : listeAccompagnement) {
            String categorie = accompagnement.getChild("categorie").getText();
            String type = accompagnement.getChild("type").getText();
            Double prix = Double.valueOf(accompagnement.getChild("prix").getText());
            String description = accompagnement.getChild("description").getText();
            Choix obj = new Choix(categorie, type, prix, description);
            choix.add(obj);
        }

        return choix;
    }
    public ArrayList<Choix> recuperationDesserts(Element racine) {
        ArrayList<Choix> choix = new ArrayList();


        List<Element> listeDessert = racine.getChild("desserts").getChildren("dessert");

        for (Element dessert : listeDessert) {
            String categorie = dessert.getChild("categorie").getText();
            String type = dessert.getChild("type").getText();
            Double prix = Double.valueOf(dessert.getChild("prix").getText());
            String description = dessert.getChild("description").getText();
            Choix obj = new Choix(categorie, type, prix, description);
            choix.add(obj);
        }

        return choix;
    }
}

*/
package be.ieps.poo.arnaud.model.carte.loader;

import be.ieps.poo.arnaud.model.carte.Carte;
import be.ieps.poo.arnaud.model.carte.Choix;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class XMLLoader implements Loader {

    // permet de charger tout les types de fichier
    @Override
    public Carte load(File file) throws LoadingException {
        try {
            return recuperationCarte(loadFileToXML(file));
        } catch (IOException | JDOMException | NullPointerException e) {
            throw new LoadingException(e);
        }
    }
    @Override
    public Carte loadResource(String resourceName) throws LoadingException {
        try {
            return recuperationCarte(loadResourceToXml(resourceName));
        } catch (IOException | URISyntaxException | JDOMException e) {
            throw new LoadingException(e);
        }
    }
//charge le fichier depuis la ressource pour etre dans le JAR
    public Element loadResourceToXml(String resourceName) throws IOException, URISyntaxException, JDOMException {
        URL url = ClassLoader.getSystemResource(resourceName);
        File file = new File(url.toURI());

        return loadFileToXML(file);
    }
// permet de charger un fichier xml dans une ressource
    public Element loadFileToXML(File file) throws IOException, JDOMException {
        SAXBuilder saxBuilder = new SAXBuilder();

        return saxBuilder.build(file).getRootElement();
    }

    public Carte recuperationCarte(Element racine) {
        return new Carte(recuperationPlats(racine), recuperationAccompagnements(racine), recuperationDesserts(racine));
    }

    public ArrayList<Choix> recuperationPlats(Element racine) {
        ArrayList<Choix> choix = new ArrayList<>();

        List<Element> listePlat = racine.getChild("plats").getChildren("plat");

        for (Element plat : listePlat) {
            String categorie = plat.getChild("categorie").getText();
            String type = plat.getChild("type").getText();
            Double prix = Double.valueOf(plat.getChild("prix").getText());
            String description = plat.getChild("description").getText();
            Choix obj = new Choix(categorie, type, prix, description);
            choix.add(obj);
        }

        return choix;
    }

    public ArrayList<Choix> recuperationAccompagnements(Element racine) {
        ArrayList<Choix> choix = new ArrayList<>();

        List<Element> listeAccompagnement = racine.getChild("accompagnements").getChildren("accompagnement");

        for (Element accompagnement : listeAccompagnement) {
            String categorie = accompagnement.getChild("categorie").getText();
            String type = accompagnement.getChild("type").getText();
            Double prix = Double.valueOf(accompagnement.getChild("prix").getText());
            String description = accompagnement.getChild("description").getText();
            Choix obj = new Choix(categorie, type, prix, description);
            choix.add(obj);
        }

        return choix;
    }

    public ArrayList<Choix> recuperationDesserts(Element racine) {
        ArrayList<Choix> choix = new ArrayList();


        List<Element> listeDessert = racine.getChild("desserts").getChildren("dessert");

        for (Element dessert : listeDessert) {
            String categorie = dessert.getChild("categorie").getText();
            String type = dessert.getChild("type").getText();
            Double prix = Double.valueOf(dessert.getChild("prix").getText());
            String description = dessert.getChild("description").getText();
            Choix obj = new Choix(categorie, type, prix, description);
            choix.add(obj);
        }

        return choix;
    }
}
