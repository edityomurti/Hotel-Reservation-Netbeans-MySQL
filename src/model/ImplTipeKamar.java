/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author usernames
 */
public interface ImplTipeKamar {
    public void insert (TipeKamar k);
    public void update (TipeKamar k);
    public void delete (int id);
    public int getLastKamarId ();
    
    public List<TipeKamar> getAll();
    public List<TipeKamar> getCari(String tipeKamarId);
    
}
