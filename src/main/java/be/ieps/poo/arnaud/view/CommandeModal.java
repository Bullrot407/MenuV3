
package be.ieps.poo.arnaud.view;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.model.carte.Carte;
import be.ieps.poo.arnaud.model.carte.Choix;
import be.ieps.poo.arnaud.view.carte.AccompagnementVue;
import be.ieps.poo.arnaud.view.carte.DessertVue;
import be.ieps.poo.arnaud.view.carte.PlatVue;
import org.jdom2.JDOMException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class CommandeModal extends JDialog {
    private JTabbedPane tabbedPane;
    private JPanel cartePlats;
    private JPanel carteAccompagnements;
    private JPanel carteDesserts;
    private JTextArea console;
    MenuController menuController = MenuController.getInstance();

    public void setSelectedIndex(int index) {
        tabbedPane.setSelectedIndex(index);
    }
    public CommandeModal() {

        // Création de l'onglet
        tabbedPane = new JTabbedPane();
        console = new JTextArea();

        // Création du scroll pane
        JScrollPane scrollPane = new JScrollPane(console);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Ajout des panneaux à l'onglet
        cartePlats = new PlatVue(this);
        tabbedPane.addTab("Carte plats", cartePlats);

        carteAccompagnements = new AccompagnementVue(this);
        tabbedPane.addTab("Carte accompagnements", carteAccompagnements);

        carteDesserts = new DessertVue(this);
        tabbedPane.addTab("Carte desserts", carteDesserts);

        // Création du panel
        this.setLayout(new BorderLayout());

        tabbedPane.setPreferredSize(new Dimension(900, 300));
        scrollPane.setPreferredSize(new Dimension(900, 250));
        console.setBackground(Color.black);
        console.setForeground(Color.green);
        console.setFont(new Font("Arial", Font.BOLD, 14));
        console.setEditable(true);
        console.setLineWrap(true);
        console.setWrapStyleWord(true);

        // Affichage de la fenêtre modale
        this.setTitle(menuController.getTable());
        this.setModal(true);
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);

        this.add(tabbedPane, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setResizable(false);
        this.setVisible(true);
    }
    /*public CommandeModal() {

        // Création de l'onglet
        tabbedPane = new JTabbedPane();
        console = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(console);

        // Ajout des panneaux à l'onglet

        cartePlats = new PlatVue(this);
        tabbedPane.addTab("Carte plats", cartePlats);

        carteAccompagnements = new AccompagnementVue(this);
        tabbedPane.addTab("Carte accompagnements", carteAccompagnements);

        carteDesserts = new DessertVue(this);
        tabbedPane.addTab("Carte desserts", carteDesserts);

        //creation du panel

        this.setLayout(new BorderLayout());

        tabbedPane.setPreferredSize((new Dimension(900, 300)));
        console.setPreferredSize((new Dimension(900, 250)));
        scrollPane.setPreferredSize(new Dimension(900,250));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // Affichage de la fenêtre modale
        this.setTitle(menuController.getTable());
        this.setModal(true);
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.add(tabbedPane, BorderLayout.NORTH);

        this.add(scrollPane, BorderLayout.SOUTH);
        this.setResizable(false);
        console.setEditable(true);
        console.setLineWrap(true);
        console.setWrapStyleWord(true);
        console.setBackground(Color.black);
        console.setForeground(Color.green);
        console.setFont(new Font("Arial", Font.BOLD, 14));

        this.setVisible(true);
    }*/

    public void afficheCommande(String table) {
        console.append(menuController.afficheCommande(table));
    }

    public void effaceConsole() {
        console.setText("");
    }

    public void prixTotalCommandeTable(String table) {
        console.append(menuController.prixTotalCommandeTable(table));
    }

    public void menuCommandeTotal(String table) {
        console.append(menuController.afficheCommandeTable(table));

    }

}

