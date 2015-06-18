/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripletown.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tripletown.kayttoliittyma.Kayttoliittyma;

/**
 * Luokka kuuntelee peliruudulla olevaa nappia "Päävalikko".
 */
public class ValikkoKuuntelija implements ActionListener {
private final Kayttoliittyma kl;

    public ValikkoKuuntelija(Kayttoliittyma kl) {
        this.kl = kl;
    }
   
    /**
     * Metodi kutsuu Käyttöliittymä -luoka metodia, joka palaa päävalikkoon.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        kl.palaaValikkoon();
    }
    
}
