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
import model.ImplKamar;
import model.Kamar;

/**
 *
 * @author usernames
 */
public class DAOKamar implements ImplKamar{

    Connection connection;
//    final String insert = "INSERT INTO kamar (id_kamar, id_tipe, no_kamar, status) VALUES (?,?,?,?);";
//    final String update = "UPDATE kamar set id_kamar=?, id_tipe=?, no_kamar=?, no_kamar=? where id_kamar=?;";
//    final String delete = "DELETE FROM kamar where id_kamar=?;";
//    final String select = "SELECT * FROM kamar;";
//    final String getLastId = "SELECT max(id_kamar) from kamar;";
    final String cari = "SELECT * FROM kamar where id_kamar like ?";
    
    final String select = "CALL showKamar();";
    final String insert = "CALL insertKamar(?,?,?,?);";
    final String update = "CALL updateKamar(?,?,?,?);";
    final String delete = "CALL deleteKamar(?);";
    final String getLastId = "CALL getLastId('kamar');";

    public DAOKamar() {
        this.connection = Koneksi.konek();
    }
    
    
    
    @Override
    public void insert(Kamar b) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(insert);
            stmt.setInt(1, b.getId_kamar());
            switch(b.getTipe_kamar().toLowerCase()){
                case "deluxe"       : stmt.setInt(2, 1); 
                    break;
                case "presidential" : stmt.setInt(2, 2);
                    break;
            }
            stmt.setInt(3, b.getNo_kamar());
            switch(b.getStatus().toLowerCase()){
                case "unavailable"  : stmt.setInt(4, 0); 
                    break;
                case "available"    : stmt.setInt(4, 1);
                    break;
            }
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
    public void update(Kamar b) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareCall(update);
            stmt.setInt(1, b.getId_kamar());
            switch(b.getTipe_kamar().toLowerCase()){
                case "deluxe"       : stmt.setInt(2, 1); 
                    break;
                case "presidential" : stmt.setInt(2, 2);
                    break;
            }
            stmt.setInt(3, b.getNo_kamar());
            switch(b.getStatus().toLowerCase()){
                case "unavailable"  : stmt.setInt(4, 0); 
                    break;
                case "available"    : stmt.setInt(4, 1);
                    break;
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
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
            stmt = connection.prepareStatement(delete);
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
    public List<Kamar> getAll() {
        List<Kamar> kamarList = null;
        
        try {
            kamarList = new ArrayList<Kamar>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Kamar b = new Kamar();
                b.setId_kamar(rs.getInt("id_kamar"));
                switch (rs.getInt("id_tipe")) {
                    case 1: b.setTipe_kamar("deluxe");
                        break;
                    case 2: b.setTipe_kamar("presidential");
                        break;
                }
                b.setNo_kamar(rs.getInt("no_kamar"));
                switch (rs.getInt("status")) {
                    case 0: b.setStatus("unavailable");
                        break;
                    case 1: b.setStatus("available");
                        break;
                }
            kamarList.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return kamarList;
    }

    @Override
    public List<Kamar> getCari(String kamarId) {
        List<Kamar> kamarList = null;
        try{
            kamarList = new ArrayList<Kamar>();
            PreparedStatement st = connection.prepareStatement(cari);
            st.setString(1, "%" + kamarId + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Kamar b = new Kamar();
                b.setId_kamar(rs.getInt("id_kamar"));
                switch (rs.getInt("id_tipe")) {
                    case 1: b.setTipe_kamar("deluxe");
                        break;
                    case 2: b.setTipe_kamar("presidential");
                        break;
                }
                b.setNo_kamar(rs.getInt("no_kamar"));
                switch (rs.getInt("status")) {
                    case 0: b.setStatus("unavailable");
                        break;
                    case 1: b.setStatus("available");
                        break;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return kamarList;
    }

    @Override
    public int getLastKamarId() {
        int lastKamarId = 0;
        PreparedStatement stmt = null;
        try {
//            stmt = connection.prepareStatement(getLastId); 
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(getLastId);
            while(rs.next()){                
                lastKamarId = rs.getInt("max(id_kamar)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastKamarId;
    }    
}
