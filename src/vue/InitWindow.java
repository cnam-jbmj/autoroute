package vue;

import java.awt.Dialog;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import app.FormAutoroute;
import controler.InitControler;

public class InitWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JSpinner nbVoiture;
	private JSpinner nbCaisse;
	private JSpinner kmMin;
	private JSpinner kmMax;
	private JSpinner vmoyVehicle;
	
	private JButton fermer;
	private JButton simuler;
	
	private InitControler controler;
	
	public InitWindow() {
		this.controler = new InitControler(this);
		
		this.setTitle("Initialisation simulation");
		this.setLayout(new GridLayout(6,2));
		this.setSize(600, 300);
		this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		this.add(new JLabel("Nombre de voitures"));
		this.nbVoiture = new JSpinner();
		this.add(this.nbVoiture);
		
		this.add(new JLabel("Nombre de caisses"));
		this.nbCaisse = new JSpinner();
		this.add(this.nbCaisse);
		
		this.add(new JLabel("Kilométrage min"));
		this.kmMin = new JSpinner();
		this.add(this.kmMin);
		
		this.add(new JLabel("Kilométrage max"));
		this.kmMax = new JSpinner();
		this.add(this.kmMax);
		
		this.add(new JLabel("Vitesse moyenne"));
		this.vmoyVehicle = new JSpinner();
		this.add(this.vmoyVehicle);
		
		this.fermer = new JButton("Fermer");
		fermer.addActionListener(controler);
		this.add(fermer);
		
		this.simuler = new JButton("Simuler");
		simuler.addActionListener(controler);
		this.add(simuler);
		
    	this.setVisible(true);
	}

	public FormAutoroute extractData() {
		int nbVoiture = (int)this.nbVoiture.getValue();
		int nbCaisse = (int)this.nbCaisse.getValue();
		int kmMin = (int)this.kmMin.getValue();
		int kmMax = (int)this.kmMax.getValue();
		int vmoyVehicle = (int)this.vmoyVehicle.getValue();
		
		FormAutoroute form = new FormAutoroute(nbVoiture, nbCaisse, kmMin, kmMax, vmoyVehicle);
		
		return form;
	}

	public InitControler getControler() {
		return controler;
	}
	
	
}
