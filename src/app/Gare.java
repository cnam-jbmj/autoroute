package app;

import java.util.concurrent.LinkedBlockingQueue;

public class Gare extends LinkedBlockingQueue<Caisse>{

	private static final long serialVersionUID = 1L;

	public Gare(int n) {
        super(n);
        for(int i=0; i < n; i++){
            Caisse c = new Caisse(i + 1);
            try {
                put(c);
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
}
