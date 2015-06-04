package tripletown.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pelilauta extends JPanel {

    private int leveys = 6;
    private int korkeus = 6;
    private ArrayList<Rectangle> ruudut;

    public Pelilauta() {
        ruudut = new ArrayList<>(leveys * korkeus);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int ruudunKorkeus = 50;
        int ruudunLeveys = 50;

        int vasenMarginaali = (ruudunLeveys)/2;
        int ylamarginaali = (ruudunKorkeus)/2;
        
        if (ruudut.isEmpty()) {
            for (int y = 0; y < korkeus; y++) {
                for (int x = 0; x < leveys; x++) {
                    Rectangle ruutu = new Rectangle(
                            vasenMarginaali + (x * ruudunLeveys),
                            ylamarginaali + (y * ruudunKorkeus),
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
