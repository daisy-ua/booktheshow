package app.views;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import mdlaf.utils.MaterialColors;

@SuppressWarnings("serial")
public class OrderView extends JPanel {

    private MainOrder mainOrder;
    private JLabel snackOrderLoadLink;
    private SnackOrder snackOrder;
    private JButton next;

    public OrderView() {

        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        next = new JButton("Continue");
        next.setAlignmentX(JButton.LEFT_ALIGNMENT);
        add(next);
        add(Box.createRigidArea(new Dimension(0, 30)));

        mainOrder = new MainOrder();
        mainOrder.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        add(mainOrder);
        add(Box.createRigidArea(new Dimension(0, 20)));

        snackOrderLoadLink = new JLabel("Click here to book some snacks.");
        snackOrderLoadLink.setForeground(MaterialColors.BLUE_400);
        add(snackOrderLoadLink);
        add(Box.createRigidArea(new Dimension(0, 20)));
    }

    public JFrame getParentFrame() {

        return (JFrame) SwingUtilities.getRoot(this);
    }

    public MainOrder getMainOrder() {

        return mainOrder;
    }

    public SnackOrder getSnackOrder() {

        return snackOrder;
    }

    public void setSnackOrder(SnackOrder snackOrder) {

        this.snackOrder = snackOrder;
        snackOrder.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        add(snackOrder);
    }

    public JLabel getSnackOrderLoadLink() {

        return snackOrderLoadLink;
    }

    public JButton getNexButton() {

        return next;
    }
}