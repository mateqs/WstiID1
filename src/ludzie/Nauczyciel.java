/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ludzie;

import java.util.Date;

/**
 *
 * @author Mateusz
 */
public class Nauczyciel extends Osoba{

    private final int identyfikator;
    private static int kolejnyIdentyfikator = 1;
    
    
    public Nauczyciel (String Imie , String Nazwisko){
        super(Imie,Nazwisko);
    identyfikator = kolejnyIdentyfikator++;
    }
    
    public Nauczyciel(String Imie, String Nazwisko , Date DataUrodzenia , 
                        String Miejscowosc , String Ulica , int NrDomu ,
                        String KodPocztowy)
    {
        
    super(Imie, Nazwisko, DataUrodzenia, Miejscowosc,
            Ulica, NrDomu, KodPocztowy);
    identyfikator = kolejnyIdentyfikator++;
    }
    
    @Override
    public boolean setWszystkieDane (Date DataUrodzenia , 
                        String Miejscowosc , String Ulica , int NrDomu ,
                        String KodPocztowy ) {
        
        return  super.setWszystkieDane(DataUrodzenia, Miejscowosc, Ulica, NrDomu, KodPocztowy);
    }
    
    public int getIdentyfikator() {
        return identyfikator;
    }   
    
    public boolean isIdEqual(int idNauczyciela) {
        return this.identyfikator == idNauczyciela;
    }
    @Override
    public String toString(){
    
        
        StringBuilder napis = new StringBuilder(super.toString());
        napis.append("\nIdentyfikator pracownika: " + identyfikator+"\n");
        
        return napis.toString();
    
    }
    
}
