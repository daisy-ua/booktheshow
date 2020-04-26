package app.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class OrderView extends JPanel {

    public OrderView() {

    }

    public JFrame getParentFrame() {

        return (JFrame) SwingUtilities.getRoot(this);
    }
}