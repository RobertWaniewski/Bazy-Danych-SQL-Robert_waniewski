/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazdyDanych2;

import java.util.Date;

/**
 *
 * @author Robert_Waniewski
 */
public class Person implements Comparable<Person>{
    String Imie;
    String Nazwisko;
    String Ulica;
    String Numer_Domu;
    String Miasto;
    String Kod_Pocztowy;
    String Telefon;
    
    
    public Person(String Imie, String Nazwisko, String Ulica, String Numer_Domu, String Miasto, String Kod_Pocztowy, String Telefon){
    this.Imie = Imie;
    this.Nazwisko = Nazwisko;
    this.Ulica = Ulica;
    this.Numer_Domu = Numer_Domu;
    this.Miasto = Miasto;
    this.Kod_Pocztowy = Kod_Pocztowy;
    this.Telefon = Telefon;
    
    }
    
   
    //@Override
    //public int compareTo(Object obj) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //Date Data_urodzenia = ((Person) obj).getData_urodzenia();
    //    return (this.Data_urodzenia.compareTo(Data_urodzenia));
    //
    //}
    
    public String toString() {
        return "Nazwisko: " +Nazwisko + " Imie: " + Imie+", Adres: " + Ulica + " " + Numer_Domu + ", " + Kod_Pocztowy + " " + Miasto + ", Tel: " + Telefon;
    }
    
    
    @Override
    public int compareTo(Person o) {
        int porownaneNazwiska = Nazwisko.compareTo(o.Nazwisko);
 
        if(porownaneNazwiska == 0) {
            return Imie.compareTo(o.Imie);
        }
        else {
            return porownaneNazwiska;
        }
    }
    //Wywołanie: Collections.sort(people)
    
}
