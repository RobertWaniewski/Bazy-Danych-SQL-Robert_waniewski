/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazyDanych3;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Robert_Waniewski
 */
public class Person implements Comparable<Person>{
 
    BigInteger ID;
    BigInteger Date;
    
    
    
    public Person(String sID, String sDate){
    
    this.ID = new BigInteger(sID);
     this.Date = new BigInteger(sDate);
    }
    
   
    //@Override
    //public int compareTo(Object obj) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //Date Data_urodzenia = ((Person) obj).getData_urodzenia();
    //    return (this.Data_urodzenia.compareTo(Data_urodzenia));
    //
    //}
    
    public String toString() {
        return  ID + " " + Date;
    }
    
    
    @Override
    public int compareTo(Person o) {
        int porownaneNazwiska = ID.compareTo(o.ID);
 
        if(porownaneNazwiska == 0) {
            return Date.compareTo(o.Date);
        }
        else {
            return porownaneNazwiska;
        }
        
    }
    //Wywołanie: Collections.sort(people)
    
}
