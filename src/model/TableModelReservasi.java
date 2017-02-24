/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author usernames
 */
public class TableModelReservasi extends AbstractTableModel{

    List<Reservasi> reservasiList;

    public TableModelReservasi(List<Reservasi> reservasiList) {
        this.reservasiList = reservasiList;
    }   
    
    
    @Override
    public int getRowCount() {
        return reservasiList.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
//                System.out.println(String.valueOf(reservasiList.get(rowIndex).getId_reservasi())+ " is inserted. ");
                return reservasiList.get(rowIndex).getId_reservasi();
            case 1:
                return reservasiList.get(rowIndex).getId_tamu();
            case 2:
                return reservasiList.get(rowIndex).getFasilitas_tambahan();
            case 3:
                return reservasiList.get(rowIndex).getTgl_masuk();
            case 4:
                return reservasiList.get(rowIndex).getTgl_keluar();
            case 5:
                return reservasiList.get(rowIndex).getHarga();
            case 6:
                return reservasiList.get(rowIndex).getDiskon();
            case 7:
                return reservasiList.get(rowIndex).getTotal_harga();
            case 8:
                return reservasiList.get(rowIndex).getStatus();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Res. ID";
            case 1:
                return "Guest ID";
            case 2:
                return "Special Order";
            case 3:
                return "Check-In Date";
            case 4:
                return "Check-Out Date";
            case 5:
                return "Price";
            case 6:
                return "Disc.";
            case 7:
                return "Total Price";
            case 8:
                return "Status";
            default:
                return null;
        } //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
