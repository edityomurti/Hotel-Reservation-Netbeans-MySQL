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
public class Reservasi {

    private int id_reservasi;
    private int id_tamu;
    private int jmlTipeKamar1;
    private int jmlTipeKamar2;
    private String fasilitas_tambahan;
    private String tgl_masuk;
    private String tgl_keluar;
    private long harga;
    private int diskon;
    private long total_harga;
    private String status;

    public int getId_reservasi() {
        return id_reservasi;
    }

    public void setId_reservasi(int id_reservasi) {
        this.id_reservasi = id_reservasi;
    }

    public int getId_tamu() {
        return id_tamu;
    }

    public void setId_tamu(int id_tamu) {
        this.id_tamu = id_tamu;
    }

    public int getJmlTipeKamar1() {
        return jmlTipeKamar1;
    }

    public void setJmlTipeKamar1(int jmlTipeKamar1) {
        this.jmlTipeKamar1 = jmlTipeKamar1;
    }

    public int getJmlTipeKamar2() {
        return jmlTipeKamar2;
    }

    public void setJmlTipeKamar2(int jmlTipeKamar2) {
        this.jmlTipeKamar2 = jmlTipeKamar2;
    }
    
    

    public String getFasilitas_tambahan() {
        return fasilitas_tambahan;
    }

    public void setFasilitas_tambahan(String fasilitas_tambahan) {
        this.fasilitas_tambahan = fasilitas_tambahan;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public String getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(String tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public int getDiskon() {
        return diskon;
    }

    public void setDiskon(int diskon) {
        this.diskon = diskon;
    }

    public long getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(long total_harga) {
        this.total_harga = total_harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
   
    
}
