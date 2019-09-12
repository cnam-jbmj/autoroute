package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import app.Caisse;
import app.Gare;
import app.Voiture;
import controler.ButtonControler;
import controler.MainControler;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private int x = 800;
	private int y = 600;

	private MainControler controler;
	
	private JPanel center;
	
	private Map<Caisse, Map<String,JLabel>> caisseInfo;
	
	private JList<Voiture> autoroute;
	private JList<Voiture> fileAttente;

	public MainWindow() {
		this.controler = new MainControler(this);		
		
		this.setTitle("Simulation");
		BorderLayout mainPane = new BorderLayout();
		this.setLayout(mainPane);
		this.setSize(x, y);
		this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		
		//North
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		this.add(north, BorderLayout.NORTH);
		
		JLabel title = new JLabel("AUTOROUTE");
		north.add(title);
		
		
		//Center
		this.center = new JPanel();
		center.setLayout(new FlowLayout());
		this.add(center, BorderLayout.CENTER);
		this.caisseInfo = new HashMap<>();
		
		//South
		JPanel south = new JPanel();
		south.setAlignmentX(CENTER_ALIGNMENT);
		GridLayout southLayout = new GridLayout(1,2);
		south.setLayout(southLayout);
		this.add(south , BorderLayout.SOUTH);
		
		JPanel autorouteIHM = new JPanel();
		autorouteIHM.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		autorouteIHM.setLayout(new BoxLayout(autorouteIHM, BoxLayout.PAGE_AXIS));
		autorouteIHM.add(new JLabel("En circulation"));
		this.autoroute = new JList<>();
		JScrollPane autorouteList = new JScrollPane();
		autorouteList.setViewportView(autoroute);
		autorouteIHM.add(autorouteList);
		south.add(autorouteIHM);
		
		JPanel fileAttenteIHM = new JPanel();
		fileAttenteIHM.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		fileAttenteIHM.setLayout(new BoxLayout(fileAttenteIHM, BoxLayout.PAGE_AXIS));
		fileAttenteIHM.add(new JLabel("File Attente Caisse"));
		this.fileAttente = new JList<>();
		JScrollPane fileAttenteList = new JScrollPane();
		fileAttenteList.setViewportView(fileAttente);
		fileAttenteIHM.add(fileAttenteList);
		south.add(fileAttenteIHM);

		this.pack();
		this.setVisible(true);
	}
	
	public void updateCaisse(Gare g) {
		for(Caisse c : g) {
			Map <String, JLabel> display = new HashMap<>();
			
			JPanel caisse = new JPanel();
			caisse.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			caisse.setSize(new Dimension(400,100));
			GridLayout grid = new GridLayout(5,2);
			grid.setHgap(2);
			caisse.setLayout(grid);
			
			String numCaisse = String.valueOf(c.getNumCaisse());
			JLabel labelCaisse = new JLabel(numCaisse);
			labelCaisse.setBackground(Color.decode("#ffff99"));
			labelCaisse.setOpaque(true);
			labelCaisse.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			caisse.add(labelCaisse);
			
			String imatVoiture = String.valueOf(c.getVoiture());
			JLabel immat = new JLabel(imatVoiture);
			Font font = new Font("Courier", Font.BOLD,16);
			immat.setFont(font);
			immat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			display.put("immat", immat);
			caisse.add(immat);
			
			JLabel labelTT = new JLabel("<html>Temps <br>cumulé</html>");
			labelTT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			caisse.add(labelTT);
			JLabel tempsTot = new JLabel("0 s");
			tempsTot.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			display.put("tempsTot", tempsTot);
			caisse.add(tempsTot);
			
			JLabel labelTM = new JLabel("<html>Temps <br>moyen</html>");
			labelTM.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			caisse.add(labelTM);
			JLabel tempsMoy = new JLabel("0 s");
			tempsMoy.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			display.put("tempsMoy", tempsMoy);
			caisse.add(tempsMoy);
			
			JLabel labelPassage = new JLabel("Vehicules");
			labelPassage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			caisse.add(labelPassage);
			JLabel passage = new JLabel("0");
			passage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			display.put("passage", passage);
			caisse.add(passage);
			
			JButton stats = new JButton("Statistiques");
			stats.addActionListener(new ButtonControler(c));
			caisse.add(stats);
			
			this.caisseInfo.put(c, display);
			this.center.add(caisse);
			
			this.pack();
		}		
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

	public Map<Caisse, Map<String, JLabel>> getCaisseInfo() {
		return caisseInfo;
	}

	public void setCaisseInfo(Map<Caisse, Map<String, JLabel>> caisseInfo) {
		this.caisseInfo = caisseInfo;
	}
}
