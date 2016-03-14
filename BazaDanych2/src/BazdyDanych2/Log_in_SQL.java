/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazdyDanych2;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Robert_Waniewski
 */
public class Log_in_SQL {
    private String Adres; 
    private String Port;
    private String Nazwa_Bazy;
    private String Nazwa_użytkownika; 
    private String Haslo;
    private java.sql.Connection con;
    
    private static Log_in_SQL inst;
    private int saldo = 0;
    
    public Log_in_SQL() {
    
    }
    
    public static Log_in_SQL inst() {
        if(inst == null) {
            inst = new Log_in_SQL();
        }
        return inst;
        }
    
    
    public void zalogujSie (String Adres, String Port, String Nazwa_Bazy, String Nazwa_użytkownika, String Haslo){
            this.Adres = Adres;
            this.Port = Port;
            this.Nazwa_Bazy = Nazwa_Bazy;
            this.Nazwa_użytkownika = Nazwa_użytkownika;
            this.Haslo = Haslo;
        
            try{
                    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                    String baza = "jdbc:oracle:thin:@"+Adres+":"+Port+":"+Nazwa_Bazy; 
                    String user = Nazwa_użytkownika;
                    String pass = Haslo;
                    this.con  = DriverManager.getConnection(baza, user, pass);
                    
                 
                } 
            catch (Exception e) {
                    System.out.println("Bład logowania: "+ e.getMessage());
                } 
    
        }
    
    public java.sql.Connection GetCon (){
    
        return con;
        }
    
    
    public ResultSet executeQuery(String query) {
        ResultSet result = null;
        
        try{
            Statement stmt = con.createStatement();
            result = stmt.executeQuery(query);
            
            }
        catch(SQLException e){
                System.out.println("Błąd zapytania: " + e.getMessage());
        }
        
        
        return result;
    }
    
    
    public int executeUpdate(String query){
        
    int result = 0;
        
        try{
            Statement stmt = con.createStatement();
            result = stmt.executeUpdate(query);
            
            }
        catch(SQLException e){
                System.out.println("Błąd zapytania: " + e.getMessage());
        }
        
        
        return result;
    }
        
    public void executeQuerytoString(String query) {
        try{
            ResultSet result = executeQuery(query);
        
        ResultSetMetaData meta = result.getMetaData();

        for (int i = 0; i < meta.getColumnCount(); i++)
            System.out.print(meta.getColumnName(i + 1) + " ");
            System.out.println("\n");

            while (result.next()) {
                for (int i = 0; i < meta.getColumnCount(); i++)
                    System.out.print(result.getString(i + 1) + " ");
                System.out.println();
            }
        }
        catch (Exception e) {
                    System.out.println("Bład1: "+ e.getMessage());
                }
        
    }
    

}
