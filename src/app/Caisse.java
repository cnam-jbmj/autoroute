package app;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Caisse {
	
	private int numCaisse;
	private Voiture voiture;
	private int passage;
	private int attenteTotale;
	private Map<Voiture, Integer> stats;
	
	public Caisse(int numCaisse) {
		this.numCaisse = numCaisse;
		this.stats = new HashMap<>();
		this.attenteTotale = 0;
		this.passage = 0;
	}
	
    public void payer(){
        Random r = new Random();
        int n = 1000 + r.nextInt(10000);
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            
        }
        this.stats.put(this.voiture, n/1000);
        this.attenteTotale += n/1000;
        this.passage++;
    }

	public void use(Voiture voiture) {
		this.voiture = voiture;
	}
	
	public void leave() {
		this.voiture = null;
	}

	public int getNumCaisse() {
		return numCaisse;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public int getAttenteTotale() {
		return attenteTotale;
	}

	public int getPassage() {
		return passage;
	}

	public Map<Voiture, Integer> getStats() {
		return stats;
	}
}
