package tripletown.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Kayttoliittyma implements Runnable {

    JFrame frame;

    public Kayttoliittyma() {

    }

    @Override
    public void run() {
        frame = new JFrame("Triple Town");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.add(new Pelilauta());
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

}
