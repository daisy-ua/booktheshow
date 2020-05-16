package app.views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import app.controllers.TheatreController;

@SuppressWarnings("serial")
public class TheatrePick extends JPanel {

    private JButton lavinaMultiplex;

    public TheatrePick() {

        super();
        setLayout(null);

        lavinaMultiplex = new JButton("Lavina Multiplex");
        lavinaMultiplex.setFocusable(false);

        JLabel info = new JLabel("Select the theatre to continue..");

        info.setBounds(25, 25, 400, 30);
        lavinaMultiplex.setBounds(25, 60, 200, 30);

        add(info);
        add(lavinaMultiplex);

        new TheatreController(this).initController();
    }

    public JButton getLavinaMultiplex() {

        return this.lavinaMultiplex;
    }

    public JFrame getParentFrame() {

        return (JFrame) SwingUtilities.getRoot(this);
    }
}