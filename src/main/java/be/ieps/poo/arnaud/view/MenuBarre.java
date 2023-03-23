package be.ieps.poo.arnaud.view;

import be.ieps.poo.arnaud.model.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MenuBarre {
    private Home homePanel;
    private TableauCommandes commandePanel;
    private Statistique statistiquePanel;
    private ArrayList<Commande> listeCommande;
    private JFrame frame;
    private JMenuBar menuBar;

    public MenuBarre(JFrame frame){

        this.frame = frame;
        menuBar = new JMenuBar();
        homePanel = Home.getInstance();
        commandePanel = new TableauCommandes(listeCommande);
        statistiquePanel = new Statistique();

        JMenuItem homeItem = new JMenuItem("Acceuil");
        homeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setTitle("Restaurant - Home");
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.getContentPane().add(homePanel);
              //  frame.getContentPane().add(homePanel);
                frame.validate();
                frame.repaint();
            }
        });

        JMenuItem menuGestionCommande = new JMenuItem("Gestion commande");
        menuGestionCommande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setTitle("Restaurant - Gestion de commande");
                frame.getContentPane().removeAll();
                frame.getContentPane().add(commandePanel);
                frame.validate();
                frame.repaint();
            }
        });

        JMenuItem menuGraphique = new JMenuItem("Graphiques");
        menuGraphique.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setTitle("Restaurant - Graphiques");
                frame.getContentPane().removeAll();
                frame.getContentPane().add(statistiquePanel);
                frame.validate();
                frame.repaint();
            }

        });
        JMenu menuHome = new JMenu("Home");
        menuHome.add(homeItem);
        JMenu menuCommande = new JMenu("Commande");
        menuCommande.add(menuGestionCommande);
        JMenu menuStatistique = new JMenu("Statistiques");
        menuStatistique.add(menuGraphique);
        menuBar.add(menuHome);
        menuBar.add(menuCommande);
        menuBar.add(menuStatistique);
    }


    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
