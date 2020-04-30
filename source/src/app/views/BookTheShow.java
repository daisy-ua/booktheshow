package app.views;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BookTheShow extends JFrame {

    JPanel theatrePick;

    public BookTheShow() {
        super("Book the Show");
        getContentPane().setLayout(new CardLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setLocationRelativeTo(null);

        theatrePick = new TheatrePick();
        this.add(theatrePick);
    }
}