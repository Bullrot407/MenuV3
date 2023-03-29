package be.ieps.poo.arnaud.view;

import be.ieps.poo.arnaud.controller.MenuController;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.*;

public class FenetrePrincipale extends JFrame {
    private Home home;

    public FenetrePrincipale() {
        home = Home.getInstance();

        setTitle("Restaurant");
        getContentPane().add(home);
        // setContentPane(home);
        setSize(new Dimension(1000, 800));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        MenuBarre menuBarre = new MenuBarre(this);
        setJMenuBar(menuBarre.getMenuBar());

        setVisible(true);
    }
}

