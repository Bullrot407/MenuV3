/*
package be.ieps.poo.arnaud.view;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.model.Commande;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class TableauCommandes extends JPanel implements PropertyChangeListener{

    private final MenuController menuController;
    private JTable table;

    public TableauCommandes(ArrayList<Commande> listeCommande){
        this.menuController = MenuController.getInstance();
        init();
    }

    public void init(){
        JPanel panel = new JPanel();
        ArrayList<Commande> arrayListAllCommandes = menuController.insertDataJtable();
        this.table = new JTable();
        this.table.setAutoCreateRowSorter(true);
        this.table.setModel(new TableModele(arrayListAllCommandes));
        this.table.setShowHorizontalLines(true);
        this.table.setShowVerticalLines(false);
        this.table.setGridColor(Color.BLACK);
        JScrollPane tableContenu = new JScrollPane(table);

        this.table.getTableHeader().setForeground((Color.BLACK));
        this.table.getTableHeader().setBackground(Color.CYAN);
        this.table.getTableHeader().setFont(new Font("arial",Font.BOLD,14));
        this.table.setSize(new Dimension(1000, 800));
        panel.setLayout(new BorderLayout());

        panel.setBackground(Color.BLUE);
        panel.add(tableContenu, BorderLayout.CENTER);
        add(panel);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}*/
package be.ieps.poo.arnaud.view.tableauCommande;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.dao.CommandeDAO;
import be.ieps.poo.arnaud.model.Commande;
import be.ieps.poo.arnaud.model.Constante;
import be.ieps.poo.arnaud.view.MenuBarre;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TableauCommandes extends JPanel implements PropertyChangeListener {
    private JTable table;
    private List<Commande> listCommandes;
    private TableModele tableModele;
    MenuBarre menuBarre;

    public TableauCommandes(List<Commande> listeCommandes, MenuBarre menuBarre) {
        this.listCommandes = listeCommandes;
        this.menuBarre = menuBarre;
        init();
    }

    public void init() {
        JPanel panel = new JPanel();
        CommandeDAO.getInstance().getPropertyChangeSupport().addPropertyChangeListener(Constante.COMMANDESTATUT, this);
        this.tableModele = new TableModele(listCommandes);
        this.table = new JTable();
        this.table.setAutoCreateRowSorter(true);
        this.table.setModel(tableModele);
        this.table.setShowHorizontalLines(true);
        this.table.setShowVerticalLines(false);

        this.table.setGridColor(Color.BLACK);
        this.table.getTableHeader().setForeground((Color.BLACK));
        this.table.getTableHeader().setBackground(Color.CYAN);
        this.table.getTableHeader().setFont(new Font("arial", Font.BOLD, 14));

        this.table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent mouseEvt) {
                int row = table.rowAtPoint(mouseEvt.getPoint());
                int idCommande = (int) table.getValueAt(row, 0);
                if (mouseEvt.getClickCount() == 2) {
                    new ChangeStatutModal(idCommande);
                }
            }

        });


        setRendrerTable((ArrayList) listCommandes);

        JScrollPane tableContenu = new JScrollPane(table);

        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLUE);
        panel.setPreferredSize(new Dimension(900, 700));
        panel.add(tableContenu);

        add(panel, BorderLayout.CENTER);


    }

    //A GARDER
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ArrayList<Commande> listCommandes = null;
        if (evt.getPropertyName().equals(Constante.COMMANDESTATUT)) {
            if (menuBarre.getMenuSelectionne().equals(Constante.COMMANDEJOUR)) {
                listCommandes = new ArrayList<>(MenuController.getInstance().getCommandeJour());
            } else if (menuBarre.getMenuSelectionne().equals(Constante.COMMANDEGLOBAL)) {
                listCommandes = new ArrayList<>(MenuController.getInstance().getCommandeAll());
            } else {
                JOptionPane.showMessageDialog(null, "Erreur: Pas de liste disponible.");

            }
            tableModele = new TableModele(listCommandes); // Initialise le nouveau modèle de table
            table.setModel(tableModele); // Définit le modèle de table mis à jour

            if (listCommandes != null) {
                setRendrerTable(listCommandes); // Met à jour le rendu de la table
            }
        }

    }

    public class RenderTable extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String statut = (String) table.getValueAt(row, 4);
            if (statut == "Non payé") {
                cell.setBackground(Color.red);
            } else {
                if (row % 2 == 0) {
                    cell.setBackground(Color.orange);
                } else {
                    cell.setBackground(Color.white);
                }
            }
            return cell;
        }

    }

    public void setRendrerTable(ArrayList list) {

        if (!(list.isEmpty())) {
            DefaultTableCellRenderer rendrer = new RenderTable();
            for (int i = 0; i < table.getColumnCount(); i++) {
                TableColumn tableColumn = table.getColumnModel().getColumn(i);
                tableColumn.setCellRenderer(rendrer);
            }
        }

    }

 /*    @Override
   public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("test 1" + evt.getSource());
        if (CommandeDAO.getInstance().equals(evt.getSource())) {
            System.out.println("Table modifiée" + evt.getNewValue());
            tableModele.fireTableChanged();
            *//*table.updateUI();*//*

        }
    }*/
}