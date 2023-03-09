package be.ieps.poo.arnaud;

import be.ieps.poo.arnaud.controller.MenuController;


public class StartMenu {


    public static void main(String[] args) {

        MenuController menuController = MenuController.getInstance();

        menuController.startFenetrePrincipale();


    }
}


