package vue;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import controler.InitControler;

public class InitWindow extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JSpinner nbVoiture;
	private JSpinner nbCaisse;
	private JSpinner kmMin;
	private JSpinner kmMax;
	private JSpinner vmoyVehicle;
	
	private JButton fermer;
	private JButton simuler;
	
	public InitWindow() {
		JFrame frame = new JFrame();
		frame.setTitle("Initialisation simulation");
		frame.setLayout(new GridLayout(6,2));
		frame.setSize(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		InitControler controler = new InitControler(this);
		
		frame.add(new JLabel("Nombre de voitures"));
		this.nbVoiture = new JSpinner();
		frame.add(this.nbVoiture);
		
		frame.add(new JLabel("Nombre de caisses"));
		this.nbCaisse = new JSpinner();
		frame.add(this.nbCaisse);
		
		frame.add(new JLabel("Kilométrage min"));
		this.kmMin = new JSpinner();
		frame.add(this.kmMin);
		
		frame.add(new JLabel("Kilométrage max"));
		this.kmMax = new JSpinner();
		frame.add(this.kmMax);
		
		frame.add(new JLabel("Vitesse moyenne"));
		this.vmoyVehicle = new JSpinner();
		frame.add(this.vmoyVehicle);
		
		this.fermer = new JButton("Fermer");
		frame.add(fermer);
		
		this.simuler = new JButton("Simuler");
		frame.add(simuler);
		
		frame.setVisible(true);
	}

}
