/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package program;

import java.util.LinkedList;
import ludzie.Uczen;

/**
 *
 * @author Mateusz
 */
public class Przedmiot {
    
    private final String nazwa;
    private LinkedList<Ocena> Oceny = new LinkedList();
    private LinkedList<Uczen> Uczniowie = new LinkedList();
    private int idNauczyciela;
    //private ListaObecnosci <- może kiedys 
    
    public Przedmiot ( String NazwaPrzedmiotu) {
        
        this.nazwa = NazwaPrzedmiotu;
       
    }
    public Przedmiot ( String NazwaPrzedmiotu , int IdNauczyciela) {
        
        this.nazwa = NazwaPrzedmiotu;
        this.idNauczyciela = IdNauczyciela;
    }
   
    public String getNazwa () {
        return nazwa;
    }
    
    public void setNauczyciel(int idNauczyciela){
        this.idNauczyciela = idNauczyciela;
    }
    
    public void dodajUcznia ( Uczen uczen) {
        
        Uczniowie.add(uczen);
    }
    
    @Override
    public String toString () {
        return nazwa;
    }
    
    public void addOcena(double wartosc , int indeks) {
        Oceny.add(new Ocena(wartosc, indeks));
    }
    
    public void printOcenyUcznia ( int indeks){
    
        for (Ocena o : Oceny) {
            if(o.getIndeksUcznia() == indeks)
                System.out.println(o);
        }
    }
    
    public void printUczniowie () {
        for (Uczen u: Uczniowie) {
            System.out.println(u);
        }
    }
    
    public void removeUczenZPrzedmiotu (int IdUcznia) {
    
        boolean znaleziono = false;
        int i =0;
        Uczen u=null;
        while ( !znaleziono && i < Uczniowie.size() ) {
            u=Uczniowie.get(i);
            
            if(u.getId() == IdUcznia)
                znaleziono = true;
            else
                i++;
            
        }
        if (znaleziono)
            Uczniowie.remove(i);
    }
}
