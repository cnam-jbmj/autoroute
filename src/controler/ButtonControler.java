package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import app.Caisse;
import helper.JFreeChartHelper;

public class ButtonControler implements ActionListener {
	
	private Caisse caisse;

	public ButtonControler(Caisse caisse) {
		this.caisse = caisse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFreeChartHelper chartHelper = new JFreeChartHelper(caisse);
		JFrame chart = chartHelper.buildChart();
		chart.setVisible(true);
	}

}
