/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package program;

import java.util.Date;
import java.util.LinkedList;
import ludzie.Nauczyciel;
import ludzie.Uczen;

/**
 *
 * @author Mateusz
 */
public class Dziennik {
    
    private LinkedList<RokSzkolny> WszystkieRoczniki = new LinkedList();
    private RokSzkolny ObecnyRocznik;
    private LinkedList<Nauczyciel> Nauczyciele = new LinkedList();
    private boolean przykladoweDane = false;
    
    Dziennik() {
        RokSzkolny rok = new RokSzkolny();
        WszystkieRoczniki.add(rok);
        ObecnyRocznik = rok;
        
    }

    public void zaladujPrzykladoweDane() {
        
        addNauczyciel(new Nauczyciel("Jan", "Kowalski"));
        addNauczyciel(new Nauczyciel("Jan", "Szafa"));
        addNauczyciel(new Nauczyciel("Alojzy", "Malinowski"));
        addNauczyciel(new Nauczyciel("Alojzy", "Malinowski"));
        addNauczyciel(new Nauczyciel("Janko", "Muzykant"));
        addNauczyciel(new Nauczyciel("Krzesław", "Muzykant"));
        addNauczyciel(new Nauczyciel("Adam", "Cokolwiek"));
        ObecnyRocznik.zaladujPrzykladoweDane();
        przykladoweDane = true;
    }

    public boolean isPrzykladoweDane() {
        return przykladoweDane;
    }
           
    public Przedmiot getPrzedmiot(Klasa klasa , String Nazwa){
        return ObecnyRocznik.getPrzedmiot(klasa, Nazwa);
    }
    
    //metody pracujące najdalej z nauczycielem
    
    public boolean addNauczyciel(Nauczyciel nauczycielObj) {
        
        Nauczyciele.add(nauczycielObj);
        return true;
    }
    
    public boolean addNauczyciel (String Imie , String Nazwisko) {

        Imie = Imie.toUpperCase();
        Nazwisko= Nazwisko.toUpperCase();
        
        Nauczyciele.add(new Nauczyciel(Imie, Nazwisko));
        return true;
    }
    
    public Nauczyciel[] printNauczyciele (){
        
        Nauczyciel[] TabNauczycieli = new Nauczyciel[Nauczyciele.size()];
        for (int i =0 ; i < Nauczyciele.size() ; i++ ) {
            TabNauczycieli[i] = Nauczyciele.get(i);
        }
            
        return TabNauczycieli; 
    }

    
        //Zwraca true w momencie poprawnego ustawienia wszystkich danych
    public boolean setNauczycielWszystkieDane (int idNauczyciela, Date DataUrodzenia , 
                        String Miejscowosc , String Ulica , int NrDomu ,
                        String KodPocztowy ) {
        

        Nauczyciel n =getNauczyciel(idNauczyciela);
        if ( n != null){
        return n.setWszystkieDane(DataUrodzenia, Miejscowosc, Ulica, NrDomu, KodPocztowy);
        }
        else return false;
    }
    
    public boolean removeNauczyciel (int idNauczyciela) {
  
        boolean znaleziono = false;
        int i =0;
        Nauczyciel n;
        
        do {
            
            n = Nauczyciele.get(i);
           
            if(n.isIdEqual(idNauczyciela))
                znaleziono = true;
            else
                ++i;
           
            
        }while((!znaleziono) && i < Nauczyciele.size() );
        
        if (znaleziono) {
            Nauczyciele.remove(i);
            return true;
        }
        else
            return false; 
                  
    }
    
    public Nauczyciel getNauczyciel (int idNauczyciela) {
        
        boolean znaleziono = false;
        int i =0;
        Nauczyciel n = null;
        
        while (!znaleziono  && i < Nauczyciele.size()) {
            
            n = Nauczyciele.get(i++);
           
            if(n.isIdEqual(idNauczyciela))
                znaleziono = true;
    
        }

        if (znaleziono)
            return n;
        else
            return null;
    }
    
    
    //Metody pracujące najdalej z rocznikiem 

    public Object[] WszystkieRocznikitoArray() {
        
        return WszystkieRoczniki.toArray();
    }
    
    public String printRokSzkolny() {
        
        return ObecnyRocznik.toString();
        
    };
    
    public boolean addRocznik(int rocznik ) {
        
        boolean znaleziono = false;
        int i =0;
        RokSzkolny r;
        RokSzkolny rok = new RokSzkolny(rocznik);
        
        do {
            
            r = WszystkieRoczniki.get(i);
           
            if(r.getRokSzkolny() == rocznik)
                znaleziono = true;
            else
                ++i;
           
            
        }while((!znaleziono) && i < WszystkieRoczniki.size() );
        
        if (!znaleziono){
            WszystkieRoczniki.add(rok);
        ObecnyRocznik = rok;  
        
        return true;
        }
        else
            return false;
        
        
        
    }
    
    public boolean setObecnyRokSzkolnyNa(int rok ) {

        if( ObecnyRocznik.getRokSzkolny() != rok) {
        
            int i = 0;
            boolean znaleziono = false;
            RokSzkolny tymczasowy;

            do {

               tymczasowy = WszystkieRoczniki.get(i++);

               if( rok == tymczasowy.getRokSzkolny() ) {

                   ObecnyRocznik = tymczasowy;
                  
                   return true;
                }


            } while( i < WszystkieRoczniki.size() && znaleziono == false );

             
        }
        
            return false;
        
       
    }
    
    public boolean setObecnyRokSzkolnyNa(Object rok ){
        
        if(rok instanceof String){
        String rokS = (String) rok;
        String napis = rokS.substring(0, 3);
        return this.setObecnyRokSzkolnyNa(Integer.parseInt(napis));
        }
        else return false;
    }
    
    public boolean removeRokSzkolny (int rok) {
        
            if(WszystkieRoczniki.size() > 1 ) {
            boolean znaleziono = false;
            int i =0;
            RokSzkolny r;

            do {

                r = WszystkieRoczniki.get(i);

                if(r.getRokSzkolny() == rok)
                    znaleziono = true;
                else
                    ++i;

            }while((!znaleziono) && i < WszystkieRoczniki.size() );


            if (znaleziono){
                WszystkieRoczniki.remove(i);
                return true;
            }
            else 
                return false;
            }
            
            else return false;
    }
    
    //metody pracujące najdalej z klasą
    
    public boolean addKlasa(int numerKlasy, char znakKlasy, int idWychowawcy, boolean przedmioty) {

        znakKlasy = Character.toUpperCase(znakKlasy);
        return ObecnyRocznik.addKlasa(numerKlasy, znakKlasy, idWychowawcy,przedmioty);
        
    }
   
    public Klasa printKlasa (int numerKlasy, char znakKlasy) {

        znakKlasy = Character.toUpperCase(znakKlasy);
        return ObecnyRocznik.getKlasa(numerKlasy, znakKlasy);
    }
                
    public Klasa[] printWszystkieKlasy(){
        return ObecnyRocznik.printWszystkieKlasy();
    }
    
    public boolean setIdWychowawcy (int numerKlasy , char znakKlasy , int noweID) {
    
        boolean b;
        znakKlasy = Character.toUpperCase(znakKlasy);
        b= ObecnyRocznik.setIdWychowawcy( numerKlasy ,  znakKlasy ,  noweID);
    
        return b;
    }
    
    public boolean removeKlasa (int numerKlasy , char znakKlasy) {
    znakKlasy = Character.toUpperCase(znakKlasy);
    return ObecnyRocznik.removeKlasa(numerKlasy, znakKlasy);
    }
    
    //metody pracujące najdalej z przedmiotem
    
    public boolean addPrzedmiot (int numerKlasy, char znakKlasy ,
                             String NazwaPrzedmiotu, int idNauczyciela) {

        znakKlasy = Character.toUpperCase(znakKlasy);
        NazwaPrzedmiotu=NazwaPrzedmiotu.toUpperCase();
        boolean b;
        b= ObecnyRocznik.addPrzedmiot(numerKlasy, znakKlasy, NazwaPrzedmiotu, idNauczyciela);
        return b;
    }
    
    public String[] printPrzedmioty(int numerKlasy , char znakKlasy) {
        znakKlasy = Character.toUpperCase(znakKlasy);
        return ObecnyRocznik.printPrzedmioty(numerKlasy, znakKlasy);
    }
    
    public boolean removePrzedmiot(int numerKlasy , char znakKlasy , String Nazwa) {
        znakKlasy = Character.toUpperCase(znakKlasy);
        Nazwa=Nazwa.toUpperCase();
        return ObecnyRocznik.removePrzedmiot(numerKlasy, znakKlasy, Nazwa);
    }
       
    public boolean setIdNauczyciela( int numerKlasy , char znakKlasy , 
                                  String NazwaPrzedmiotu , int ID) {
        znakKlasy = Character.toUpperCase(znakKlasy);
        NazwaPrzedmiotu=NazwaPrzedmiotu.toUpperCase();
        return ObecnyRocznik.setIdNauczyciela(numerKlasy, znakKlasy, NazwaPrzedmiotu, ID);
    }
    
    //metody pracujące najdalej z uczniem
    
    public Uczen[] printUczniowieNaPrzedmiocie (int numerKlasy , char znakKlasy ,String Nazwa){
        znakKlasy = Character.toUpperCase(znakKlasy);
        Nazwa=Nazwa.toUpperCase();
        return ObecnyRocznik.printUczniowieNaPrzedmiocie(numerKlasy, znakKlasy, Nazwa);
    }
    
    public boolean addUczen (int numerKlasy , char znakKlasy ,String imie, String nazwisko){

        znakKlasy=Character.toUpperCase(znakKlasy);
        return ObecnyRocznik.addUczen(numerKlasy, znakKlasy ,imie.toUpperCase(),nazwisko.toUpperCase());
    }
    
    public boolean setUczen (int numerKlasy, char znakKlasy ,int idUcznia, 
                        Date DataUrodzenia , String Miejscowosc , 
                        String Ulica , int NrDomu ,
                        String KodPocztowy){

        boolean b;
        znakKlasy=Character.toUpperCase(znakKlasy);
        b=ObecnyRocznik.setUczen(numerKlasy, znakKlasy, idUcznia, DataUrodzenia,
                Miejscowosc, Ulica, NrDomu, KodPocztowy);
 
        return b;
    }
    
    public Uczen printUczen (int numerKlasy, char znakKlasy ,int idUcznia) {
       
        Uczen u;
        znakKlasy=Character.toUpperCase(znakKlasy);
        u=ObecnyRocznik.printUczen(numerKlasy, znakKlasy, idUcznia);
        return u;
    }
    
    public Uczen[] printWszyscyUczniowieKlasy(int numerKlasy , char znakKlasy) {
        
        znakKlasy=Character.toUpperCase(znakKlasy);
        Uczen[] u = ObecnyRocznik.printWszyscyUczniowie(numerKlasy, znakKlasy);
        return u;
    }
    
    public boolean removeUczen(int numerKlasy, char znakKlasy ,int idUcznia){
        znakKlasy=Character.toUpperCase(znakKlasy);
        return ObecnyRocznik.removeUczen(numerKlasy, znakKlasy, idUcznia);
    }
    
    
    public boolean removeUczenZPrzedmiotu (int numerKlasy , char znakKlasy ,
            String nazwa , int idUcznia) {
        znakKlasy=Character.toUpperCase(znakKlasy);
        return ObecnyRocznik.removeUczenZPrzedmiotu(numerKlasy, znakKlasy, nazwa.toUpperCase(), idUcznia);
    }
    
    //metody pracujące najdalej z oceną
    
    public boolean addOcena(int numerKlasy, char znakKlasy,
            String Nazwa, double wartosc, int indeks){
        znakKlasy=Character.toUpperCase(znakKlasy);
       return ObecnyRocznik.addOcena(numerKlasy, znakKlasy, Nazwa.toUpperCase(), wartosc, indeks);
    }
    
     public Ocena[] printOcenyUcznia (int numerKlasy , char znakKlasy , 
            String Nazwa , int indeks) {

        znakKlasy=Character.toUpperCase(znakKlasy);
        return ObecnyRocznik.printOcenyUcznia(numerKlasy, znakKlasy, Nazwa.toUpperCase(), indeks);
     }
}
