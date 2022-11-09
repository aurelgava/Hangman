package com.example.demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class BazaProxy {
    private static Connection c;
    public static ArrayList<String> reci;
    public static void konektujSe(){
        if (c==null){
            try {
                c = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7556372","sql7556372","aUnmv8sUWc");  ;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void procitajReci(){
        reci = new ArrayList<>();
        if (c==null) konektujSe();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Reci");
            while(rs.next()){
                reci.add(rs.getString("Field1"));
                //System.out.println(rs.getString("Field1"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String nextRec() {
        if (reci==null) procitajReci();
        Random r = new Random();
        return reci.get(r.nextInt(reci.size()));
    }
}
