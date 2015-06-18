/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripletown.kuuntelijat;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import tripletown.kayttoliittyma.Kayttoliittyma;
import tripletown.pala.Pala;
import tripletown.sovellus.Peli;

/**
 * Luokka kuuntelee peliruutuja.
 */
public class RuutuKuuntelija implements MouseListener {

    private Peli peli;
    private Kayttoliittyma kl;
    private int x;
    private int y;

    public RuutuKuuntelija(Peli peli, Kayttoliittyma kl, int x, int y) {
        this.peli = peli;
        this.kl = kl;
        this.x = x;
        this.y = y;
    }

    /**
     * Ruutua klikatessa siihen asetetaan pala joka sinä hetkenä asetettavana.
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if (peli.getRuutu(x, y) == null) {
            Pala asetettu = peli.asetaPala(kl.getArvottuPala(), x, y);
            peli.vierekkaistenPalojenHaku(asetettu);
            kl.paivita();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    /**
     * Metodi kutsuu Kayttoliittyma-luokan metodia, joka lisää ruutuun
     * asetettavan palan kuvan, kun hiiren osoitin siirretään ruudun päälle.
     *
     * @param me
     */
    @Override
    public void mouseEntered(MouseEvent me) {
        if (peli.getRuutu(x, y) == null) {
            kl.lisaaRuutuunAsetettavanKuva(x, y);
        }

    }

    /**
     * Metodi kutsuu Kayttoliittyma-luokan metodia, joka poistaa ruudusta
     * asetettavan palan kuvan, kun hiiren osoitin viedään pois ruudun päältä.
     *
     * @param me
     */
    @Override
    public void mouseExited(MouseEvent me) {
        if (peli.getRuutu(x, y) == null) {
            kl.poistaRuudustaAsetettavanKuva(x, y);
        }
    }

}
