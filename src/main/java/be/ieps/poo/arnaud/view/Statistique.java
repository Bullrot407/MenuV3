package be.ieps.poo.arnaud.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Statistique extends JPanel {
    public Statistique() {
        setLayout(new BorderLayout());
        add(new JLabel("Contenu de la fenêtre de statistiques"), BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton buttonGauche = new JButton("<<<");
        JButton buttonDroit = new JButton(">>>");
        buttonPanel.add(buttonGauche);
        buttonPanel.add(buttonDroit);
        add(buttonPanel, BorderLayout.SOUTH);

        buttonGauche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // code à exécuter lorsque le bouton est cliqué
            }
        });

        buttonDroit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // code à exécuter lorsque le bouton est cliqué
            }
        });
    }
}