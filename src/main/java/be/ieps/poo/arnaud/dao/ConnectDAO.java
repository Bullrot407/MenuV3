package be.ieps.poo.arnaud.dao;

import be.ieps.poo.arnaud.model.carte.loader.XMLLoader;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDAO {
    private String URL;
    private String USER ;
    private String PASS;

    private static ConnectDAO instance = null;

    public ConnectDAO() {
    }

    public static ConnectDAO getInstance() {
        if (instance == null) {
            instance = new ConnectDAO();
        }
        return instance;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public Connection connection() {
        Connection connection;
        try {
            loadUser();
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + this.URL, this.USER, this.PASS);
            return connection;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "erreur driver mySql :" + ex);
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "echec à la connexion :" + ex);
            return null;
        } catch (IOException | JDOMException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadUser() throws IOException, JDOMException, URISyntaxException {
        XMLLoader loader = new XMLLoader();
        Element rootElement = loader.loadResourceToXml("userDAO.xml");

        String user = rootElement.getChildText("user");
        String password = rootElement.getChildText("password");
        String url = rootElement.getChildText("url");

        // utilisez ces valeurs pour initialiser un objet ConnectDAO
        ConnectDAO connectDAO = ConnectDAO.getInstance();
        connectDAO.setUSER(user);
        connectDAO.setPASS(password);
        connectDAO.setURL(url);
    }
}
