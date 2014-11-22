/*
-- * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package program;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import ludzie.Nauczyciel;
import ludzie.Uczen;

/**
 *
 * @author Mateusz
 */
public class Program {

    static Dziennik d = new Dziennik();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        

    }
    public static void wypiszBoole(boolean [] t) {
        for(int i = 0; i < t.length; i++) {
            System.out.println(i+": "+t[i]);
        }
    }
    
    public static void wypiszStringi(String[] napisy){
        for (int i =0; i < napisy.length ; i++){
            System.out.println(napisy[i]);
        }
    }
    
    public static void wypiszOceny (Ocena[] oceny) {
        for(Ocena o : oceny){
            System.out.println(o);
        }
    }
    
    public static void wypiszKlasy(Klasa[] klasa){
        for (Klasa k : klasa) {
            wypiszKlase(k);
        }
    }
    
    public static void wypiszKlase(Klasa k) {
        System.out.print("Klasa: ");
        System.out.println(k);
        
        if(d.getNauczyciel(k.getIdWychowawcy())!=null)
            System.out.println("Wychowawca: \n"+ d.getNauczyciel(k.getIdWychowawcy()));
    }
    private static void wypiszUczniow(Uczen[] tab){
        
        for(Uczen u: tab){
            System.out.println(u);
        }
    }
}

