package app;

import java.util.Random;

public class Caisse {
	
	private int numCaisse;
	private Voiture voiture;
	
	public Caisse(int numCaisse) {
		this.numCaisse = numCaisse;
	}
	
    public void payer(){
        Random r = new Random();
        int n = 1000 + r.nextInt(10000);
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            
        }
    }

	public void use(Voiture voiture) {
		this.voiture = voiture;
	}
	
	public void leave() {
		this.voiture = null;
	}
}
