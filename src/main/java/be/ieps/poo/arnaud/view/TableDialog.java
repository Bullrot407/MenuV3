package be.ieps.poo.arnaud.view;

import javax.swing.*;
import java.awt.*;

public class TableDialog {

    public static int showInputDialog(Component parent) {
        int numTables = 0;
        while (numTables < 1 || numTables > 30) {
            String numTablesStr = JOptionPane.showInputDialog(parent, "Veuillez saisir le nombre de tables souhaité (entre 1 et 30) :");
            if (numTablesStr == null) { // Si l'utilisateur clique sur "Cancel" ou sur la croix
                System.exit(0); // Ferme le programme
            }
            try {
                numTables = Integer.parseInt(numTablesStr);
            } catch (NumberFormatException e) {
                numTables = 0;
            }
        }
        return numTables;
    }
}
