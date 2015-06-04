package tripletown.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import tripletown.sovellus.Peli;

public class Kayttoliittyma implements Runnable {

    JFrame frame;
    private Peli peli;
    private final String[] palat = {"", "ruoho", "pensas", "puu", "talo", "kartano", "linna"};
    private int leveys = 6;
    private int korkeus = 6;

    public Kayttoliittyma() {
        peli = new Peli(leveys, korkeus);
    }

    @Override
    public void run() {
        frame = new JFrame("Triple Town");
        frame.setPreferredSize(new Dimension(700, 400));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(6, 6));
        frame.setLocationRelativeTo(null);

        frame.pack();

        lisaaKomponentit();

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    private void lisaaKomponentit() {
//        frame.add(new Pelilauta());
//        
//        int pala = peli.arvoPala();
//        frame.add(new JLabel(palat[pala]));
        
        peli.alustaPelilauta();
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                
                JButton button = new JButton();
                
                if (peli.getRuutu(x, y) != null) {
                    button = new JButton(peli.getRuutu(x, y).toString());
                } 
                
                frame.add(button);
            }
        }

    }

}
