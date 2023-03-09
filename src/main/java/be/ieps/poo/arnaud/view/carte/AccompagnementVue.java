package be.ieps.poo.arnaud.view.carte;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.model.carte.Choix;
import be.ieps.poo.arnaud.view.CommandeModal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.function.Function;


public class AccompagnementVue extends JPanel {
    private CommandeModal commandeModal;
    private MenuController menuController;

    public AccompagnementVue(CommandeModal commandeModal) {
        this.commandeModal = commandeModal;
        this.menuController = menuController.getInstance();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Utiliser un BoxLayout avec orientation verticale pour le conteneur principal
        add(new JLabel("Choix d'un accompagnement"));
        Map<String, JPanel> panels = new HashMap<>();
        for (Choix accompagnement : menuController.getCarte().getListeAccompagnements()) {
            String categ = accompagnement.getCategorie();
            JPanel panelCategorie = panels.get(categ);
            if (panelCategorie == null) {
                panelCategorie = new JPanel();
                panelCategorie.setLayout(new FlowLayout(FlowLayout.LEFT)); // Utiliser un FlowLayout pour chaque catégorie
                JLabel labelCategorie = new JLabel(categ);
                panelCategorie.add(labelCategorie);
                add(panelCategorie); // Ajouter chaque catégorie au conteneur principal
                panels.put(categ, panelCategorie);
            }
            JButton btnAccompagnement = new JButton(accompagnement.getType());
            btnAccompagnement.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // code à exécuter lorsque le bouton est cliqué
                    menuController.decorePlat(accompagnement.getCategorie(), accompagnement.getType(), accompagnement.getDescription(), accompagnement.getPrix());
                    //commandeModal.afficheCommande();
                    //passer à l'onglet suivant
                    commandeModal.setSelectedIndex(2);
                    // code à exécuter pour effectuer une action
                    //...
                }
            });
            panelCategorie.add(btnAccompagnement);
        }
    }
}