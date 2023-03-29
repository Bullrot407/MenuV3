package be.ieps.poo.arnaud.view.tableauCommande;

import be.ieps.poo.arnaud.model.Commande;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.List;


public class TableModele extends AbstractTableModel {
    private final List<Commande> liste;
    private final String[] colonneNoms = {"Commande", "Numéro de Table", "Prix", "Date", "Facturée"};



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
        Commande ligne = liste.get(rowIndex);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Object result;
        switch (columnIndex) {
            case 0 -> result = ligne.getIdCommande();
            case 1 -> result = ligne.getTable();
            case 2 -> result = ligne.getPrix() + "€";
            case 3 -> result = formatter.format(ligne.getDate());
            case 4 -> {
                if (ligne.isStatut() == true) {
                    result = "Payé";
                } else {
                    result = "Non payé";
                }
            }
            default -> result = null;
        }
        return result;
    }

}
