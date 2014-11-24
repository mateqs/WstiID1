package program;

import java.util.Date;
import java.util.Scanner;
import ludzie.Nauczyciel;
import ludzie.Uczen;

/**
 *
 * @author Mateusz
 */
public class Program {
    
    public static void main(String[] args) {

        Konsola konsola = new Konsola(true);

    }
    
    
}
    

class Konsola {
    
    
    public Konsola() {
    zacznij();
    }
    
    public Konsola(boolean przykladoweDane) {
        
        if ( przykladoweDane )
            Dziennik.getInstance().zaladujPrzykladoweDane();
        
        zacznij();
    }
    
    private void zacznij() {
        boolean dzialaj=true ;
        Scanner in = new Scanner(System.in);
        
        czyscEkran(7);
        
        System.out.println("Witaj w dzienniku.");
        
        
        do{
            
            System.out.println("Jakie działania chcesz wykonać?\n");
            
            System.out.println("1. Modyfikacja nauczycieli");
            System.out.println("2. Modyfikacja klas");
            System.out.println("3. Modyfikacja przedmiotów");
            System.out.println("4. Modyfikacja uczniow");
            System.out.println("q. Wyjście z programu\n");
            
            String argumenty = in.nextLine();
            czyscEkran();
            argumenty = argumenty.toLowerCase();
            char[] arg = new char [argumenty.length()];
            
            argumenty.getChars(0, argumenty.length(), arg, 0);
            
            for ( int i = 0 ; i < arg.length ; i++) {
                
                switch(arg[i]){
                    
                    case '1':
                        nauczyciele();
                        break;

                    case '2':
                        klasy();
                        break;
                    
                    case '3':
                        przedmioty();
                        break;

                    case '4':
                        uczniowie();
                        break;
                    
                    case 'q':
                        dzialaj = false;
                        i= arg.length;
                        break;
                    
                    default:
                        break;
                    
                }
                
            }
            
        }while(dzialaj == true);
    }
    
    private void nauczyciele() {
        
        Scanner in = new Scanner(System.in);
        boolean b;
        
        System.out.println("Jakie działania chcesz wykonać na nauczycielach?\n");
        
        
        System.out.println("1. Dodaj");
        System.out.println("2. Ustaw dodatkowe dane");
        System.out.println("3. Wyświetl nauczyciela");
        System.out.println("4. Wyświetl wszystkich nauczycieli");
        System.out.println("5. Usun");
        System.out.println("q. Powrót");
        
        String argumenty = in.nextLine();
        czyscEkran();
        argumenty = argumenty.toLowerCase();
        char[] arg = new char [argumenty.length()];
        argumenty.getChars(0, argumenty.length(), arg, 0);

        
            for ( int i = 0 ; i < arg.length ; i++) {
                
                switch(arg[i]){
                    
                    case '1':
                        
                        System.out.print("Podaj imie:");
                        String Imie = in.nextLine();
                        System.out.print("Podaj nazwisko:");
                        String Nazwisko = in.nextLine();
                        Nauczyciel nowy = new Nauczyciel(Imie, Nazwisko);
                        System.out.println("Jego identyfikator:" + nowy.getIdentyfikator());
                        b=Dziennik.getInstance().addNauczyciel(nowy);
                        printInfo(b);
                        break;

                    case '2':
                        System.out.println("Podaj identyfikator nauczyciela do edycji:");
                        int id = in.nextInt();
                        
                        System.out.print("Podaj dzien urodzenia (1-31):");
                        int dzien = in.nextInt();
                        System.out.print("Podaj miesiąc urodzenia (1-12):");
                        int miesiac = in.nextInt();
                        System.out.print("Podaj rok urodzenia:");
                        int rok =  in.nextInt();
                        
                        System.out.print("Podaj miejscowosc zamieszkania:");
                        String miejscowosc = in.next();
                        System.out.print("Podaj ulice:");
                        String ulica = in.next();
                        System.out.print("Podaj numer domu:");
                        int numer = in.nextInt();
                        System.out.print("Kod pocztowy:");
                        String kod = in.next();
                        
                        b =Dziennik.getInstance().
setNauczycielWszystkieDane(id,new Date(rok-1900, miesiac-1, dzien), miejscowosc, ulica, numer, kod);
                        printInfo(b);
                        break;
                        
                    case '3':
                        System.out.print("Podaj id nauczyciela do wyswietlenia:");
                        int idNauczyciela = in.nextInt();
                        Nauczyciel wyswietlany;
                        wyswietlany=Dziennik.getInstance().getNauczyciel(idNauczyciela);
                        System.out.println(wyswietlany);
                        break;
                        
                    case '4':
                        Nauczyciel[] lista;
                        lista=Dziennik.getInstance().printNauczyciele();
                        wypiszNauczyciele(lista);
                        break;
                    
                    case '5':
                        System.out.print("Podaj Id pracownika do usuniecia:");
                        int usuwany  = in.nextInt();
                        b=Dziennik.getInstance().removeNauczyciel(usuwany);
                        printInfo(b);
                        
                    case 'q':
                        break;
                        
                    default:
                        break;
                }
            }
        
        
        
    }
    
    private void klasy(){
            
        Scanner in = new Scanner(System.in);
        boolean b;
        int numerKlasy;
        char znakKlasy;
        int idWychowawcy;
                
        System.out.println("Jakie działania chcesz wykonać na klasach?\n");
        
        
        System.out.println("1. Dodaj");        
        System.out.println("2. Pokaz klase");
        System.out.println("3. Pokaz wszystkie klasy");
        System.out.println("4. Ustaw wychowawcę");
        System.out.println("5. Usuń klasę");
        System.out.println("q. Powrót");

        
        String argumenty = in.nextLine();
        czyscEkran();
        argumenty = argumenty.toLowerCase();
        char[] arg = new char [argumenty.length()];
        argumenty.getChars(0, argumenty.length(), arg, 0);

        
            for ( int i = 0 ; i < arg.length ; i++) {
                
                switch(arg[i]){
                    
                    case '1':
                        System.out.println("Tworzenie klasy");
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        System.out.print("Id wychowawcy:");
                        idWychowawcy = in.nextInt();
                        b=Dziennik.getInstance().addKlasa(numerKlasy, znakKlasy, idWychowawcy);
                        printInfo(b);
                        break;
                        
                    case '2':
                        System.out.println("Drukowanie klasy");
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        Klasa k = Dziennik.getInstance().printKlasa(numerKlasy, znakKlasy);
                        wypiszKlase(k);
                        break;

                    case '3':
                        System.out.println("Lista wszystkich klas:");
                        Klasa[] lista = Dziennik.getInstance().printWszystkieKlasy();
                        wypiszKlasy(lista);
                        break;
                                            
                    case '4':
                        System.out.println("Ustawianie wychowawcy");
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        System.out.print("Id wychowawcy:");
                        idWychowawcy = in.nextInt();
                        b=Dziennik.getInstance().setIdWychowawcy(numerKlasy, znakKlasy, idWychowawcy);
                        printInfo(b);
                        break;

                    case '5':
                        System.out.println("Usuwanie Klasy");
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        b=Dziennik.getInstance().removeKlasa(numerKlasy, znakKlasy);
                        printInfo(b);
                        break;
                        
                    case 'q':
                        break;
                        
                    default:
                        break;    
                }
            }
    }
    
    
    private void uczniowie(){
            
        //TODO dokończyć
        
        Scanner in = new Scanner(System.in);
        boolean b;
        Uczen nowy;
        int numerKlasy;
        char znakKlasy;
        int id;
        Uczen[] tabela;
        
        //TODO dziwinie to brzmi xD
        System.out.println("Jakie działania chcesz wykonać na uczniach?\n");
        
        
        System.out.println("1. Dodaj");
        System.out.println("2. Ustaw dodatkowe dane");
        System.out.println("3. Pokaz ucznia");
        System.out.println("4. Pokaz wszystkich uczniów w klasie");
        System.out.println("5. Wydrukuj wszystkich uczniów na przedmiocie");
        System.out.println("6. Usun");
        System.out.println("q. Powrót");

        
        String argumenty = in.nextLine();
        czyscEkran();
        argumenty = argumenty.toLowerCase();
        char[] arg = new char [argumenty.length()];
        argumenty.getChars(0, argumenty.length(), arg, 0);

        
            for ( int i = 0 ; i < arg.length ; i++) {
                
                switch(arg[i]){
                    
                    case '1':
                        System.out.println("Dodawanie ucznia");
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        System.out.print("Podaj imie:");
                        String Imie = in.next();
                        System.out.print("Podaj nazwisko:");
                        String Nazwisko = in.next();
                        b=Dziennik.getInstance().addUczen(numerKlasy, znakKlasy, Imie, Nazwisko);
                        printInfo(b);
                        break;
                        
                    case '2':
                        System.out.println("Uzupełnianie danych ucznia");
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        
                        System.out.println("Podaj identyfikator ucznia do edycji:");
                        id = in.nextInt();
                        
                        System.out.print("Podaj dzien urodzenia (1-31):");
                        int dzien = in.nextInt();
                        System.out.print("Podaj miesiąc urodzenia (1-12):");
                        int miesiac = in.nextInt();
                        System.out.print("Podaj rok urodzenia:");
                        int rok =  in.nextInt();
                        
                        System.out.print("Podaj miejscowosc zamieszkania:");
                        String miejscowosc = in.next();
                        System.out.print("Podaj ulice:");
                        String ulica = in.next();
                        System.out.print("Podaj numer domu:");
                        int numer = in.nextInt();
                        System.out.print("Kod pocztowy:");
                        String kod = in.next();
                        
                        b=Dziennik.getInstance()
.setUczen(numerKlasy, znakKlasy,id, new Date(rok-1900,miesiac-1,dzien), miejscowosc, ulica, numer, kod);
                        
                        printInfo(b);
                        break;
                    
                    case '3':
                        System.out.println("Wyswietlanie ucznia");
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        
                        System.out.println("Podaj identyfikator ucznia do wyswietlenia:");
                        id = in.nextInt();
                        
                        nowy = Dziennik.getInstance().printUczen(numerKlasy, znakKlasy, id);
                        System.out.println(nowy);
                        
                        break;
                    
                    case '4':
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        
                        tabela = Dziennik.getInstance().printWszyscyUczniowieKlasy(numerKlasy, znakKlasy);
                        wypiszUczniow(tabela);
                        
                        break;
                    
                    case '5':
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        System.out.print("Podaj nazwe przedmiotu:");
                        String przedmiot = in.next();
                        
                        tabela = Dziennik.getInstance().printUczniowieNaPrzedmiocie(numerKlasy, znakKlasy, przedmiot);
                        wypiszUczniow(tabela);
                        break;
                    
                    case '6':
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        System.out.print("Podaj id ucznia:");
                        id = in.nextInt();
                        b= Dziennik.getInstance().removeUczen(numerKlasy, znakKlasy, id);
                        printInfo(b);
                        break;

                    case 'q':
                        break;
                        
                    default:
                        break;    
                }
            }
    }
    
    private void przedmioty(){
            
        // TODO dokończyć 
        
        Scanner in = new Scanner(System.in);
        boolean b;
        int numerKlasy;
        char znakKlasy;
        Uczen[] tabelaUcz;
        String[] tabelaPrzed;
        String nazwa;
        int id;
        
        System.out.println("Jakie działania chcesz wykonać na przedmiotach?\n");
        
        
        System.out.println("1. Dodaj");
        System.out.println("2. Wydrukuj wszystkie przedmioty danej klasy");
        System.out.println("3. Wydrukuj wszystkich uczniów na przedmiocie"); // juz to jest
        System.out.println("4. Ustaw nauczyciela");
        System.out.println("5. Usun ucznia z przedmiotu");
        System.out.println("6. Usun przedmiot");
        System.out.println("q. Powrót");

        
        String argumenty = in.nextLine();
        czyscEkran();
        argumenty = argumenty.toLowerCase();
        char[] arg = new char [argumenty.length()];
        argumenty.getChars(0, argumenty.length(), arg, 0);

        
            for ( int i = 0 ; i < arg.length ; i++) {
                
                switch(arg[i]){
                    
                    case '1':
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        System.out.print("Podaj nazwe Przedmiotu:");
                        nazwa = in.next();
                        System.out.print("Podaj id nauczyciela:");
                        id = in.nextInt();
                        
                        b=Dziennik.getInstance().addPrzedmiot(numerKlasy, znakKlasy, nazwa, id);
                        printInfo(b);
                        
                        break;
                    
                    case '2':
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        tabelaPrzed=Dziennik.getInstance().printPrzedmioty(numerKlasy, znakKlasy);
                        wypiszStringi(tabelaPrzed);
                        break;
                        
                    case '3':

                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        System.out.print("Podaj nazwe przedmiotu:");
                        String przedmiot = in.next();
                        
                        tabelaUcz = Dziennik.getInstance().printUczniowieNaPrzedmiocie(numerKlasy, znakKlasy, przedmiot);
                        wypiszUczniow(tabelaUcz);                        
                        break;

                    case '4':
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        System.out.print("Podaj nazwe przedmiotu");
                        nazwa = in.next();
                        System.out.print("Podaj id nowego nauczyciela klasy:");
                        id= in.nextInt();
                        
                        b=Dziennik.getInstance().setIdNauczyciela(numerKlasy, znakKlasy, nazwa, id);
                        printInfo(b);
                        break;                        
                    
                    case '5':
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        System.out.print("Podaj nazwe przedmiotu");
                        nazwa = in.next();
                        System.out.print("Podaj id ucznia do usunięcia:");
                        id= in.nextInt();
                        
                        b=Dziennik.getInstance().removeUczenZPrzedmiotu(numerKlasy, znakKlasy, nazwa, id);
                        printInfo(b);
                        break;                        
                    
                    case '6':
                        System.out.print("Podaj numer klasy:");
                        numerKlasy = in.nextInt();
                        System.out.print("Podaj literę klasy:");
                        znakKlasy = in.next().charAt(0);
                        System.out.print("Podaj nazwe przedmiotu do usunięcia");
                        nazwa = in.next();
                        b=Dziennik.getInstance().removePrzedmiot(numerKlasy, znakKlasy, nazwa);
                        
                        break;                        
                    
                    case 'q':
                        
                        break;
                        
                    default:
                        break;    
                }
            }
    }
    
    /*
    -----------------------------------
             Metody pomocnicze
    ----------------------------------- 
    */
    private static void czyscEkran() {
        
        for (int i =0 ; i < 20 ; i++){
            System.out.println("");
        }
    }
    
    private void wypiszNauczyciele(Nauczyciel [] tab){
        
        System.out.println("Lista nauczycieli:");
        
        for (Nauczyciel n : tab) {
            System.out.println(n);
        }

    }
    
    private void czyscEkran(int ilosc) {
        
        for (int i =0 ; i < ilosc ; i++){
            System.out.println("");
        }
    }
 
    
    public void wypiszStringi(String[] napisy){
        for (int i =0; i < napisy.length ; i++){
            System.out.println(napisy[i]);
        }
    }
    public void wypiszOceny (Ocena[] oceny) {
        for(Ocena o : oceny){
            System.out.println(o);
        }
    }
    public void wypiszKlasy(Klasa[] klasa){
        for (Klasa k : klasa) {
            wypiszKlase(k);
        }
    }
    public void wypiszKlase(Klasa k) {
        System.out.print("Klasa: ");
        System.out.println(k);
        
        if(Dziennik.getInstance().getNauczyciel(k.getIdWychowawcy())!=null)
            System.out.println("Wychowawca: \n"+ Dziennik.getInstance().getNauczyciel(k.getIdWychowawcy()));
    }
    public void wypiszUczniow(Uczen[] tab){
        
        for(Uczen u: tab){
            System.out.println(u);
        }
    }
    
    public void printInfo( boolean wartosc){
        if( wartosc )
            System.out.println("Ostatnia operacja wykonana pomyślnie.\n\n");
        else
            System.out.println("Ostatnia operacja nie została wykonana\n\n");
    }
}