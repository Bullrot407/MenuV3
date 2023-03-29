package be.ieps.poo.arnaud.controller;

import be.ieps.poo.arnaud.model.carte.Carte;
import be.ieps.poo.arnaud.model.carte.loader.LoadingException;
import be.ieps.poo.arnaud.model.carte.loader.XMLLoader;
import be.ieps.poo.arnaud.model.Commande;
import be.ieps.poo.arnaud.dao.CommandeDAO;
import be.ieps.poo.arnaud.model.factory.PlatFactory;
import be.ieps.poo.arnaud.model.plats.Plat;
import be.ieps.poo.arnaud.view.FenetrePrincipale;
import be.ieps.poo.arnaud.view.tableauCommande.TableModele;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;


public class MenuController {
    private Carte carte;
    private XMLLoader xmlLoader = new XMLLoader();
    private CommandeAction commandeAction = new CommandeAction();
    private Plat plat;
    private String prixTotal, menuCommandeTotal, menu, table;

    private CommandeDAO commandeDAO = CommandeDAO.getInstance();

    public void setTable(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    private static volatile MenuController menuController = null;

    public static MenuController getInstance() {
        if (menuController == null) {
            menuController = new MenuController();
        }
        return menuController;
    }

    private MenuController() {
        try {
            this.carte = xmlLoader.loadResource("carte.xml");

        } catch (LoadingException loadingException) {
            System.out.println(loadingException.getMessage());
        }
    }

    public Carte getCarte() {
        return carte;
    }

    public void startFenetrePrincipale() {
        FenetrePrincipale fenetrePrincipale = new FenetrePrincipale();
        fenetrePrincipale.setVisible(true);
    }

    public CommandeAction getCommandeAction() {
        return commandeAction;
    }

    public void setCommandeAction(CommandeAction commandeAction) {
        this.commandeAction = commandeAction;
    }

    public void creerPlat(String categorie, String type, String description, Double prix) {
        plat = PlatFactory.getPlat(categorie);
        plat.setType(type);
        plat.setDescription(description);
        plat.setPrix(prix);
    }

    public void decorePlat(String categorie, String type, String description, Double prix) {
        plat = PlatFactory.getPlatDecorator(categorie, plat);
        plat.setType(type);
        plat.setDescription(description);
        plat.setPrix(prix);
        System.out.println(prix);
    }

    public void ajoutMenuCommande() {
        commandeAction.ajoutMenuCommande(table, plat);

    }

    public String afficheCommande(String table) {
        menu = "Commande:\n" +
                "Plat: " + plat.getPreparation() + "\n" +
                // "Description: " + plat.getDescription()+ "\n" +
                " Prix: " + plat.getAddition() + "\n";

        return menu;//plat.getPreparation() + plat.getPrix().toString();
    }

    public String prixTotalCommandeTable(String table) {
        prixTotal = "Prix total: " + commandeAction.prixTotalCommande(table);

        return prixTotal;
    }

    public String afficheCommandeTable(String table) {
        menuCommandeTotal = commandeAction.afficheCommandeTable(table);
        commandeDAO.insertData(new Commande(table, menuCommandeTotal, commandeAction.prixTotalCommande(getTable())));
        return menuCommandeTotal;
    }

    public List<Commande> getCommandeJour() {

        return commandeDAO.getCommandJour();
    }

    public List<Commande> getCommandeAll() {

        return commandeDAO.getCommandAll();
    }

    public List<Commande> getCommandeById(int id) {
        return commandeDAO.getCommandById(id);
    }

    public List<Commande> getPrixJour() {

        return commandeDAO.getPrixJour();
    }

    public List<Commande> getPrixMois() {

        return commandeDAO.getPrixMois();
    }

    public List<Commande> getCommandesJour() {

        return commandeDAO.getCommandesJour();
    }

    public List<Commande> getCommandesMois() {

        return commandeDAO.getCommandesMois();
    }

    public Commande updateById(int id, boolean statut) {
        return commandeDAO.updateStatutById(id, statut);
    }
}


