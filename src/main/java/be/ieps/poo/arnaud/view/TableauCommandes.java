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
        this.table.getTableHeader().setForeground((Color.BLACK));
        this.table.getTableHeader().setBackground(Color.CYAN);
        this.table.getTableHeader().setFont(new Font("arial",Font.BOLD,14));



        JScrollPane tableContenu = new JScrollPane(table);
        tableContenu.setPreferredSize(new Dimension(1000, 800));
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLUE);
        panel.add(tableContenu);

        add(panel, BorderLayout.CENTER);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}