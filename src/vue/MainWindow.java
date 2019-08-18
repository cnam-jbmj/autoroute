package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import app.Voiture;
import controler.MainControler;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private MainControler controler;
	
	private JList<Voiture> autoroute;
	private JList<Voiture> fileAttente;

	public MainWindow() {
		this.controler = new MainControler(this);		
		
		this.setTitle("Simulation");
		BorderLayout mainPane = new BorderLayout();
		this.setLayout(mainPane);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		
		//North
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		this.add(north, BorderLayout.NORTH);
		
		JLabel title = new JLabel("AUTOROUTE");
		north.add(title);
		
		
		//Center
		//this.add(comp, BorderLayout.CENTER);
		
		//South
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		this.add(south , BorderLayout.SOUTH);
		
		this.autoroute = new JList<>();
		autoroute.setPreferredSize(new Dimension(150,200));
		south.add(autoroute);
		
		this.fileAttente = new JList<>();
		fileAttente.setPreferredSize(new Dimension(150,200));
		south.add(fileAttente);
		
		this.setVisible(true);
	}

	public MainControler getControler() {
		return controler;
	}
	
	public JList<Voiture> getAutoroute() {
		return autoroute;
	}

	public void setAutoroute(JList<Voiture> autoroute) {
		this.autoroute = autoroute;
	}

	public JList<Voiture> getFileAttente() {
		return fileAttente;
	}	
}
