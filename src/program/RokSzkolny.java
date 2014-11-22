/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package program;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import ludzie.Uczen;

/**
 *
 * @author Mateusz
 */
public class RokSzkolny {
    
    private final int rokSzkolny; // np. 2014 
    private  LinkedList<Klasa> klasy = new LinkedList();
    
    public RokSzkolny() {
        Calendar dzisiaj = new GregorianCalendar();
        rokSzkolny = dzisiaj.get(Calendar.YEAR);
    }
    
    public RokSzkolny(int RokSzkolny ) {
        this.rokSzkolny = RokSzkolny;
    }
    
    public int getRokSzkolny() {
    
        return rokSzkolny;
    
    }
    
    @Override
    public String toString() {
        int kolejny = rokSzkolny +1;
        
        return rokSzkolny + " / " + kolejny;
    }
      
    public void zaladujPrzykladoweDane() {
        
       klasy.add(new Klasa(1, 'A', 1));
       klasy.add(new Klasa(1, 'B', 2));
       klasy.add(new Klasa(2, 'A', 3));
       klasy.add(new Klasa(2, 'B', 4));
       klasy.add(new Klasa(3, 'A', 5));
       klasy.add(new Klasa(3, 'B', 6));
       
       for (int i = 0 ; i < 6 ; i++) {
           klasy.get(i).zaladujPrzykladoweDane();
       }
      
    }
    //metody pracujące najdalej z klasą
    
    public boolean addKlasa(int numerKlasy, char znakKlasy, int idWychowawcy) {

        if (czyKlasaIstnieje(numerKlasy, znakKlasy)) 
            return false;
        for ( Klasa k: klasy){
            if(idWychowawcy == k.getIdWychowawcy())
                return false;
        }    
        
        return klasy.add(new Klasa(numerKlasy, znakKlasy, idWychowawcy));
        
    }
    
    private boolean czyKlasaIstnieje(int numerKlasy, char znakKlasy) {

        Klasa wzor = new Klasa(numerKlasy, znakKlasy);
        Klasa swap;
       
        
        for (int i = 0 ; i < klasy.size() ; i++) {
         
            swap = klasy.get(i);
            
            if(swap.equals(wzor))
                return true;
        }

        return false;

    }
   
    public int getIdWychowawcy(int numerKlasy , char znakKlasy) {
        
        Klasa k = this.getKlasa(numerKlasy, znakKlasy);
        
        if (k != null)
            return k.getIdWychowawcy();
        else
            return 0;
    }
    
    /**
    * @return Klasa Metoda zwraca klasę jezeli taka istnieje,
    * w przeciwnym wypadku zwaraca null
    *
    */
    public Klasa getKlasa(int numerKlasy , char znakKlasy) {
        boolean znaleziono = false;
        Klasa swap = null;
        Klasa wzor = new Klasa(numerKlasy, znakKlasy);
        int i =0;
        
        while ( !znaleziono && i<klasy.size()  ) {
            
            swap = klasy.get(i++);
            
            if (swap.equals(wzor))
                znaleziono = true;
             
        }
        if(znaleziono)
            return swap;
        else
            return null;
    }
   
    
    public boolean setIdWychowawcy(int numerKlasy , char znakKlasy , int noweID) {
        
        for ( Klasa k: klasy){
            if(noweID == k.getIdWychowawcy())
                return false;
        }
        
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        return k.setWychowawca(noweID);
    }
    public boolean removeKlasa (int numerKlasy, char znakKlasy) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        if(k != null){
            klasy.remove(k);
            return true;
        }
        else return false;
    }
    
    public Klasa[] printWszystkieKlasy() {
        
        Klasa [] k = new Klasa[klasy.size()];
        
        for (int i=0 ; i<klasy.size(); i++){
            k[i]=klasy.get(i);
        }
        
        return k;
    }
    
    public int getIloscKlas(){
        return klasy.size();
    }
    
    public Klasa getKlasa(int i) {
        return klasy.get(i);
    }
    
    //metody pracujące najdalej z uczniem
    
    public boolean addUczen(int numerKlasy , char znakKlasy ,String imie, String nazwisko) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        if(k!=null)
            return k.addUczen(imie, nazwisko);
        else return false;
    }
    
    public boolean setUczen(int numerKlasy, char znakKlasy ,int idUcznia, Date DataUrodzenia , 
                        String Miejscowosc , String Ulica , int NrDomu ,
                        String KodPocztowy) {
        
        Klasa k = this.getKlasa(numerKlasy, znakKlasy);
        boolean b;
        
        b=k.setUczen(idUcznia, DataUrodzenia, Miejscowosc, Ulica, NrDomu, KodPocztowy);
    
       return b;
    }
    
    public Uczen printUczen (int numerKlasy, char znakKlasy ,int idUcznia){
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        Uczen u = k.getUczen(idUcznia);
        return u;
    }
    
    public Uczen[]  printWszyscyUczniowie(int numerKlasy , char znakKlasy) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        Uczen[] u = k.printWszyscyUczniowie();
        return u;
    }
    
    public boolean removeUczen (int numerKlasy, char znakKlasy ,int idUcznia) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        return  k.removeUczen(idUcznia);
        
    }
    
    //metody pracujące najdalej z przedmiotem
    
    public boolean addPrzedmiot(int numerKlasy, char znakKlasy ,
                            String NazwaPrzedmiotu, int idNauczyciela){
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        k.addPrzedmiot(NazwaPrzedmiotu, idNauczyciela);
        return true;
    }
    
    public String [] printPrzedmioty( int numerKlasy , char znakKlasy) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        String[] s =k.printPrzedmioty();
        
        return s;
    }
    
    public boolean removePrzedmiot(int numerKlasy , char znakKlasy , String Nazwa ) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        if (k != null){
            k.removePrzemiot(Nazwa);
            return true;
        }
        else 
            return false;
    }
    
    public boolean setIdNauczyciela (int numerKlasy , char znakKlasy , 
                                  String NazwaPrzedmiotu , int ID) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        if (k!=null)
             return k.setIdNauczyciela(NazwaPrzedmiotu, ID);
   
        else return false;
    }
    
    public Uczen[] printUczniowieNaPrzedmiocie (int numerKlasy , char znakKlasy ,String Nazwa) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        return k.printUczniowieNaPrzedmiocie(Nazwa);
    }
    
    public boolean removeUczenZPrzedmiotu (int numerKlasy , char znakKlasy ,String nazwa , int idUcznia) {
        
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        return k.removeUczenZPrzedmiotu(nazwa, idUcznia);
        
    }
    //metody pracujące najdalej z ocenami
    
    public boolean addOcena (int numerKlasy , char znakKlasy ,
                    String Nazwa , double wartosc , int indeks) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        return k.addOcena(Nazwa, wartosc, indeks);
    }
    
    public Ocena[] printOcenyUcznia (int numerKlasy , char znakKlasy , 
            String Nazwa , int indeks) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        return k.printOcenyUcznia(Nazwa, indeks);
    }
}
