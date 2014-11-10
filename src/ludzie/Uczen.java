package ludzie;

import java.util.Date;

/**
 *
 * @author Mateusz
 */
public class Uczen extends Osoba {
    
    private static int kolejnyNumerIdentyfikator =1;
    private final int identyfikator;
    
    public Uczen (String Imie , String Nazwisko){
        super(Imie,Nazwisko);
    identyfikator = kolejnyNumerIdentyfikator++;
    }
    
    public Uczen(String Imie, String Nazwisko , Date DataUrodzenia , 
                        String Miejscowosc , String Ulica , int NrDomu ,
                        String KodPocztowy)
    {
        
    super(Imie, Nazwisko, DataUrodzenia, Miejscowosc,
            Ulica, NrDomu, KodPocztowy);
    identyfikator = kolejnyNumerIdentyfikator++;
    }
    
    public int getId(){
        return identyfikator;
    }
    
    @Override
    public String toString() {
        
        StringBuilder napis = new StringBuilder(super.toString());
        napis.append("\nIdentyfikator Ucznia: " + identyfikator+"\n");
        return napis.toString();
    }
    
    
}
