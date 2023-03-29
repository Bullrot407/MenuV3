package be.ieps.poo.arnaud.dao;

import be.ieps.poo.arnaud.controller.MenuController;
import be.ieps.poo.arnaud.model.Commande;
import be.ieps.poo.arnaud.model.Constante;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class CommandeDAO {
    private static CommandeDAO commandeDAO;

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public static CommandeDAO getInstance() {
        if (commandeDAO == null) {
            commandeDAO = new CommandeDAO();
        }
        return commandeDAO;
    }

    public void insertData(Commande commande) {
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

    public List<Commande> getCommandJour() {
        return getCommandType("SELECT * FROM commande WHERE DATE(date) = CURDATE()",null);
    }

    public List<Commande> getCommandAll() {
        return getCommandType("select * from commande",null);
    }

    public List<Commande> getCommandById(int id){ return getCommandType("select * from commande c where idCommande = ?",id);}


    public List getCommandType(String querry,Integer id){
        List list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        try {
            connection = ConnectDAO.getInstance().connection();
            preparedStatement = connection.prepareStatement(querry);
            if (id != null) {
                preparedStatement.setInt(1, id);
            }

            resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
                int idCommande = resultat.getInt("idCommande");
                String table = resultat.getString("numéroTable");
                String menu = resultat.getString("menu");
                Double prix = resultat.getDouble("prix");
                Date dateTime = resultat.getTimestamp("date");
                boolean statut = resultat.getBoolean("statut");
                Commande commande = new Commande(idCommande, table, menu, prix, dateTime, statut);
                list.add(commande);
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } finally {
            close(resultat);
            close(preparedStatement);
            close(connection);
        }
        return list;
    }


    public Commande updateStatutById(int idCommande, boolean statut) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectDAO.getInstance().connection();
            preparedStatement = connection.prepareStatement("UPDATE commande SET statut = ? WHERE idCommande = ?");
            preparedStatement.setBoolean(1, statut);
            preparedStatement.setInt(2, idCommande);
            preparedStatement.executeUpdate();

            this.propertyChangeSupport.firePropertyChange(Constante.COMMANDESTATUT,null,statut);

        } catch (SQLException ex) {
            handleSQLException(ex);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return null;
    }
/*    public static Commande update(Commande commande, String querry) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        int rowsAffected = 0;

        try {
            connection = ConnectDAO.getInstance().connection();
            // Empêche le commit automatique
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, commande.getTable());
            preparedStatement.setDouble(2, commande.getPrix());
            preparedStatement.setBoolean(3, commande.isStatut());
            preparedStatement.setInt(4, commande.getIdCommande());
            rowsAffected = preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            handleSQLException(ex);
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        if (rowsAffected > 0) {

            return commande;
        }
        return null;
    }*/


    public  List<Commande> getPrixJour() {
        return getPrixType(
                "SELECT DATE_FORMAT(date, '%d/%m/%Y') AS date, SUM(prix) AS prix\n" +
                        "FROM commande\n" +
                        "WHERE statut  = true AND  date >= NOW() - INTERVAL 31 DAY\n" +
                        "GROUP BY date\n" +
                        "ORDER BY MIN(date) ASC;");
    }

    public  List<Commande> getPrixMois() {
        return getPrixType(
                "SELECT DATE_FORMAT(date, '%m-%Y') AS date, SUM(prix) AS prix\n" +
                        "FROM commande\n" +
                        "WHERE statut  = true AND date >= NOW() - INTERVAL 24 month \n" +
                        "GROUP BY DATE_FORMAT(date, '%m-%Y')\n" +
                        "ORDER BY MIN(date) ASC;");
    }

    private  List<Commande> getPrixType(String querry) {
        List<Commande> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        try {
            connection = ConnectDAO.getInstance().connection();
            preparedStatement = connection.prepareStatement(querry);
            resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
                Double prix = resultat.getDouble("prix");
                String date = resultat.getString("date");
                Commande commande = new Commande(prix, date);
                list.add(commande);
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } finally {
            close(resultat);
            close(preparedStatement);
            close(connection);
        }
        return list;
    }

    public  List<Commande> getCommandesJour() {
        return getCommandeType("   SELECT DATE_FORMAT(date, '%d/%m/%Y') AS date, COUNT(*) AS nombre_Commande\n" +
                "    FROM commande\n" +
                "    WHERE date >= NOW() - INTERVAL 31 DAY\n" +
                "    GROUP BY DATE_FORMAT(date, '%d/%m/%Y')\n" +
                "    ORDER BY MIN(date) ASC;");
    }

    public  List<Commande> getCommandesMois() {
        return getCommandeType("   SELECT DATE_FORMAT(date, '%m/%Y') AS date, COUNT(*) AS nombre_Commande\n" +
                "    FROM commande\n" +
                "    WHERE date >= NOW() - INTERVAL 24 MONTH\n" +
                "    GROUP BY DATE_FORMAT(date, '%m/%Y')\n" +
                "    ORDER BY MIN(date) ASC;");
    }

    private  List<Commande> getCommandeType(String querry) {
        List<Commande> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        try {
            connection = ConnectDAO.getInstance().connection();
            preparedStatement = connection.prepareStatement(querry);
            resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
                int nombreCommande = resultat.getInt("nombre_Commande");
                String date = resultat.getString("date");
                Commande commande = new Commande(nombreCommande, date);
                list.add(commande);
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } finally {
            close(resultat);
            close(preparedStatement);
            close(connection);
        }
        return list;
    }

    private void handleSQLException(SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erreur: " + ex);
    }

    private void close(AutoCloseable c) {
        if (c != null) {
            try {
                c.close();
            } catch (Exception ex) {
                handleSQLException((SQLException) ex);
            }
        }
    }
}

