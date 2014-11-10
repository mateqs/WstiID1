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
public class Klasa {
    private final int numerKlasy; //np 2
    private final char znakKlasy; // np B
    private int idWychowawcy;
    private  LinkedList<Przedmiot> Przedmioty = new LinkedList();  
    private  LinkedList<Uczen> uczniowie =new LinkedList();
    private boolean domyslnePrzedmioty;
    
   
    Klasa(int NumerKlasy ,char ZnakKlasy , int IdWychowawcy ) {
        
        this.numerKlasy = NumerKlasy;
        this.znakKlasy = ZnakKlasy;
        this.idWychowawcy = IdWychowawcy;
        this.domyslnePrzedmioty = false;
    }
    
    Klasa(int NumerKlasy ,char ZnakKlasy ) {
        
        this.numerKlasy = NumerKlasy;
        this.znakKlasy = ZnakKlasy;
        this.domyslnePrzedmioty = false;
    }
    
    public void printKlasa(Nauczyciel n ) { 
        System.out.println("\nKlasa " + this +" "
                + ", Wychowawca : " + n);
    }
    
    public int getNumerKlasy() {
        return numerKlasy;
    }
    
    public char getZnakKlasy() {
        return znakKlasy;
    }
    
    @Override
    public boolean equals (Object otherObject) {
         if (this == otherObject) return true;
         
         if (otherObject == null) return false;
         
         if (this.getClass() != otherObject.getClass())
             return false;
         
         Klasa other = (Klasa) otherObject;
         
         return this.numerKlasy == other.numerKlasy &&
                 this.znakKlasy == other.znakKlasy;
     }
    
    @Override
    public String toString() {
        return numerKlasy + " " + znakKlasy;
    }
    
    public void setWychowawca (int IdWychowawcy) {
         
         this.idWychowawcy = IdWychowawcy;
     }
     
    public int getIdWychowawcy () {
        return idWychowawcy;
    }
    
    public void zaladujPrzykladoweDane() {
        
        this.addDomyslnePrzedmioty();
        
        addUczen("Mateusz", "Adamus");
        addUczen("Jakub", "Sławiński");
        addUczen("Patryk", "Chojecki");
        addUczen("Michał", "Bańkowski");
        addUczen("Damian", "Kawiecki");
        addUczen("Kamil", "Bieganowski");
        
        zapiszWszystkichNaWszystkiePrzedmioty();
        
        // wstawianie dowolnych ocen
        
        for ( Przedmiot p : Przedmioty) {
            for (double i = 1 ; i <=6 ; i +=0.5)
                p.addOcena( i, 1);
        }
        
    }
    
    // Metody do uczniów
            
    public void addUczen( String Imie , String Nazwisko){
         
        Uczen u = new Uczen(Imie, Nazwisko);
        
        uczniowie.add(u);
        
        zapiszUczniaNaWszystkiePrzedmioty(u);
         
        
     }
    
    public void setUczen (int idUcznia, Date DataUrodzenia , 
                        String Miejscowosc , String Ulica , int NrDomu ,
                        String KodPocztowy) {
        
        Uczen n = this.getUczen(idUcznia);
        
        n.setWszystkieDane(DataUrodzenia, Miejscowosc, Ulica, NrDomu, KodPocztowy);
        
    }
    
    public void printUczen (int idUcznia){
        Uczen u = getUczen(idUcznia);
        
        System.out.println(u);
    }
    
    public void printWszyscyUczniowie() {
        
        for (Uczen u : uczniowie) {
            System.out.println(u);
        }
    }
    
    public void removeUczen (int idUcznia){
        
        boolean znaleziono = false;
        Uczen swap = null;
        int i =0;
        
        while ( !znaleziono && i<uczniowie.size()  ) {
            
            swap = uczniowie.get(i);
            
            if (swap.getId() == idUcznia)
                znaleziono = true;
            else 
                i++;
        }
        if(znaleziono)
            uczniowie.remove(i);
        
    }
    
    private Uczen getUczen(int idUcznia) {
        boolean znaleziono = false;
        Uczen swap = null;
        int i =0;
        
        while ( !znaleziono && i<uczniowie.size()  ) {
            
            swap = uczniowie.get(i++);
            
            if (swap.getId() == idUcznia)
                znaleziono = true;
            
        }
        if (znaleziono)
            return swap;
        else
            return null;
    }
    
    // Metody pośrednie
    
    private void zapiszUczniaNaWszystkiePrzedmioty(Uczen uczen) {

        for (Przedmiot p : Przedmioty)
            p.dodajUcznia(uczen);

    }
    
    private void zapiszWszystkichNaWszystkiePrzedmioty() {

        Przedmiot przedmiot;
        Uczen uczen;

        for (int j = 0; j < uczniowie.size(); j++) {

            uczen = uczniowie.get(j);

            for (int i = 0; i < Przedmioty.size(); i++) {
                przedmiot = Przedmioty.get(i);
                przedmiot.dodajUcznia(uczen);
            }
        }
    }
    
    public void printUczniowieNaPrzedmiocie (String Nazwa) {
         boolean znaleziono = false;
        Przedmiot p = null;
        int i=0;
        
        while (!znaleziono && i< Przedmioty.size()) {
            p=Przedmioty.get(i);
            if (p.getNazwa().equals(Nazwa))
                znaleziono = true;
            else 
                i++;
        }
        
        if (znaleziono)
            p.printUczniowie();
    }
    
    public void removeUczenZPrzedmiotu (String Nazwa , int IdUcznia) {
    
        boolean znaleziono = false;
        int i =0;
        Przedmiot p=null;
        while ( !znaleziono && i < Przedmioty.size() ) {
            p=Przedmioty.get(i);
            
            if(p.getNazwa().equals(Nazwa))
                znaleziono = true;
            else
                i++;
            
        }
        if (znaleziono)
            p.removeUczenZPrzedmiotu(IdUcznia);
    }
    
    // Metody do Przedmiotów
        
    public void addDomyslnePrzedmioty(){
        if (domyslnePrzedmioty == false) {
            
            Przedmioty.add(new Przedmiot("Polski"));
            Przedmioty.add(new Przedmiot("Matematyka"));
            Przedmioty.add(new Przedmiot("Informatyka"));
            Przedmioty.add(new Przedmiot("Chemia"));
            Przedmioty.add(new Przedmiot("Język Obcy"));
            Przedmioty.add(new Przedmiot("Wychowanie Fizyczne"));
            Przedmioty.add(new Przedmiot("Religia"));
            Przedmioty.add(new Przedmiot("Technika"));
            Przedmioty.add(new Przedmiot("Historia"));
            Przedmioty.add(new Przedmiot("Geografia"));
            Przedmioty.add(new Przedmiot("Biologia"));
            Przedmioty.add(new Przedmiot("Muzyka"));
            Przedmioty.add(new Przedmiot("Fizyka"));
            Przedmioty.add(new Przedmiot("Plastyka"));
            domyslnePrzedmioty = true;
        }
       else
            System.out.println("Domyślne przedmioty mozna dodac tylko raz.");
    }
    
    public boolean addPrzedmiot(String NazwaPrzedmiotu, int idNauczyciela) {

        for (Przedmiot p : Przedmioty) {
            if (p.getNazwa().equals(NazwaPrzedmiotu)) {

                return false;
            }
        }
        Przedmioty.add(new Przedmiot(NazwaPrzedmiotu, idNauczyciela));
        return true;
    }
    
    public void setIdNauczyciela(String NazwaPrzedmiotu, int idNauczyciela) {
        
        boolean znaleziono = false;
        Przedmiot p =null;
        int i=0;
        
        while (!znaleziono && i < Przedmioty.size()) {
           
            p = Przedmioty.get(i++);
            if (p.getNazwa().equals(NazwaPrzedmiotu)) 
                znaleziono = true;
    
        }
        if(znaleziono)
            p.setNauczyciel(idNauczyciela);
        
    }
    
    public boolean addPrzedmiot(String NazwaPrzedmiotu) {

        for (Przedmiot p : Przedmioty) {
            if (p.getNazwa().equals(NazwaPrzedmiotu)) {
                return false;
            }
        }
        
        Przedmioty.add(new Przedmiot(NazwaPrzedmiotu));
        return true;
    }
    
    public void printPrzedmioty(){
        System.out.println("Przedmioty klasy " +numerKlasy+znakKlasy +" to:");
        
        for (Przedmiot p : Przedmioty) {
            System.out.println(p);
        }
    }
    
    public void removePrzemiot (String Nazwa) {
        
        boolean znaleziono = false;
        Przedmiot p;
        int i=0;
        
        while (!znaleziono && i< Przedmioty.size()) {
            p=Przedmioty.get(i);
            if (p.getNazwa().equals(Nazwa))
                znaleziono = true;
            else 
                i++;
        }
        
        if (znaleziono)
            Przedmioty.remove(i);
        
        
    }
    
    // metody do ocen
    
    public void addOcena (String Nazwa , double wartosc , int indeks) {
        
        boolean znaleziono = false;
        Przedmiot p=null;
        int i=0;
        
        while (!znaleziono && i< Przedmioty.size()) {
            p=Przedmioty.get(i);
            if (p.getNazwa().equals(Nazwa))
                znaleziono = true;
            else 
                i++;
        }
        
        if (znaleziono)
            p.addOcena(wartosc, indeks);
    }
    
    public void printOcenyUcznia (String Nazwa , int indeks) {
        
        boolean znaleziono = false;
        Przedmiot p=null;
        int i=0;
        
        while (!znaleziono && i< Przedmioty.size()) {
            p=Przedmioty.get(i);
            if (p.getNazwa().equals(Nazwa))
                znaleziono = true;
            else 
                i++;
        }
        
        if (znaleziono)
            p.printOcenyUcznia(indeks);
    }
}
