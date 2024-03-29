package app;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class Voiture extends Thread {

    private int num;
    private Gare gare;
    private Observateur obs;
    private int parcours;
    private int vitesse;
    private int km_min;
    private int km_max;
    private CountDownLatch barriere;
    private Controleur controleur;
    private String immat;

    public Voiture(int num, int v, Gare gare, Observateur obs, int min, int max, CountDownLatch b, Controleur ctrl) {
        super();
        this.num = num;
        this.gare = gare;
        this.obs = obs;
        vitesse = v;
        km_min = min;
        km_max = max;
        barriere = b;
        controleur = ctrl;
        this.immat = generateImmat();
    }

    private String generateImmat() {
    	StringBuilder str = new StringBuilder();
    	Random rnd = new Random();
    	for(int i=0; i<2; i++) {
    		char c = (char)(rnd.nextInt(26) + 'A');
    		str.append(c);
    	}
    	str.append('-');
    	str.append(111 + rnd.nextInt(888));
    	str.append('-');
    	for(int i=0; i<2; i++) {
    		char c = (char)(rnd.nextInt(26) + 'A');
    		str.append(c);
    	}
    	
    	return str.toString();
	}

	@Override
    public void run() {
        try {
        	controleur.increment(this);
            barriere.countDown();//décrémenter le verrou  
            barriere.await();// attendre que toutes les autres voitures soient à ce même point
            entrer();
            rouler();
            sortir();
            controleur.decrement(this);//signaler au controleur qu'on est sortie pour décrémenter le nombre de vpoitures restantes dans l'autoroute
        } catch (InterruptedException ex) {
        }
    }

    private void entrer() {
        Random r = new Random();
        parcours = km_min + r.nextInt(km_max - km_min);//générer aléatoirement la longueur du parcours de cette voiture
        System.out.println("Voiture " + immat + " : entre");

    }

    private void rouler() {
        while (parcours > 0) {//tant que le parcours n'est pas fini
            try {
                parcours--;//avancer d'un cran
                Thread.sleep(vitesse);//à la vitesse choisie
            } catch (InterruptedException ex) {
                
            }
        }
    }

    private void sortir() {
        try {
            obs.increment(this); //signaler à l'observateur qu'on attend une caisse
            Caisse c = gare.take();//demander une caisse, dès qu'une caisse est libre elle sera affecter à cette voiture et elle sortira du pool de caisses libres
            c.use(this);
            c.payer();//payer
            System.out.println("Voiture " + num + " : sortie");
            c.leave();
            gare.put(c);//libérer la caisse en la remettant dans le pool de caisses libres
            obs.decrement(this);//signaler à l'observateur qu'on est sorti de la file d'attente d'une caisse
        } catch (InterruptedException ex) {
        }
    }
    
    public String toString() {
    	return num + " - " + immat;
    }
}
