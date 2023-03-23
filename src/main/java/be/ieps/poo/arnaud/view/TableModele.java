package be.ieps.poo.arnaud.view;

import be.ieps.poo.arnaud.model.Commande;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModele extends AbstractTableModel {
    private final List<Commande> liste;
    private final String[] colonneNoms = {"Commande", "Numéro de Table", "Menu", "Prix", "Date", "Facturée"};

    public TableModele(List<Commande> liste) {
        this.liste = liste;
    }
@Override
    public String getColumnName(int col) {
        String result;
        switch (col) {
            case 0 -> result = colonneNoms[0];
            case 1 -> result = colonneNoms[1];
            case 2 -> result = colonneNoms[2];
            case 3 -> result = colonneNoms[3];
            case 4 -> result = colonneNoms[4];
            case 5 -> result = colonneNoms[5];
            default -> result = "";
        }
        ;
        return result;
    }

    @Override
    public int getRowCount() {
        if (liste == null) {
            return 0;
        } else {
            return liste.size();
        }
    }

    @Override
    public int getColumnCount() {
        return colonneNoms.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Commande ligne = (Commande) liste.get(rowIndex);
        Object result;
        switch (columnIndex) {
            case 0 -> result = ligne.getIdCommande();
            case 1 -> result = ligne.getTable();
            case 2 -> result = ligne.getMenu();
            case 3 -> result = ligne.getPrix();
            case 4 -> result = ligne.getDateHeure();
            case 5 -> result = ligne.isStatut();
            default -> result = null;
        }
        return result;
    }
}
