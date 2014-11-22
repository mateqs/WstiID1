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
    
    public boolean setNauczyciel(int idNauczyciela){
        if (idNauczyciela >0){
        this.idNauczyciela = idNauczyciela;
        return true;
        }
        else return false;
    }
    
    public boolean dodajUcznia ( Uczen uczen) {
        
        return Uczniowie.add(uczen);
    }
    
    @Override
    public String toString () {
        return nazwa;
    }
    
    public boolean addOcena(double wartosc , int indeks) {
        if(wartosc >= 0 && wartosc < 6 && indeks >= 0)
            return Oceny.add(new Ocena(wartosc, indeks));
        else
            return false;
    }
    
    public Ocena[] printOcenyUcznia ( int indeks){
    
        LinkedList<Ocena> list = new LinkedList();
        
        for (Ocena oce : Oceny) {
            if(oce.getIndeksUcznia() == indeks)
                list.add(oce);
        }
        
        Ocena[] o = new Ocena[list.size()];
        
        for(int i = 0; i < list.size() ; i++){
            o[i] = list.get(i);
        }
        
        return o;
    }
    
    public Uczen[] printUczniowie () {
        Uczen[] u = new Uczen[Uczniowie.size()];
        
        for (int i =0 ; i < Uczniowie.size() ; i++ ) {
            u[i] = Uczniowie.get(i);
        }
        return u;
    }
    
    public boolean removeUczenZPrzedmiotu (int IdUcznia) {
    
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
        if (znaleziono){
            Uczniowie.remove(i);
            return true;
        }
        else return false;
    }
}
