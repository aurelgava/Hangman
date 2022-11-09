package com.example.demo;
import java.sql.*;
import java.util.ArrayList;

public class BazaProxy {
    private static Connection c;
    public static ArrayList<String> reci;
    public static void konektuj(){
        if (c==null){
            try {
                c = DriverManager.getConnection("jdbc:ucanaccess://src/main/resources/Baza/Hangman.accdb");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void procitajReci(){
        reci = new ArrayList<>();
        Statement s = null;
        try {
            s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Reci");
            while(rs.next()){
                reci.add(rs.getString("Field1"));
                System.out.println(rs.getString("Field1"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
