package app.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class OrderView extends JPanel {

    private MainOrder mainOrder; 

    public OrderView() {

        mainOrder = new MainOrder();
        add(mainOrder);
    }

    public JFrame getParentFrame() {

        return (JFrame) SwingUtilities.getRoot(this);
    }

    public MainOrder getMainOrder() {

        return mainOrder;
    }
}