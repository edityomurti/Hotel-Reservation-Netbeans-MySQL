/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOReservasi;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import model.ImplReservasi;
import model.Reservasi;
import model.TableModelReservasi;
import sirh.Guest;
import sirh.Operator;
import usu.widget.Label;
import usu.widget.Panel;
import usu.widget.TextArea;
import usu.widget.TextBox;

/**
 *
 * @author usernames
 */
public class ControllerReservasi {
    Operator operatorPanel;
    Guest guestPanel;
    ImplReservasi implReservasi;
    List<Reservasi> reservasiList;
    
    /** PANEL RESERVASI **/
    JLabel lblIdResUpdate;
    JLabel lblIdGuestResUpdate;
    JLabel lblIdRoomResUpdate;
    JLabel lblSpecialOrderResUpdate;
    JLabel lblCheckInResUpdate;
    JLabel lblCheckOutResUpdate;
    JLabel lblDiskonResUpdate;
    JLabel lblPriceResUpdate;
    JLabel lblTotPriceResUpdate;
    JComboBox cbStatusResUpdate;
    
    TextBox tbNoId;
    JLabel lblNumberOfDeluxe;
    JLabel lblNumberOfPresidential;
    TextArea taSpcRequest;
    Label lblCheckin;
    Label lblCheckout;
    JLabel lblTotalPrice;
    
    public ControllerReservasi (Operator operatorPanel){
        this.operatorPanel = operatorPanel;
        implReservasi = new DAOReservasi();
        
        lblIdResUpdate = operatorPanel.getLblIdResUpdate();
        lblIdGuestResUpdate = operatorPanel.getLblIdGuestResUpdate();
        lblSpecialOrderResUpdate = operatorPanel.getLblSpecialOrderResUpdate();
        lblCheckInResUpdate = operatorPanel.getLblCheckInResUpdate();
        lblCheckOutResUpdate = operatorPanel.getLblCheckOutResUpdate();
        lblDiskonResUpdate = operatorPanel.getLblDiskonResUpdate();
        lblPriceResUpdate = operatorPanel.getLblPriceResUpdate();
        lblTotPriceResUpdate = operatorPanel.getLblTotPriceResUpdate();
        cbStatusResUpdate = operatorPanel.getCbStatusResUpdate();
    }
    
    public ControllerReservasi (Guest guestPanel){
        this.guestPanel = guestPanel;
        implReservasi = new DAOReservasi();       
        
        tbNoId = guestPanel.getTxtIdTamu();
        lblNumberOfDeluxe = guestPanel.getTxtJmlRoomType1();
        lblNumberOfPresidential = guestPanel.getTxtJmlRoomType2();
        taSpcRequest = guestPanel.getTxtFasilitasTambahan();
        lblCheckin = guestPanel.getTxtTglMasuk();
        lblCheckout = guestPanel.getTxtTglKeluar();
        lblTotalPrice = guestPanel.getTxtTotalHarga();
    }
    
    public void isiTable() {
        reservasiList = implReservasi.getAll();
        TableModelReservasi tmr = new TableModelReservasi(reservasiList);
        operatorPanel.getResTableData().setModel(tmr);        
    }
    
//    public void insert(){
//        Reservasi reservasi = new Reservasi();
////        reservasi.setI
//    }
    public void updateReservasi(){
        Reservasi r = new Reservasi();
        r.setId_reservasi(Integer.parseInt(lblIdResUpdate.getText()));
        r.setId_tamu(Integer.parseInt(lblIdGuestResUpdate.getText()));
        r.setFasilitas_tambahan(lblSpecialOrderResUpdate.getText());
        r.setTgl_masuk(lblCheckInResUpdate.getText());
        r.setTgl_keluar(lblCheckOutResUpdate.getText());
        r.setDiskon(Integer.parseInt(lblDiskonResUpdate.getText().substring(0,lblDiskonResUpdate.getText().length()-2)));
        r.setHarga(Long.parseLong(lblPriceResUpdate.getText().substring(5)));
//        System.out.println(lblTotPriceResUpdate.getText(  ));
        r.setTotal_harga(Long.parseLong(lblTotPriceResUpdate.getText().substring(5)));
        if(cbStatusResUpdate.getSelectedIndex()==0){            
            r.setStatus("unconfirmed");
            System.out.println("status updated to unconfirmed");
        } else {
            r.setStatus("confirmed");            
            System.out.println("status updated to confirmed");
        }
        implReservasi.update(r);
    }
    
    public void insertReservasi(){
        Reservasi r = new Reservasi();
        r.setId_tamu(Integer.parseInt(tbNoId.getText()));
        r.setJmlTipeKamar1(Integer.parseInt(lblNumberOfDeluxe.getText()));
        r.setJmlTipeKamar2(Integer.parseInt(lblNumberOfPresidential.getText()));
        r.setTgl_masuk("2016-6-01"); //Beri formatting
        r.setTgl_keluar("2016-06-03");
        r.setHarga(Long.parseLong(lblTotalPrice.getText()));
        r.setTotal_harga(Long.parseLong(lblTotalPrice.getText()));
        implReservasi.insert(r);
    }
}


