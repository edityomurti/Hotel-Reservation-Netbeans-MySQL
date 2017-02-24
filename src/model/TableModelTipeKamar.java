/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sirh.Operator;

/**
 *
 * @author usernames
 */
public class TableModelTipeKamar extends AbstractTableModel{

    List<TipeKamar> tipeKamarList;
    Operator operatorPanel;
//    Jtable table;
//    TableCol

    public TableModelTipeKamar(List<TipeKamar> tipeKamarList) {
        this.tipeKamarList = tipeKamarList;
    }
    
    
    
    @Override
    public int getRowCount() {
        return tipeKamarList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return tipeKamarList.get(rowIndex).getTipeId();
            case 1:
                return tipeKamarList.get(rowIndex).getTipeNama();
            case 2:
                return tipeKamarList.get(rowIndex).getTipeHarga();
            default:
                return null;
        }
    }
    
}
