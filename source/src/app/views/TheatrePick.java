package app.views;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import app.controllers.TheatreController;

@SuppressWarnings("serial")
public class TheatrePick extends JPanel {

    private JButton lavinaMultiplex;

    public TheatrePick() {

        super();
        setLayout(new FlowLayout(FlowLayout.CENTER));

        lavinaMultiplex = new JButton("Lavina Multiplex");
        lavinaMultiplex.setFocusable(false);

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