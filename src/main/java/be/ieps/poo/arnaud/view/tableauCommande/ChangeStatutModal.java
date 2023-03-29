package be.ieps.poo.arnaud.view.tableauCommande;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.model.Commande;
import be.ieps.poo.arnaud.dao.CommandeDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ChangeStatutModal extends JDialog {
    private JTextArea console;
    private JLabel labelIdCommande;
    private JLabel labelTable;
    private JLabel labelFacture;
    private JCheckBox checkBoxFacture;
    private MenuController menuController = MenuController.getInstance();

    public ChangeStatutModal(int id) {
        // Récupérer la commande correspondant à l'id
        List<Commande> commandes = menuController.getCommandeById(id);
        Commande commande = commandes.get(0);
        // Configurer la fenêtre modale
        setTitle(commande.getTable() + " - " + "Commande n°" + commande.getIdCommande());
        setModal(true);

        // Créer un composant JLabel pour afficher l'ID de la commande
        labelIdCommande = new JLabel("ID de la commande: " + commande.getIdCommande());
        labelIdCommande.setHorizontalAlignment(JLabel.CENTER);

        // Créer un composant JLabel pour afficher le numéro de table
        labelTable = new JLabel("Numero de table: " + commande.getTable());

        // Créer un composant JTextArea pour afficher le menu de la commande
        console = new JTextArea();
        console.setEditable(false);
        console.setBackground(Color.BLACK);
        console.setForeground(Color.GREEN);
        console.setText(commande.getMenu());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Créer un composant JLabel pour afficher "Facturé"
        labelFacture = new JLabel("Facturé: ");

        // Créer un composant JCheckBox pour permettre de cocher "Facturé"
        checkBoxFacture = new JCheckBox();
        if (commande.isStatut() == true) {
            checkBoxFacture.setSelected(true);
        }
        checkBoxFacture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = checkBoxFacture.isSelected();
                menuController.updateById(commande.getId(), selected);
            }
        });

        // Créer un conteneur JPanel pour regrouper les composants JLabel et JCheckBox
        JPanel panelFacture = new JPanel(new FlowLayout());
        panelFacture.add(labelFacture);
        panelFacture.add(checkBoxFacture);

        // Ajouter tous les composants à la fenêtre modale
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(labelIdCommande, BorderLayout.NORTH);
        getContentPane().add(console, BorderLayout.CENTER);
        getContentPane().add(labelTable, BorderLayout.SOUTH);
        getContentPane().add(panelFacture, BorderLayout.AFTER_LAST_LINE);

        // Afficher la fenêtre modale
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}