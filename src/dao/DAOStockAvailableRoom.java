/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Koneksi;
import model.ImplStockAvailableRoom;
import model.StockAvailableRoom;

/**
 *
 * @author GIGABYTE
 */
public class DAOStockAvailableRoom implements ImplStockAvailableRoom {

    Connection conn;
    
    final String show = "CALL showAvailableRoom(?,?);";
    
    public DAOStockAvailableRoom(){
        this.conn= Koneksi.konek();
    }
    
    @Override
    public StockAvailableRoom getStockAvailableRoom(String tglMasuk, String tglKeluar) {
        StockAvailableRoom s;        
        s = new StockAvailableRoom();
        PreparedStatement stmt = null;
        try{
            stmt = conn.prepareCall(show);
            stmt.setString(1, tglMasuk);
            stmt.setString(2, tglKeluar);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                s.setJmlStokType1(rs.getInt("jmlStokType1"));
                s.setJmlStokType2(rs.getInt("jmlStokType2"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStockAvailableRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return s;
    }
    
}
