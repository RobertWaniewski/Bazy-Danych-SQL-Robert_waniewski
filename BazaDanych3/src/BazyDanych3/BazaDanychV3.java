/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazyDanych3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Robert_Waniewski
 */
public class BazaDanychV3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
     String nazwa_tabeli = "big_test008";  
     
       Log_in_SQL.inst().zalogujSie("127.0.0.1", "1521", "xe", "hr", "hr"); // w celu ograniczenia wpływu połaczenia sieciowego tym razem korzystam z lokalnej bazy danych na komputerze
  
       Log_in_SQL.inst().executeUpdate
        ("CREATE TABLE "+nazwa_tabeli+" "
                + "(id NUMBER(19), "
                + "data NUMBER(19))");
 
        
        List<Person> Ksiazka = new ArrayList<Person>();
        for(int i = 0 ; i<3000 ; i++){
        Ksiazka.add(new Person(RandomString.LosowyTelefon(), RandomString.LosowyTelefon()));
        Log_in_SQL.inst().executeUpdate("INSERT INTO "+nazwa_tabeli+" VALUES ("
                + Ksiazka.get(i).ID +", " 
                + Ksiazka.get(i).Date +")");
        }
        
        System.out.println("Dane posortowane SQL: \n");
        long start_sql = System.currentTimeMillis();
       Log_in_SQL.inst().executeQuerytoString("select * from "+nazwa_tabeli+" order by id");
       long stop_sql = System.currentTimeMillis();
      System.out.println("\n \n Dane posortowane JAVA: \n");
      
        
        // for(Person person : Ksiazka) {
       //     System.out.println(person);
     //   }
 
     
        long start_java = System.currentTimeMillis();
        
        Collections.sort(Ksiazka);
        
        System.out.println("ID                   Data");
            
        for(Person person : Ksiazka) {
            System.out.println(person);
        }
        
        long stop_java = System.currentTimeMillis();
        
        
        System.out.println("\n\nCzas sortowania i wyświetlania SQL:"+(stop_sql-start_sql)+" ms");
        System.out.println("Czas sortowania i wyświetlania JAVA:"+(stop_java-start_java)+" ms");
    
        Log_in_SQL.inst().executeQuery("drop table "+nazwa_tabeli);
    }
    
    
}
