package controler;

import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;

import app.Voiture;
import vue.MainWindow;

public class MainControler {
	
	private MainWindow vue;

	public MainControler(MainWindow vue) {
		this.vue = vue;
	}
	
	public void updateListAutoroute(List<Voiture> listOfVoiture) {
		DefaultListModel<Voiture> lstOfVoiture = new DefaultListModel<>();
    	for (Iterator<Voiture> iterator = listOfVoiture.iterator(); iterator.hasNext(); ) {
    		Voiture value = iterator.next();
    	    lstOfVoiture.addElement(value);
    	}
		
		this.vue.getAutoroute().setModel(lstOfVoiture);
	}
	
	public void updateListFIleAttente(List<Voiture> listOfVoiture) {
		DefaultListModel<Voiture> lstOfVoiture = new DefaultListModel<>();
    	for (Iterator<Voiture> iterator = listOfVoiture.iterator(); iterator.hasNext(); ) {
    		Voiture value = iterator.next();
    	    lstOfVoiture.addElement(value);
    	}
		
		this.vue.getFileAttente().setModel(lstOfVoiture);
	}

}
