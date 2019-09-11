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
		Map<Caisse, Map<String, JLabel>> caisseInfo = vue.getCaisseInfo();
		for(Entry<Caisse, Map<String, JLabel>> caisse : caisseInfo.entrySet()) {
			for(Entry<String, JLabel> data : caisse.getValue().entrySet()) {
				if(data.getKey().equals("immat")) {
					String caisseString = "";
					if(caisse.getKey().getVoiture() == null) {
						caisseString = "Libre";
					} else {
						caisseString = caisse.getKey().getVoiture().toString();
					}
					data.getValue().setText(caisseString);
					
				} else if(data.getKey().equals("tempsTot")) {
					String tempsTot = String.valueOf(caisse.getKey().getAttenteTotale() + " s");
					data.getValue().setText(tempsTot);			
				} else if(data.getKey().equals("tempsMoy")) {
					if(caisse.getKey().getPassage() != 0) {
						String tempsMoy = String.valueOf(caisse.getKey().getAttenteTotale() / caisse.getKey().getPassage() + " s");
						data.getValue().setText(tempsMoy);
					}
				} else if(data.getKey().equals("passage")) {
					String passage = String.valueOf(caisse.getKey().getPassage());
					data.getValue().setText(passage);
				}
			}
		}
	}

}
