/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazyDanych3;

/**
 *
 * @author Robert_Waniewski
 */
import java.util.Random;

/**
 *
 * @author Robert_Waniewski
 */
public class RandomString {
    
  
    public static String LosowyTelefon (){
    String wyraz = "";
    int dodawana; // tu bedzie trzymana wylosowana wartosc int ktora nastepnie bedzie rzutowana na char i dodawana do stringa
    Random gen = new Random();
    
  
    
    for (long i = 0; 19>i; i++){
        dodawana = gen.nextInt(10);
        dodawana = dodawana+48;
        wyraz = wyraz + (char)dodawana;
    }
    return wyraz;}
    
    
    
    
    
    
    
    
    
}

