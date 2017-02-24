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
import koneksi.Koneksi;
import model.ImplReservasi;
import model.Reservasi;

/**
 *
 * @author usernames
 */
public class DAOReservasi implements ImplReservasi{

    Connection connection;
    final String insert = "CALL insertReservasi(?,?,?,?,?,?,?,?,?);";
    final String update = "CALL updateReservasi(?,?)";
    final String delete = "DELETE FROM reservasi where id_reservasi=?;";
    final String select = "CALL showReservasi();";
    final String cari = "SELECT * FROM reservasi where id_kamar like ?";

    public DAOReservasi() {
        this.connection = Koneksi.konek();
    }   
    
    
    @Override
    public void insert(Reservasi r) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(insert);
            stmt.setInt(1, r.getId_tamu());
//            stmt.setInt(3, b.getId_kamar());
            stmt.setInt(2, r.getJmlTipeKamar1());
            stmt.setInt(3, r.getJmlTipeKamar2());
            stmt.setString(4, r.getFasilitas_tambahan());
            stmt.setString(5, r.getTgl_masuk());
            stmt.setString(6, r.getTgl_keluar());
            stmt.setLong(7, r.getHarga());
            stmt.setInt(8, 0);
            stmt.setLong(9, r.getTotal_harga());
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
    public void update(Reservasi b) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(update);
            stmt.setInt(1, b.getId_reservasi());
            System.out.println("id yang akan dirubah = "+ String.valueOf(b.getId_reservasi()));
            System.out.println("status akan diupdate menjadi "+b.getStatus());
            stmt.setString(2, b.getStatus());
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
    public List<Reservasi> getAll() {
        List<Reservasi> reservasiList = null;
        
        try {
            reservasiList = new ArrayList<Reservasi>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Reservasi b = new Reservasi();
                b.setId_reservasi(rs.getInt("id_reservasi"));
                b.setId_tamu(rs.getInt("id_tamu"));
                b.setFasilitas_tambahan(rs.getString("fasilitas_tambahan"));
                b.setTgl_masuk(rs.getString("tgl_masuk"));
                b.setTgl_keluar(rs.getString("tgl_keluar"));
                b.setHarga(rs.getLong("total_harga"));
                b.setStatus(rs.getString("status"));
                reservasiList.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
//        System.out.println(String.valueOf(reservasiList.size()));
//        System.out.println("Reservasi data ok!");
        return reservasiList;
    }

    @Override
    public List<Reservasi> getCari(String kamarId) {
        List<Reservasi> reservasiList = null;
        
        try{
            reservasiList = new ArrayList<Reservasi>();
            PreparedStatement st = connection.prepareStatement(cari);
            st.setString(1, "%" + kamarId + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Reservasi b = new Reservasi();
                b.setId_reservasi(rs.getInt("id_reservasi"));
                b.setId_tamu(rs.getInt("id_tamu"));
                b.setFasilitas_tambahan(rs.getString("fasilitas_tambahan"));
                b.setTgl_masuk(rs.getString("tgl_masuk"));
                b.setTgl_keluar(rs.getString("tgl_keluar"));
                b.setHarga(rs.getLong("total_harga"));
                b.setStatus(rs.getString("status"));
                reservasiList.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
       return reservasiList;
    }    
}
