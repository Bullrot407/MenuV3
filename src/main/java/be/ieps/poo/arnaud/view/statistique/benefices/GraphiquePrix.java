package be.ieps.poo.arnaud.view.statistique.benefices;


import be.ieps.poo.arnaud.model.Commande;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class GraphiquePrix extends JPanel {
    private final DefaultCategoryDataset dataset;
    private JFreeChart chart;

    public GraphiquePrix(String applicationTitle, String chartTitle, List<Commande> commande)
            throws SQLException {
        super();
        this.dataset = (DefaultCategoryDataset) createDataset(commande);
        this.chart = ChartFactory.createBarChart(chartTitle, "Date", "Prix Total", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JPanel jPanel = new JPanel();
        jPanel.add(chartPanel);
    }

    private CategoryDataset createDataset(List<Commande> commande) {
        final String total = "Prix total";
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Commande commandes : commande) {
            dataset.addValue(commandes.getPrix(), total, commandes.getDateHeure());
        }

        return dataset;
    }

/*    public void updateChart(List<Commande> commande) {
        this.dataset.clear();
        for (Commande commandes : commande) {
            this.dataset.addValue(commandes.getPrix(), "Total Price", commandes.getDateHeure());
        }
        this.chart.fireChartChanged();
    }*/

    public JFreeChart getChart() {
        return chart;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }

    public DefaultCategoryDataset getDataset() {
        return dataset;
    }

}