/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazdyDanych2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Robert_Waniewski
 */
public class BazaDanychV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Log_in_SQL.inst().zalogujSie("adres_Serwera", "port", "nazwa_bazy", "login", "haslo");
       List<Person> Ksiazka = new ArrayList<Person>();
  
       Log_in_SQL.inst().executeUpdate
        ("CREATE TABLE Ksiazka_Adresowa_test001 "
                + "(id NUMBER(7)CONSTRAINT department_id_pk PRIMARY KEY, "
                + "nazwisko VARCHAR(13), "
                + "imie VARCHAR(9), "
                + "ulica VARCHAR(25),"
                + "nr_domu VARCHAR(2),"
                + "miejscowosc VARCHAR(15),"
                + "kod_pocztowy VARCHAR(6),"
                + "telefon VARCHAR(9))");
       System.out.println("1");
       Log_in_SQL.inst().executeQuerytoString("select * from Ksiazka_Adresowa_test001");
       System.out.println("2");
        
        for(int i = 0 ; i<30 ; i++){
        Ksiazka.add(new Person(RandomString.LosoweImie(), 
                                RandomString.LosoweNazwisko(), 
                                RandomString.LosowaUlica(), 
                                RandomString.LosowyNrDomu(), 
                                RandomString.LosowaMiejscowosc(), 
                                RandomString.LosowyKodPocztowy(), 
                                RandomString.LosowyTelefon()));
        Log_in_SQL.inst().executeUpdate("INSERT INTO Ksiazka_Adresowa_test001 VALUES ('"
                + i +"', '" 
                + Ksiazka.get(i).Nazwisko +"', '"
                + Ksiazka.get(i).Imie +"', '" 
                + Ksiazka.get(i).Ulica +"', '"
                + Ksiazka.get(i).Numer_Domu +"', '"
                + Ksiazka.get(i).Miasto +"', '"
                + Ksiazka.get(i).Kod_Pocztowy +"', '"
                + Ksiazka.get(i).Telefon +"')");
        }
        
        System.out.println("3");
       Log_in_SQL.inst().executeQuerytoString("select * from Ksiazka_Adresowa_test001");
      System.out.println("4 \n");
       
        
         for(Person person : Ksiazka) {
            System.out.println(person);
        }
 
        Collections.sort(Ksiazka);
 
        System.out.println("\nPosortowane: ");
        
        
        for(Person person : Ksiazka) {
            System.out.println(person);
        }
        
    }
    
}
