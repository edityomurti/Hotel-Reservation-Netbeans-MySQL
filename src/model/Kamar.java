/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author usernames
 */
public class Kamar {
    private int id_kamar;
    private String tipe_kamar;
    private int no_kamar;
    private String status;

    public int getId_kamar() {
        return id_kamar;
    }

    public void setId_kamar(int id_kamar) {
        this.id_kamar = id_kamar;
    }

    public String getTipe_kamar() {
        return tipe_kamar;
    }

    public void setTipe_kamar(String id_tipe) {
        this.tipe_kamar = id_tipe;
    }

    public int getNo_kamar() {
        return no_kamar;
    }

    public void setNo_kamar(int no_kamar) {
        this.no_kamar = no_kamar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
