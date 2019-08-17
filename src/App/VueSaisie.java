package App;

import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class VueSaisie {

    public FormAutoroute lire() {
    	Scanner scanner = new Scanner(System.in);
    	
        System.out.print("Nombre de voitures : ");
        int nb_v = scanner.nextInt();
        System.out.print("Nombre de caisses : ");
        int nb_c = scanner.nextInt();
        System.out.print("Kilométrage min : ");
        int min = scanner.nextInt();
        System.out.print("Kilométrage max : ");
        int max = scanner.nextInt();
        System.out.print("Vitesse moyenne des véhicules : ");
        int vitesse = scanner.nextInt();
        
        scanner.close();
        
        FormAutoroute f = new FormAutoroute(nb_v, nb_c, min, max, vitesse);
        return f;
    }
}
