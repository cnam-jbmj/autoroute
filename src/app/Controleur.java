package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

public class Controleur extends Thread{

    private List<Voiture> voituresPresente;
    private Timer timer;

    public Controleur(Timer t) {
        this.voituresPresente = new ArrayList<>();
        timer = t;
    }
    
    public synchronized void increment(Voiture voiture) {
    	this.voituresPresente.add(voiture);
    }

    public synchronized void decrement(Voiture voiture) {
    	for (Iterator<Voiture> iterator = voituresPresente.iterator(); iterator.hasNext(); ) {
    		Voiture value = iterator.next();
    	    if (value.equals(voiture)) {
    	        iterator.remove();
    	    }
    	}

    }

    @Override
    public void run() {
        while (voituresPresente.size() != 0){
            System.out.print("");
        }
        timer.cancel();
    }

	public List<Voiture> getVoituresPresente() {
		return voituresPresente;
	}
}
