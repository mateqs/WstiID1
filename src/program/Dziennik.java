/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package program;

import java.util.Date;
import java.util.LinkedList;
import ludzie.Nauczyciel;

/**
 *
 * @author Mateusz
 */
public class Dziennik {
    
    private LinkedList<RokSzkolny> WszystkieRoczniki = new LinkedList();
    private RokSzkolny ObecnyRocznik;
    private LinkedList<Nauczyciel> Nauczyciele = new LinkedList();
    
    Dziennik() {
        RokSzkolny rok = new RokSzkolny();
        WszystkieRoczniki.add(rok);
        ObecnyRocznik = rok;
    }

    public void zaladujPrzykladoweDane() {
        
        addNauczyciel(new Nauczyciel("Jan", "Kowalski"));
        addNauczyciel(new Nauczyciel("Jan", "Szafa"));
        addNauczyciel(new Nauczyciel("Alojzy", "Malinowski"));
        addNauczyciel(new Nauczyciel("Janko", "Muzykant"));
        addNauczyciel(new Nauczyciel("Krzesław", "Cokolwiek"));
        addNauczyciel(new Nauczyciel("Adam", "Cokolwiek"));
        ObecnyRocznik.zaladujPrzykladoweDane();
    }
    
    //metody pracujące najdalej z nauczycielem
    
    public void addNauczyciel(Nauczyciel nauczycielObj) {
        Nauczyciele.add(nauczycielObj);
    }
    
    public void addNauczyciel (String Imie , String Nazwisko) {
        
        Nauczyciele.add(new Nauczyciel(Imie, Nazwisko));
    }
    
    public void printNauczyciele (){
        for (Nauczyciel n : Nauczyciele ) {
            System.out.println(n.toString());
        }
    }
    
        //Zwraca true w momencie poprawnego ustawienia wszystkich danych
    public boolean setNauczycielWszystkieDane (int idNauczyciela, Date DataUrodzenia , 
                        String Miejscowosc , String Ulica , int NrDomu ,
                        String KodPocztowy ) {
        
//        boolean znaleziono = false;
//        int i =0;
        Nauczyciel n =getNauczyciel(idNauczyciela);
        
//        do {
//            
//            n = Nauczyciele.get(i);
//           
//            if(n.isIdEqual(idNauczyciela))
//                znaleziono = true;
//            else
//                ++i;
//           
//            
//        }while((!znaleziono ) && i < Nauczyciele.size() );
//        
//        if(znaleziono)
        return n.setWszystkieDane(DataUrodzenia, Miejscowosc, Ulica, NrDomu, KodPocztowy);
//        else
//        return false;
    }
    
    public void removeNauczyciel (int idNauczyciela) {
        
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
        
        if (znaleziono)
            Nauczyciele.remove(i);
        
    }
    
    private Nauczyciel getNauczyciel (int idNauczyciela) {
        
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
    
    public void printWszyscyWSzkole(){
        int id, numer;
        char znak;
        Klasa k;
        Nauczyciel n;
        
        
        for (int i=0 ; i<ObecnyRocznik.getIloscKlas() ; i++) {
            k = ObecnyRocznik.getKlasa(i);
            numer = k.getNumerKlasy();
            znak = k.getZnakKlasy();
            id = k.getIdWychowawcy();
            
            n =getNauczyciel(id);
            ObecnyRocznik.printKlasa(numer, znak, n);
            ObecnyRocznik.printWszyscyUczniowie(numer, znak);
        }
    }
    
    //Metody pracujące najdalej z rocznikiem / (przerobić na metody nieme)
    
    public void printRokSzkolny() {
        ObecnyRocznik.printRokSzkolny();
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
        
        System.out.println("Obecne operacje wykonywane będą na roczniku: " +
                ObecnyRocznik +".");
        return true;
        }
        else
            return false;
        
        
        
    }
    
    public void setObecnyRokSzkolnyNa(int rok ) {
        
        if( ObecnyRocznik.getRokSzkolny() != rok) {
        
            int i = 0;
            boolean znaleziono = false;
            RokSzkolny tymczasowy;

            do {

               tymczasowy = WszystkieRoczniki.get(i++);

               if( rok == tymczasowy.getRokSzkolny() ) {

                   znaleziono = true;

                   ObecnyRocznik = tymczasowy;
                   System.out.println("Obecne operacje wykonywane będą na roczniku: "
                   + tymczasowy + ".");

                }


            } while( i < WszystkieRoczniki.size() && znaleziono == false );


            if ( znaleziono == false )
                System.out.println("Mimo wszelkich starań nie udało się zmienić"
                        + " roku na: " + rok + "\nwszystkie kolejne operacje "
                        + "wykonane zostaną na roku " + ObecnyRocznik +".");
    
        }
        else
            System.out.println("Wywołano Obecny Rok.");

    }
    
    public void removeRokSzkolny (int rok) {
        
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
        
        if (znaleziono)
            WszystkieRoczniki.remove(i);
        
    }
    
    //metody pracujące najdalej z klasą
    
    public boolean addKlasa(int numerKlasy, char znakKlasy, int idWychowawcy) {

        if (ObecnyRocznik.addKlasa(numerKlasy, znakKlasy, idWychowawcy)) 
            return true;
        else 
            return false;
    }
   
    public void printKlasa (int numerKlasy, char znakKlasy) {
        
        int id= ObecnyRocznik.getIdWychowawcy(numerKlasy, znakKlasy);
        Nauczyciel n = this.getNauczyciel(id);
        ObecnyRocznik.printKlasa(numerKlasy, znakKlasy, n);
    }
    
    public void printWszystkieKlasy(){
        int id, numer;
        char znak;
        Klasa k;
        Nauczyciel n;
        
        
        for (int i=0 ; i<ObecnyRocznik.getIloscKlas() ; i++) {
            k = ObecnyRocznik.getKlasa(i);
            numer = k.getNumerKlasy();
            znak = k.getZnakKlasy();
            id = k.getIdWychowawcy();
            
            n =getNauczyciel(id);
            ObecnyRocznik.printKlasa(numer, znak, n);
            
        }
    }
            
    public void setIdWychowawcy (int numerKlasy , char znakKlasy , int noweID) {
        ObecnyRocznik.setIdWychowawcy( numerKlasy ,  znakKlasy ,  noweID);
    }
    
    public void removeKlasa (int numerKlasy , char znakKlasy) {
        ObecnyRocznik.removeKlasa(numerKlasy, znakKlasy);
    }
    
    //metody pracujące najdalej z przedmiotem
    
    public void addPrzedmiot (int numerKlasy, char znakKlasy ,
                             String NazwaPrzedmiotu, int idNauczyciela) {
        ObecnyRocznik.addPrzedmiot(numerKlasy, znakKlasy, NazwaPrzedmiotu, idNauczyciela);
        
    }
    
    public void printPrzedmioty(int numerKlasy , char znakKlasy) {
        ObecnyRocznik.printPrzedmioty(numerKlasy, znakKlasy);
    }
    
    public void removePrzedmiot(int numerKlasy , char znakKlasy , String Nazwa) {
        ObecnyRocznik.removePrzedmiot(numerKlasy, znakKlasy, Nazwa);
    }
       
    public void setIdWNauczyciela( int numerKlasy , char znakKlasy , 
                                  String NazwaPrzedmiotu , int ID) {
        ObecnyRocznik.setIdNauczyciela(numerKlasy, znakKlasy, NazwaPrzedmiotu, ID);
    }
    
    public void printUczniowieNaPrzedmiocie (int numerKlasy , char znakKlasy ,String Nazwa){
        ObecnyRocznik.printUczniowieNaPrzedmiocie(numerKlasy, znakKlasy, Nazwa);
    }
    
    //metody pracujące najdalej z uczniem
    public void addUczen (int numerKlasy , char znakKlasy ,String imie, String nazwisko){
        ObecnyRocznik.addUczen(numerKlasy, znakKlasy ,imie,nazwisko);
    }
    
    public void setUczen (int numerKlasy, char znakKlasy ,int idUcznia, 
                        Date DataUrodzenia , String Miejscowosc , 
                        String Ulica , int NrDomu ,
                        String KodPocztowy){
        
        
        ObecnyRocznik.setUczen(numerKlasy, znakKlasy, idUcznia, DataUrodzenia,
                Miejscowosc, Ulica, NrDomu, KodPocztowy);
 
    }
    
    public void printUczen (int numerKlasy, char znakKlasy ,int idUcznia) {
        ObecnyRocznik.printUczen(numerKlasy, znakKlasy, idUcznia);
    }
    
    public void printWszyscyUczniowieKlasy(int numerKlasy , char znakKlasy) {
        ObecnyRocznik.printWszyscyUczniowie(numerKlasy, znakKlasy);
    }
    
    public void removeUczen(int numerKlasy, char znakKlasy ,int idUcznia){
        ObecnyRocznik.removeUczen(numerKlasy, znakKlasy, idUcznia);
    }
    
    
    public void removeUczenZPrzedmiotu (int numerKlasy , char znakKlasy ,
            String nazwa , int idUcznia) {
        ObecnyRocznik.removeUczenZPrzedmiotu(numerKlasy, znakKlasy, nazwa, idUcznia);
    }
    
    //metody pracujące najdalej z oceną
    
    public void addOcena(int numerKlasy, char znakKlasy,
            String Nazwa, double wartosc, int indeks){
        
        ObecnyRocznik.addOcena(numerKlasy, znakKlasy, Nazwa, wartosc, indeks);
    }
    
     public void printOcenyUcznia (int numerKlasy , char znakKlasy , 
            String Nazwa , int indeks) {
         ObecnyRocznik.printOcenyUcznia(numerKlasy, znakKlasy, Nazwa, indeks);
     }
}
