
package program;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mateusz
 */
public class Ocena {
   
   private final double Ocena;
   private final Date data;
   private final int indeksUcznia;
       
   
    Ocena (double Ocena , int indeksUcznia) {
        this.Ocena = Ocena;
        data = new Date();
        this.indeksUcznia = indeksUcznia;
    }
   
    Ocena (double Ocena , int indeksUcznia , Date data) {
        this.Ocena = Ocena;
        this.data = data;
        this.indeksUcznia = indeksUcznia;
    }
    
    @Override    
    public String toString () {
        
        DateFormat df = new SimpleDateFormat("d MMMM yyyy  H:m");
        String d = df.format(data.getTime());
        
        return "Ocena: "+Double.toString(Ocena) +" \n" + d;
    }
    
    public double getOcena() {
        return Ocena;
    }
    
    public Date getData() {
        return data;
    }
    public int getIndeksUcznia() {
        return indeksUcznia;
    }
 }
