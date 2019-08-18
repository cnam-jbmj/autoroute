package app;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;

import vue.InitWindow;
import vue.MainWindow;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class Autoroute {

    private static Autoroute route = null;
    private static Set<Voiture> voitures = new HashSet<Voiture>();

    private Autoroute() {
    }

    public static Autoroute getInstance() {
        if (route == null) {
            route = new Autoroute();
        }
        return route;
    }

    public static void main(String[] args) {
        Autoroute auto = Autoroute.getInstance();
        auto.simuler2();
    }
    
    public void simuler2() {
    	MainWindow main = new MainWindow();
    	
    	InitWindow window = new InitWindow();
    	FormAutoroute f = window.getControler().getForm();
    	
    	Observateur obs = new Observateur();
        Gare gare = new Gare(f.getNb_caisses());
        
        //Lancer le timer
        Timer t = new Timer(true); //timer deamon
        t.schedule(obs, 1000, 1000);
        // Créer le controleur qui terminera le timer
        Controleur controleur = new Controleur(t);
        
        //création de la barrière de départ
        CountDownLatch barriere = new CountDownLatch(f.getNb_voitures());
        for (int i = 0; i < f.getNb_voitures(); i++) {
            Voiture v = new Voiture(i, f.getVitesse(), gare, obs, f.getKm_min(), f.getKm_max(), barriere, controleur);
            voitures.add(v);
            v.start();
        }
        
        controleur.start();
        while(controleur.getVoituresPresente().size() != 0) {
        	main.getControler().updateListAutoroute(controleur.getVoituresPresente());
        }
        
        System.out.print("Fin Main");

    }

    @Deprecated
    public void simuler() {
        VueSaisie vue1 = new VueSaisie();
        FormAutoroute f = vue1.lire();
        Observateur obs = new Observateur();
        Gare gare = new Gare(f.getNb_caisses());
        
        //Lancer le timer
        Timer t = new Timer(true); //timer deamon
        t.schedule(obs, 1000, 1000);
        // Créer le controleur qui terminera le timer
        Controleur controleur = new Controleur(t);
        controleur.start();
        
        //création de la barrière de départ
        CountDownLatch barriere = new CountDownLatch(f.getNb_voitures());
        for (int i = 0; i < f.getNb_voitures(); i++) {
            Voiture v = new Voiture(i, f.getVitesse(), gare, obs, f.getKm_min(), f.getKm_max(), barriere, controleur);
            voitures.add(v);
            v.start();
        }
        
        System.out.print("Fin Main");

    }
}
