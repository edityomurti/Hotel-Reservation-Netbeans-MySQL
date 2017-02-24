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
public interface ImplKamar {
    public void insert (Kamar k);
    public void update (Kamar k);
    public void delete (int id);
    public int getLastKamarId ();
    
    public List<Kamar> getAll();
    
    public List<Kamar> getCari(String kamarId);
}
