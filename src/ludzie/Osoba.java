
package ludzie;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import program.Ocena;

/**
 *
 * @author Mateusz
 */
public class Osoba {

    protected final String imie;
    protected final String nazwisko;
    protected Date dataUrodzenia ;
    protected String miejscowosc = null;
    protected String ulica = null;
    protected int nrDomu = -1;
    protected String kodPocztowy = null;
    
    public Osoba ( String Imie , String Nazwisko) {
        
        this.imie = Imie;
        this.nazwisko = Nazwisko;
    }
    public Osoba (String Imie, String Nazwisko , Date DataUrodzenia , 
                        String Miejscowosc , String Ulica , int NrDomu ,
                        String KodPocztowy) 
    {   
    this.imie = Imie;
    this.nazwisko = Nazwisko;
    this.dataUrodzenia = DataUrodzenia;
    this.miejscowosc = Miejscowosc ;
    this.ulica = Ulica;
    this.nrDomu = NrDomu;
    this.kodPocztowy = KodPocztowy;
    }
    
    /**
     * 
     * Nie trzeba podawać wszystkich wartośći
     * można wpisać null dla obiektów bądź -1 dla wartości
     * 
     * @return  boolean true jeżeli wszystkie dane są uzuełnione 
     * poprawnie, false w przeciwnym przypadku
     */
    public boolean setWszystkieDane (Date DataUrodzenia , 
                        String Miejscowosc , String Ulica , int NrDomu ,
                        String KodPocztowy ) {
    
    if (DataUrodzenia != null)
        this.dataUrodzenia = DataUrodzenia;
    if ( Miejscowosc != null)
        this.miejscowosc = Miejscowosc ;
    if (Ulica != null)
        this.ulica = Ulica;
    if (NrDomu != -1)
        this.nrDomu = NrDomu;
    if ( KodPocztowy != null)
        this.kodPocztowy = KodPocztowy;

    
    return this.czyWszystkieDane();
    }
    
    
    
    public boolean czyWszystkieDane () {
        if (dataUrodzenia == null)
            return false;
        else if (miejscowosc == null)
            return false;
        else if (ulica == null)
            return false;
        else if (nrDomu==-1)
            return false;
        else if (kodPocztowy==null)
            return false;
        else 
            return true;
        
    }
    @Override
    public String toString() {
        
        if(czyWszystkieDane()) {
            
        DateFormat df = new SimpleDateFormat("d MMMM yyyy  H-m");
        String data = df.format(dataUrodzenia.getTime());
            
        StringBuilder napis = new  StringBuilder (
                "Imię: " + imie +
                "\nNazwisko: " + nazwisko +
                "\nData urodzenia: " + data +
                "\nZamieszkały(/a): " + miejscowosc +
                 " ul."+ ulica + " " + nrDomu + " " + kodPocztowy 
        );
        return napis.toString();
      }
        else 
            return imie +" " + nazwisko;
    }
    
  
}