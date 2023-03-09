package be.ieps.poo.arnaud.model.carte;

import be.ieps.poo.arnaud.model.plats.Plat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Commande {

    String menuCommandeTotal= "", menuCommande ="";
    private Map<String, ArrayList<Plat>> listeCommande = new HashMap<>();

    public Commande() {
    }

    public void ajoutMenuCommande(String table, Plat plat) {
        if (listeCommande.containsKey(table)) {

            listeCommande.get(table).add(plat);
        } else {
            listeCommande.put(table, new ArrayList<>());
            listeCommande.get(table).add(plat);
        }
    }

    /**
     * Total des commandes du restaurant
     */
    public int nombreMenuCommande() {
        int nbMenuCommande = 0;
        for (ArrayList<Plat> arLisPlats : listeCommande.values()) {
            nbMenuCommande += arLisPlats.size();
        }
        return nbMenuCommande;
    }

    /**
     * @param table la table de la commande
     */
    public double prixTotalCommande(String table) {

        if (!listeCommande.containsKey(table)) return 0;

        double prixTotal = 0;
        for (Plat plat : listeCommande.get(table)) {
            prixTotal += plat.getPrix();
        }

        return prixTotal;
    }

    public String afficheCommandeTable(String table) {
        int index = 0;
        menuCommandeTotal = "";
        for (Plat plat : listeCommande.get(table)) {
             /*listeCommande.get(table).size()*/;
            menuCommande = "Menu " + (index + 1) + ":\n" +
                    plat.getPreparation() + "\n" +
                    plat.getPrix() + "\n";
            index ++;
            menuCommandeTotal += menuCommande;
        }
        return menuCommandeTotal;
    }

    public ArrayList<Plat> getCommandes(String table) {
        return listeCommande.getOrDefault(table, new ArrayList<>());
    }
}
