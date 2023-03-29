package be.ieps.poo.arnaud.model;

import java.util.Date;

public class Commande {
    private int idCommande,nbCommande;
    private String table,menu,dateHeure;
    private Double prix;
    private Date date;

    private boolean statut;

    public Commande() {
    }

    public Commande(String table, String menu, Double prix) {
        this.table = table;
        this.menu = menu;
        this.prix = prix;
    }

    public Commande(int id, String table, String menu, Double prix, Date date, boolean statut) {
        this.idCommande = id;
        this.table = table;
        this.menu = menu;
        this.prix = prix;
        this.date = date;
        this.statut = statut;
    }
    public Commande(int id, String table, Double prix, Date date, boolean statut) {
        this.idCommande = id;
        this.table = table;
        this.prix = prix;
        this.date = date;
        this.statut = statut;
    }
    public Commande(Double prix, String dateHeure) {
        this.prix = prix;
        this.dateHeure = dateHeure;
    }

    public Commande(int nbCommande, String dateHeure) {
        this.nbCommande = nbCommande;
        this.dateHeure = dateHeure;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getNbCommande() {
        return nbCommande;
    }

    public void setNbCommande(int nbCommande) {
        this.nbCommande = nbCommande;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }

    public int getId() {
        return idCommande;
    }

    public void setId(int id) {
        this.idCommande = id;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public int getIdCommande() {
        return idCommande;
    }
}
