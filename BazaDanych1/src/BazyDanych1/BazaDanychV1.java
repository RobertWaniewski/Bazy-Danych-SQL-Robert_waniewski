
package BazyDanych1;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert_Waniewski
 */
public class BazaDanychV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
                try{
                    
                    Log_in_SQL.inst().zalogujSie("155.158.112.45", "1521", "oltpstud", "ziibd29", "cema1sewi");
                    
                    Log_in_SQL.inst().executeQuerytoString("SELECT FIRST_NAME FROM EMPLOYEES");

                }
                catch (Exception e) {
                    System.out.println("Bład1: "+ e.getMessage());
                } 
    
    }
    
    
    

    
}
