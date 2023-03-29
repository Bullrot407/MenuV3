package be.ieps.poo.arnaud.view.statistique.benefices;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.model.Commande;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class BeneficesStatistique extends JPanel {
    MenuController menuController = MenuController.getInstance();

    public Component beneficesStatistiqueJour() {
        List<Commande> commandeList = menuController.getPrixJour();
        return beneficesStatistique(commandeList, "Prix total des commandes des 31 derniers jours.");
    }

    public Component beneficesStatistiqueMois() {
        List<Commande> commandeList = menuController.getPrixMois();
        return beneficesStatistique(commandeList, "Prix total des commandes des 24 derniers mois.");
    }

    public Component beneficesStatistique(List<Commande> commandeList, String titreChart) {
        GraphiquePrix objGraphPrix;
        ChartPanel chartPanel = null;
        try {
            objGraphPrix = new GraphiquePrix("Statistiques", titreChart, commandeList);
            chartPanel = new ChartPanel(objGraphPrix.getChart());
            this.add(chartPanel);
            this.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erreur lors de la recuperation des données dans DB des Commandes" + ex.getMessage(), "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return chartPanel;
    }
}



/*
    public Component beneficesStatistiqueJour() {
        List<Commande> commandeList = menuController.getPrixJour();
        GraphiquePrix objGraphPrxJour;
        ChartPanel chartPanel = null;
        try {
            objGraphPrxJour = new GraphiquePrix("Statistiques", "Prix total des commandes par jour.", commandeList);
            chartPanel = new ChartPanel(objGraphPrxJour.getChart());
            this.add(chartPanel);
            this.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erreur lors de la recuperation des données dans DB des Commandes" + ex.getMessage(), "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return chartPanel;
    }
*/



/*
    public List<Commande> beneficesStatistiqueMois() {
        List<Commande> commandeArrayList = menuController.getPrixMois();
        GraphiquePrix objGraphPrxMois;
        try {
            objGraphPrxMois = new GraphiquePrix("Statistiques", "Prix total des commandes par mois.", commandeArrayList);
            ChartPanel chartPanel = new ChartPanel(objGraphPrxMois.getChart());
            this.add(chartPanel);
            this.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erreur lors de la recuperation des données dans DB des Commandes" + ex.getMessage(), "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return commandeArrayList;
    }
}
*/
