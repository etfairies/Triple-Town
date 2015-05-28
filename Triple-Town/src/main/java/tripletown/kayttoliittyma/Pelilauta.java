package tripletown.kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Pelilauta extends JPanel {

    private int sarakkeet = 6;
    private int rivit = 6;
    private ArrayList<Rectangle> ruudut;

    public Pelilauta() {
        ruudut = new ArrayList<>(sarakkeet * rivit);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int leveys = getWidth();
        int korkeus = getHeight();

        int ruudunKorkeus = leveys / sarakkeet;
        int ruudunLeveys = korkeus / rivit;

        int xOffset = (leveys - (sarakkeet * ruudunLeveys)) / 2;
        int yOffset = (korkeus - (rivit * ruudunKorkeus)) / 2;

        if (ruudut.isEmpty()) {
            for (int rivi = 0; rivi < rivit; rivi++) {
                for (int sarake = 0; sarake < sarakkeet; sarake++) {
                    Rectangle ruutu = new Rectangle(
                            xOffset + (sarake * ruudunLeveys),
                            yOffset + (rivi * ruudunKorkeus),
                            ruudunLeveys,
                            ruudunKorkeus);
                    ruudut.add(ruutu);
                }
            }
        }

        g2d.setColor(Color.GRAY);
        for (Rectangle ruutu : ruudut) {
            g2d.draw(ruutu);
        }

        g2d.dispose();
    }
}
