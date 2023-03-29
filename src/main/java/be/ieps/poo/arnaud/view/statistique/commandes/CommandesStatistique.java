package be.ieps.poo.arnaud.view.statistique.commandes;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.model.Commande;
import be.ieps.poo.arnaud.view.statistique.benefices.GraphiquePrix;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class CommandesStatistique extends JPanel {
    MenuController menuController = MenuController.getInstance();

    public Component commandesStatistiqueJour() {
        List<Commande> commandeList = menuController.getCommandesJour();
        return commandesStatistique(commandeList, "Prix total des commandes des 31 derniers jours.");
    }

    public Component commandesStatistiqueMois() {
        List<Commande> commandeList = menuController.getCommandesMois();
        return commandesStatistique(commandeList, "Prix total des commandes  des 24 derniers mois.");
    }

    public Component commandesStatistique(List<Commande> commandeList, String titreChart) {
        GraphiqueCommande objGraphCommandes;
        ChartPanel chartPanel = null;
        try {
            objGraphCommandes = new GraphiqueCommande("Statistiques", titreChart, commandeList);
            chartPanel = new ChartPanel(objGraphCommandes.getChart());
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
