package be.ieps.poo.arnaud.view.carte;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.model.carte.Choix;
import be.ieps.poo.arnaud.view.CommandeModal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class DessertVue extends JPanel {
    private CommandeModal commandeModal;
    private MenuController menuController;

    public DessertVue(CommandeModal commandeModal) {
        this.commandeModal = commandeModal;
        this.menuController = MenuController.getInstance();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Choix d'un dessert"));

        Map<String, JPanel> panels = new HashMap<>();
        for (Choix dessert : menuController.getCarte().getListeDesserts()) {
            String categ = dessert.getCategorie();
            JPanel panelCategorie = panels.get(categ);
            if (panelCategorie == null) {
                panelCategorie = new JPanel();
                panelCategorie.setLayout(new FlowLayout(FlowLayout.LEFT)); // Utiliser un FlowLayout pour chaque catégorie
                JLabel labelCategorie = new JLabel(categ);
                panelCategorie.add(labelCategorie);
                add(panelCategorie); // Ajouter chaque catégorie au conteneur principal
                panels.put(categ, panelCategorie);
            }

            JButton btnDessert = new JButton(dessert.getType());
            btnDessert.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuController.decorePlat(dessert.getCategorie(), dessert.getType(), dessert.getDescription(), dessert.getPrix());
                    int result = JOptionPane.showOptionDialog(
                            null,
                            "Voulez-vous ajouter un menu supplémentaire?",
                            "Information!!!",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            null,
                            null
                    );
                    if (result == JOptionPane.YES_OPTION) {
                        commandeModal.effaceConsole();
                        menuController.ajoutMenuCommande();
                        commandeModal.afficheCommande(menuController.getTable());
                        commandeModal.setSelectedIndex(0);
                    } else {
                        commandeModal.effaceConsole();
                        menuController.ajoutMenuCommande();
                        commandeModal.menuCommandeTotal(menuController.getTable());
                        commandeModal.prixTotalCommandeTable(menuController.getTable());
                    }
                }
            });
            panelCategorie.add(btnDessert);
        }
    }
}