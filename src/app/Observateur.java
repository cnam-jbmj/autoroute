package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Observateur extends TimerTask {
    private List<Voiture> fileAttente;
    
    public Observateur() {
    	this.fileAttente = new ArrayList<>();
    }
    
    public synchronized void increment(Voiture voiture) {
    	this.fileAttente.add(voiture);
    }

    public synchronized void decrement(Voiture voiture) {
    	for (Iterator<Voiture> iterator = fileAttente.iterator(); iterator.hasNext(); ) {
    		Voiture value = iterator.next();
    	    if (value.equals(voiture)) {
    	        iterator.remove();
    	    }
    	}
    }
    
    @Override
    public void run() {
        System.out.println(fileAttente.size());
    }

	public List<Voiture> getFileAttente() {
		return fileAttente;
	}
    
    
}
