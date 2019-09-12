package helper;

import java.awt.BorderLayout;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import app.Caisse;
import app.Voiture;

public class JFreeChartHelper {
	
	private Caisse caisse;
	
	public JFreeChartHelper(Caisse caisse) {
		this.caisse = caisse;
	}

	public JFrame buildChart() {
		JFrame fen = new JFrame();
		JPanel chartPanel = buildChartPanel();
        fen.add(chartPanel, BorderLayout.CENTER);
 
        fen.setSize(640, 480);
        fen.setLocationRelativeTo(null);
        
        return fen;
	}
	
	public JPanel buildChartPanel() {
		String chartTitle = "Temps d'attente pour caisse n°" + this.caisse.getNumCaisse();
		String xAxisLabel = "Voiture";
		String yAxisLabel = "Temps Attente";
		
		XYDataset dataset = buildDataset(this.caisse.getStats());
		
		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
	            xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, false, false);
		
		return new ChartPanel(chart);
	}
	
	public XYDataset buildDataset(Map<Voiture, Integer> statCaisse) {
		
		XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries attente = new XYSeries("Attente");
	    
	    int i=1;
	    for (Entry<Voiture, Integer> voiture : statCaisse.entrySet()) {
	    	attente.add(i, voiture.getValue());
	    	i++;
		}
	    
	    dataset.addSeries(attente);
	    
	    return dataset;
	}

}
