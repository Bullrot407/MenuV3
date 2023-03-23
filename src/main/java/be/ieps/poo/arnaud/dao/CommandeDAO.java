package be.ieps.poo.arnaud.dao;

import be.ieps.poo.arnaud.model.Commande;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommandeDAO {

    public static void insertData(Commande commande) {
        Connection connection = ConnectDAO.getInstance().connection();

        String queryCommande = "insert into commande (numéroTable, menu, prix, date, statut) values (?, ?, ?, NOW(), FALSE)";
        PreparedStatement preparedStatement;
        try {
            //empeche le commit automatique
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(queryCommande);
            preparedStatement.setString(1, commande.getTable());
            preparedStatement.setString(2, commande.getMenu());
            preparedStatement.setDouble(3, commande.getPrix());
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement.close();
            connection.setAutoCommit(true);
            connection.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur de connection" + ex);
            try {
                connection.setAutoCommit(true);

                connection.close();
            } catch (SQLException exe) {
                JOptionPane.showMessageDialog(null, "Erreur de connection" + exe);
            }
        }
    }

    public static List getAllCommand(){
        ArrayList list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        try {
            connection = ConnectDAO.getInstance().connection();
            String querryGetAllCommand = "select * from commande";
            preparedStatement = connection.prepareStatement(querryGetAllCommand);
            resultat = preparedStatement.executeQuery();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            while (resultat.next()) {
                int idCommande = resultat.getInt("idCommande");
                String table = resultat.getString("numéroTable");
                Double prix = resultat.getDouble("prix");
                Date date = resultat.getDate("date");
                Time heure = resultat.getTime("date");
                String dateHeure = dateFormat.format(date) + " " + heure.toString();
                boolean statut = resultat.getBoolean("statut");
                Commande commande = new Commande(idCommande, table, "", prix, dateHeure, statut);
                list.add(commande);
            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur: " + ex);
        } finally {
            if (resultat != null) {
                try {
                    resultat.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur: " + ex);
                }
            }
        }
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erreur: " + ex);
            }
        }
        if (preparedStatement != null) ;
        try {
            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur: " + ex);
        }
        return list;
    }
}

