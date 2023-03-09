package be.ieps.poo.arnaud.view;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.view.CommandeModal;
import be.ieps.poo.arnaud.view.TableDialog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Home extends JPanel {

    private static Home instance;
    private final MenuController menuController;
    private final ArrayList<JButton> boutons = new ArrayList<>();

    private Home() {
        menuController = MenuController.getInstance();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Affiche une boîte de dialogue pour demander à l'utilisateur de saisir le nombre de tables souhaité
        int numTables = TableDialog.showInputDialog(this);

        // Ajoute les boutons au panneau et à l'ArrayList
        for (int i = 0; i < numTables; i++) {
            JButton bouton = new JButton("Table " + (i + 1));
            gbc.gridx = i % 5; // 5 boutons par ligne
            gbc.gridy = i / 5;
            add(bouton, gbc);

            bouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    menuController.setTable(bouton.getText());

                    CommandeModal commandeModal = new CommandeModal();
                    commandeModal.setSize(800, 600);
                }
            });

            boutons.add(bouton); // Ajoute le bouton à l'ArrayList
        }
    }

    static Home getInstance() {
        if (instance == null) {
            instance = new Home();
        }
        return instance;
    }

    public void showButtons() {
        for (JButton bouton : boutons) {
            add(bouton);
        }
    }
}

/*    private Home() {
        menuController = MenuController.getInstance();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Affiche une boîte de dialogue pour demander à l'utilisateur de saisir le nombre de tables souhaité
        int numTables = TableDialog.showInputDialog(this);

        // Ajoute les boutons au panneau
        for (int i = 0; i < numTables; i++) {
            JButton bouton = new JButton("Table " + (i + 1));
            gbc.gridx = i % 5; // 5 boutons par ligne
            gbc.gridy = i / 5;
            add(bouton, gbc);

            bouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    menuController.setTable(bouton.getText());

                    CommandeModal commandeModal = new CommandeModal();
                    commandeModal.setSize(800, 600);
                }
            });
        }
    }*/