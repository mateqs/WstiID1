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
import ludzie.Nauczyciel;

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
    
    public void printRokSzkolny() {
        int koniecRoku = rokSzkolny + 1;
        System.out.println("Rocznik na którym obecnie wykonymane są operacje "
                           + "to rocznik " + this + ".");
        
        Calendar dzisiaj = new GregorianCalendar();
        if (dzisiaj.get(Calendar.YEAR) > rokSzkolny )
            System.out.print("Uwaga, operujesz na archiwalnym roczniku.");
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

        else {
            
            klasy.add(new Klasa(numerKlasy, znakKlasy, idWychowawcy));
            return true;
        }
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
    private Klasa getKlasa(int numerKlasy , char znakKlasy) {
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
    
    public void printKlasa(int numerKlasy , char znakKlasy, final Nauczyciel nauczyciel) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        k.printKlasa(nauczyciel);
    }
    
    public void setIdWychowawcy(int numerKlasy , char znakKlasy , int noweID) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        k.setWychowawca(noweID);
    }
    public void removeKlasa (int numerKlasy, char znakKlasy) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        klasy.remove(k);
    }
    
    public int getIloscKlas(){
        return klasy.size();
    }
    
    public Klasa getKlasa(int i) {
        return klasy.get(i);
    }
    
    //metody pracujące najdalej z uczniem
    
    public void addUczen(int numerKlasy , char znakKlasy ,String imie, String nazwisko) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        k.addUczen(imie, nazwisko);
    }
    
    public void setUczen(int numerKlasy, char znakKlasy ,int idUcznia, Date DataUrodzenia , 
                        String Miejscowosc , String Ulica , int NrDomu ,
                        String KodPocztowy) {
        
        Klasa k = this.getKlasa(numerKlasy, znakKlasy);
        
        k.setUczen(idUcznia, DataUrodzenia, Miejscowosc, Ulica, NrDomu, KodPocztowy);
    }
    
    public void printUczen (int numerKlasy, char znakKlasy ,int idUcznia){
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        k.printUczen(idUcznia);
    }
    
    public void printWszyscyUczniowie(int numerKlasy , char znakKlasy) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        k.printWszyscyUczniowie();
        
    }
    
    public void removeUczen (int numerKlasy, char znakKlasy ,int idUcznia) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        k.removeUczen(idUcznia);
        
    }
    
    //metody pracujące najdalej z przedmiotem
    
    public void addPrzedmiot(int numerKlasy, char znakKlasy ,
                            String NazwaPrzedmiotu, int idNauczyciela){
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        k.addPrzedmiot(NazwaPrzedmiotu, idNauczyciela);
    }
    
    public void printPrzedmioty( int numerKlasy , char znakKlasy) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        k.printPrzedmioty();
    }
    
    public void removePrzedmiot(int numerKlasy , char znakKlasy , String Nazwa ) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        k.removePrzemiot(Nazwa);
    }
    
    public void setIdNauczyciela (int numerKlasy , char znakKlasy , 
                                  String NazwaPrzedmiotu , int ID) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        k.setIdNauczyciela(NazwaPrzedmiotu, ID);
       
    }
    
    public void printUczniowieNaPrzedmiocie (int numerKlasy , char znakKlasy ,String Nazwa) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        k.printUczniowieNaPrzedmiocie(Nazwa);
    }
    
    public void removeUczenZPrzedmiotu (int numerKlasy , char znakKlasy ,String nazwa , int idUcznia) {
        
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        k.removeUczenZPrzedmiotu(nazwa, idUcznia);
        
    }
    //metody pracujące najdalej z ocenami
    
    public void addOcena (int numerKlasy , char znakKlasy ,
                    String Nazwa , double wartosc , int indeks) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        k.addOcena(Nazwa, wartosc, indeks);
    }
    
    public void printOcenyUcznia (int numerKlasy , char znakKlasy , 
            String Nazwa , int indeks) {
        Klasa k = getKlasa(numerKlasy, znakKlasy);
        
        k.printOcenyUcznia(Nazwa, indeks);
    }
}
