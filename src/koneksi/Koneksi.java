/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usernames
 */
public final class Koneksi {
    
    private static Connection con;
    private Statement stm;
    
    public Koneksi(){
        konek();
    }

    public static Connection konek() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net/sql6118656", "sql6118656", "7ZFCXGh3YF");            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }
    
    public void insert(String sql) {

        try {
            stm = con.createStatement();
            stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showMessageDialog(null, "please check your input again!");
        }
    }
}
