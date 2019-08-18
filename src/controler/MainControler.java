package controler;

import java.util.List;

import javax.swing.DefaultListModel;

import app.Voiture;
import vue.MainWindow;

public class MainControler {
	
	private MainWindow vue;

	public MainControler(MainWindow vue) {
		this.vue = vue;
	}
	
	public void updateListAutoroute(List<Voiture> ListOfVoiture) {
		DefaultListModel<Voiture> lstOfVoiture = new DefaultListModel<>();
		for(Voiture voiture : ListOfVoiture) {
			lstOfVoiture.addElement(voiture);
		}
		
		
		this.vue.getAutoroute().setModel(lstOfVoiture);
	}
	
	public void updateListFIleAttente(List<Voiture> ListOfVoiture) {
		DefaultListModel<Voiture> lstOfVoiture = new DefaultListModel<>();
		for(Voiture voiture : ListOfVoiture) {
			lstOfVoiture.addElement(voiture);
		}
		
		
		this.vue.getFileAttente().setModel(lstOfVoiture);
	}

}
