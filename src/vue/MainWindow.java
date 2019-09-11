package vue;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import app.Caisse;
import app.Gare;
import app.Voiture;
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
			caisse.setMaximumSize(new Dimension(250,100));
			caisse.setLayout(new GridLayout(2,1));
			
			JPanel info = new JPanel();
			info.setLayout(new FlowLayout());
			String numCaisse = String.valueOf(c.getNumCaisse());
			info.add(new JLabel(numCaisse));
			String imatVoiture = String.valueOf(c.getVoiture());
			JLabel immat = new JLabel(imatVoiture);
			display.put("immat", immat);
			info.add(immat);
			
			JPanel stat = new JPanel();
			stat.setLayout(new BoxLayout(stat, BoxLayout.X_AXIS));
			JLabel tempsTot = new JLabel("0 s");
			display.put("tempsTot", tempsTot);
			info.add(tempsTot);
			JLabel tempsMoy = new JLabel("0 s");
			display.put("tempsMoy", tempsMoy);
			info.add(tempsMoy);
			JLabel passage = new JLabel("0 vehicules");
			display.put("passage", passage);
			info.add(passage);
			
			caisse.add(info);
			caisse.add(stat);
			
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
