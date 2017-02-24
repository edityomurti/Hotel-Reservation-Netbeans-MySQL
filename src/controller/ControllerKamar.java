/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOKamar;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import model.ImplKamar;
import model.Kamar;
import model.TableModelKamar;
import sirh.Operator;

/**
 *
 * @author usernames
 */
public class ControllerKamar {
    Operator operatorPanel;
    ImplKamar implKamar;
    List<Kamar> kamarList;
    JTable tableKamar;
    
    JSpinner spIdKamarAdd;
    JSpinner spNoKamarAdd;
    JComboBox cbTipeKamarAdd;
    JComboBox cbStatusKamarAdd;
    
    JSpinner spIdKamarUpdate;
    JSpinner spNoKamarUpdate;
    JComboBox cbTipeKamarUpdate;
    JComboBox cbStatusKamarUpdate;

    public ControllerKamar(Operator operatorPanel) {
        this.operatorPanel = operatorPanel;
        implKamar = new DAOKamar();      
        tableKamar = operatorPanel.getKamarTableData();
        spIdKamarAdd = operatorPanel.getSpIdKamarAdd();
        spNoKamarAdd = operatorPanel.getSpNoKamarAdd();
        cbTipeKamarAdd = operatorPanel.getCbTipeKamarAdd();
        cbStatusKamarAdd = operatorPanel.getCbStatusKamarAdd();
    }
    
    public void isiTable(){
        kamarList = implKamar.getAll();
        TableModelKamar tmk = new TableModelKamar(kamarList);
        tableKamar.setModel(tmk);        
    }
    
    public int getLastKamarId(){
        int lastKamarId = implKamar.getLastKamarId();
        return lastKamarId;
    }
    
    public void insertKamar(){
        Kamar k = new Kamar();
        k.setId_kamar((int) spIdKamarAdd.getValue());
        k.setNo_kamar((int) spNoKamarAdd.getValue());
//        if(operatorPanel.getCbStatusKamarAdd().getSelectedIndex()==0){
//            k.setStatus(status);
//        }
        k.setTipe_kamar(cbTipeKamarAdd.getSelectedItem().toString().toLowerCase());
        k.setStatus(cbStatusKamarAdd.getSelectedItem().toString().toLowerCase());
        implKamar.insert(k);
    }
    
    public void updateKamar(){
        Kamar k = new Kamar();
        k.setId_kamar((int) operatorPanel.getSpIdKamarUpdate().getValue());
        k.setNo_kamar((int) operatorPanel.getSpNoKamarUpdate().getValue());
        if (operatorPanel.getCbTipeKamarUpdate().getSelectedIndex()==0){            
            k.setTipe_kamar("presidential");
        } else {
            k.setTipe_kamar("deluxe");
        }
        if (operatorPanel.getCbStatusKamarUpdate().getSelectedIndex()==0){
            k.setStatus("available");           
        } else {
            k.setStatus("unavailable");
        }
        implKamar.update(k);
    }
    
    public void deleteKamar(){
        Kamar k = new Kamar();
        int viewRow = tableKamar.getSelectedRow();
        int idKamar = (int) tableKamar.getValueAt(viewRow, 0);
        implKamar.delete(idKamar);       
    }
    
    public void getRowDataKamar(){
        tableKamar = operatorPanel.getKamarTableData();
        tableKamar.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int viewRow = tableKamar.getSelectedRow();
                if(viewRow>=0){
                    spIdKamarUpdate.setValue(tableKamar.getValueAt(viewRow, 0));
                    spNoKamarUpdate.setValue(tableKamar.getValueAt(viewRow, 1));
                    if(tableKamar.getValueAt(viewRow, 2).toString().equalsIgnoreCase("deluxe")){
                        cbTipeKamarUpdate.setSelectedIndex(0);
                    } else {
                        cbTipeKamarUpdate.setSelectedIndex(1);
                    }
                    if(tableKamar.getValueAt(viewRow, 3).toString().equalsIgnoreCase("unavailable")){
                        cbStatusKamarUpdate.setSelectedIndex(0);
                    } else {
                        cbStatusKamarUpdate.setSelectedIndex(1);
                    }
                }
            }
        });
    }
}
