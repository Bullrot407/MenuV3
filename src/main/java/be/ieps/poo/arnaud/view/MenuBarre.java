
package be.ieps.poo.arnaud.view;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.model.Constante;
import be.ieps.poo.arnaud.view.tableauCommande.TableauCommandes;
import be.ieps.poo.arnaud.view.statistique.benefices.BeneficesStatistique;
import be.ieps.poo.arnaud.view.statistique.commandes.CommandesStatistique;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuBarre {
    private Home homePanel;
    private MenuController menuController;
    private BeneficesStatistique beneficesStatistique;
    private CommandesStatistique commandesStatistique;
    private JFrame frame;
    private JMenuBar menuBar;
    private TableauCommandes commandeJour = null, commandeAll= null;
    private String menuSelectionne;

    private TableauCommandes getCommandeJour() {
        this.commandeJour = new TableauCommandes(menuController.getCommandeJour(), this );

        return this.commandeJour;
    }

    private TableauCommandes getCommandeAll() {

        this.commandeAll = new TableauCommandes(menuController.getCommandeAll(),this);
        return this.commandeAll;
    }


    public MenuBarre(JFrame frame) {
        this.frame = frame;
        menuBar = new JMenuBar();
        homePanel = Home.getInstance();
        menuController = MenuController.getInstance();
        beneficesStatistique = new BeneficesStatistique();
        commandesStatistique = new CommandesStatistique();


        JMenuItem homeItem = new JMenuItem("Acceuil");
        homeItem.addActionListener(e -> showPanel(homePanel, "Restaurant - Home"));

        JMenu menuCommande = new JMenu("Commande");
        JMenuItem commandeJourItem = createMenuItem(Constante.COMMANDEJOUR, e -> {
            showPanel(this.getCommandeJour(), "Restaurant - Gestion de commande du jour");
            setMenuSelectionne(Constante.COMMANDEJOUR);
        });
        JMenuItem commandeAllItem = createMenuItem(Constante.COMMANDEGLOBAL, e -> {
            showPanel(this.getCommandeAll(), "Restaurant - Gestion de commande global");
            setMenuSelectionne(Constante.COMMANDEGLOBAL);
        });
 /*       menuCommande.add(createMenuItem("Gestion commande du jour", e -> showPanel(this.getCommandeJour(), "Restaurant - Gestion de commande du jour")));
        menuCommande.add(createMenuItem("Gestion commande global", e -> showPanel(this.getCommandeAll(), "Restaurant - Gestion de commande global")));*/

        JMenu menuGraphiqueBenefices = new JMenu("Graphiques bénéfices");
        menuGraphiqueBenefices.add(createMenuItem("Par jour", e -> showPanel((JComponent) beneficesStatistique.beneficesStatistiqueJour(), "Restaurant - Graphiques bénéfices par jour")));
        menuGraphiqueBenefices.add(createMenuItem("Par mois", e -> showPanel((JComponent) beneficesStatistique.beneficesStatistiqueMois(), "Restaurant - Graphiques bénéfices par mois")));

        JMenu menuGraphiqueCommandes = new JMenu("Graphiques commandes");
        menuGraphiqueCommandes.add(createMenuItem("Par jour", e -> showPanel((JComponent) commandesStatistique.commandesStatistiqueJour(), "Restaurant - Graphiques commandes par Jours")));
        menuGraphiqueCommandes.add(createMenuItem("Par mois", e -> showPanel((JComponent) commandesStatistique.commandesStatistiqueMois(), "Restaurant - Graphiques commandes par mois")));


        JMenu menuHome = new JMenu("Home");
        menuHome.add(homeItem);

        JMenu menuStatistique = new JMenu("Statistiques");
        menuStatistique.add(menuGraphiqueBenefices);
        menuStatistique.add(menuGraphiqueCommandes);
        menuCommande.add(commandeJourItem);
        menuCommande.add(commandeAllItem);
        menuBar.add(menuHome);
        menuBar.add(menuCommande);
        menuBar.add(menuStatistique);
    }

    private JMenuItem createMenuItem(String text, ActionListener action) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(action);
        return menuItem;
    }

    private void showPanel(JComponent panel, String title) {
        frame.setTitle(title);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.validate();
        frame.repaint();
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuSelectionne(String menuSelectionne) {
        this.menuSelectionne = menuSelectionne;
    }

    public String getMenuSelectionne() {
        return menuSelectionne;
    }
}