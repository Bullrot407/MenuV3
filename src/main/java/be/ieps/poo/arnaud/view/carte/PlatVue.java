package be.ieps.poo.arnaud.view.carte;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.model.carte.Choix;
import be.ieps.poo.arnaud.view.CommandeModal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;

public class PlatVue extends JPanel {
    private CommandeModal commandeModal;
    private MenuController menuController;

    public PlatVue(CommandeModal commandeModal) {
        this.commandeModal = commandeModal;
        this.menuController = menuController.getInstance();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Utiliser un BoxLayout avec orientation verticale pour le conteneur principal
        add(new JLabel("Choix d'un plat"));
        Map<String, JPanel> panels = new HashMap<>();
        for (Choix plat : menuController.getCarte().getListePlats()) {
            String categ = plat.getCategorie();
            JPanel panelCategorie = panels.get(categ);
            if (panelCategorie == null) {
                panelCategorie = new JPanel();
                panelCategorie.setLayout(new FlowLayout(FlowLayout.LEFT)); // Utiliser un FlowLayout pour chaque catégorie
                JLabel labelCategorie = new JLabel(categ);
                panelCategorie.add(labelCategorie);
                add(panelCategorie); // Ajouter chaque catégorie au conteneur principal
                panels.put(categ, panelCategorie);
            }
            JButton btnPlat = new JButton(plat.getType());
            btnPlat.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // code à exécuter lorsque le bouton est cliqué
                    menuController.creerPlat(plat.getCategorie(), plat.getType(),plat.getDescription(), plat.getPrix());
                    //commandeModal.afficheCommande();
                    //passer à l'onglet suivant
                    commandeModal.setSelectedIndex(1);
                    // code à exécuter pour effectuer une action
                    //...
                }
            });
            panelCategorie.add(btnPlat);
        }
    }
}
