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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Koneksi;
import model.ImplTipeKamar;
import model.Kamar;
import model.TipeKamar;

/**
 *
 * @author usernames
 */
public class DAOTipeKamar implements ImplTipeKamar{

    Connection conn;
    
    final String select = "call showTipeKamar();";
    final String insert = "call insertTipeKamar(?,?,?);";
    final String update = "call updateTipeKamar(?,?,?);";
    final String delete = "call deleteTipeKamar(?);";
    final String getLastId = "call getLastId('tipeKamar');";
    
    public DAOTipeKamar(){
        this.conn = Koneksi.konek();
    }
    
    @Override
    public void insert(TipeKamar k) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(insert);
            stmt.setInt(1, k.getTipeId());
            stmt.setString(2, k.getTipeNama());
            stmt.setLong(3, k.getTipeHarga());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(TipeKamar k) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareCall(update);
            stmt.setInt(1, k.getTipeId());
            stmt.setString(2, k.getTipeNama());
            stmt.setLong(3, k.getTipeHarga());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(delete);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public int getLastKamarId() {
        int lastTipeKamarId = 0;
        PreparedStatement stmt = null;
        try {
//            stmt = connection.prepareStatement(getLastId); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(getLastId);
            while(rs.next()){                
                lastTipeKamarId = rs.getInt("max(id_tipe)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastTipeKamarId;
    }

    @Override
    public List<TipeKamar> getAll() {
        List<TipeKamar> tipeKamarList = null;
        
        try {
            tipeKamarList = new ArrayList<TipeKamar>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                TipeKamar k = new TipeKamar();
                k.setTipeId(rs.getInt("id_tipe"));
                k.setTipeNama(rs.getString("nama_tipe"));
                k.setTipeHarga(rs.getInt("harga_tipe"));                
                tipeKamarList.add(k);
            }
        } catch(SQLException ex){
            System.out.println(ex);
        } 
        return tipeKamarList;
    }

    @Override
    public List<TipeKamar> getCari(String tipeKamarId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
