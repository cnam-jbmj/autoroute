package controler;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import app.Caisse;
import app.Voiture;
import vue.MainWindow;

public class MainControler {
	
	private MainWindow vue;

	public MainControler(MainWindow vue) {
		this.vue = vue;
	}
	
	public void updateListAutoroute(List<Voiture> listOfVoiture) {
		DefaultListModel<Voiture> lstOfVoiture = new DefaultListModel<>();
		for(Voiture voiture : listOfVoiture) {
			lstOfVoiture.addElement(voiture);
		}
		this.vue.getAutoroute().setModel(lstOfVoiture);
	}
	
	public void updateListFIleAttente(List<Voiture> listOfVoiture) {
		DefaultListModel<Voiture> lstOfVoiture = new DefaultListModel<>();
		for(Voiture voiture : listOfVoiture) {
			lstOfVoiture.addElement(voiture);
		}
		this.vue.getFileAttente().setModel(lstOfVoiture);
	}
	
	public void updateGare() {
		Map<Caisse, JLabel> caisseInfo = vue.getCaisseInfo();
		for(Entry<Caisse, JLabel> entry : caisseInfo.entrySet()) {
			String caisse = "";
			if(entry.getKey().getVoiture() == null) {
				caisse = "Libre";
			} else {
				caisse = entry.getKey().getVoiture().toString();
			}
			
			entry.getValue().setText(caisse);
		}
		
	}

}
