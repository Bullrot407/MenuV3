package be.ieps.poo.arnaud.view;


import javax.swing.*;
import java.awt.event.*;

public class Commande extends JPanel {

    public Commande() {
        add(new JLabel("Contenu de la fenêtre de gestion de commande"));

        JButton button = new JButton("Cliquez-moi");
        button.setSize(150, 50); // définit la taille du bouton en pixels
        button.setLocation(50, 50); // définit la position du bouton en pixels
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // code à exécuter lorsque le bouton est cliqué
            }
        });
        add(button);
    }
}
