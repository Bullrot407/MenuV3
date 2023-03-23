package be.ieps.poo.arnaud.model;

import java.util.Date;

public class Commande {
    private int idCommande;
    private String table;
    private String menu;
    private Double prix;
    private Date date;
    private String dateHeure;
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

    public Commande(int idCommande, String table, String menu, Double prix, String dateHeure, boolean statut) {
        this.idCommande = idCommande;
        this.table = table;
        this.menu = menu;
        this.prix = prix;
        this.dateHeure = dateHeure;
        this.statut = statut;
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
