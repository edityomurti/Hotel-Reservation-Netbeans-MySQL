/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import sirh.Operator;

/**
 *
 * @author usernames
 */
public class TableModelKamar extends AbstractTableModel {

    List<Kamar> kamarList;
    Operator operatorPanel;
    JTable table;
    TableColumn column;

    public TableModelKamar(List<Kamar> kamarList) {
        this.kamarList = kamarList;        
        operatorPanel= new Operator();
        table = operatorPanel.getKamarTableData();
//        aturColumn();
    }
    
    public void aturColumn(){        
        for (int i=0; i<4; i++){
            column = table.getColumnModel().getColumn(i);
            if(i==0 || i==2){
                column.setWidth(5);
            }            
        }
    }
        
    
    @Override
    public int getRowCount() {
        return kamarList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return kamarList.get(rowIndex).getId_kamar();
            case 1:
                return kamarList.get(rowIndex).getTipe_kamar();
            case 2:
                return kamarList.get(rowIndex).getNo_kamar();
            case 3:
                return kamarList.get(rowIndex).getStatus();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Room ID";
            case 1:
                return "Room Type";
            case 2:
                return "Room No.";
            case 3:
                return "Status";
            default:
                return null;
        }
    }
    
    
    
}
