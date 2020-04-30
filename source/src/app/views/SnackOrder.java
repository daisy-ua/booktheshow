package app.views;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SnackOrder extends JPanel {

    private SnackPick snackPick;
    private SnackOrderList snackOrder;

    public SnackOrder() {

        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        snackPick = new SnackPick();
        snackOrder = new SnackOrderList();

        setAlignmentX(JPanel.LEFT_ALIGNMENT);
        snackPick.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        snackOrder.setAlignmentX(JPanel.LEFT_ALIGNMENT);

        snackPick.setMaximumSize(new Dimension(800, 100));

        add(snackPick);
        add(snackOrder);
    }

    public SnackPick getSnackPick() {

        return snackPick;
    }

    public SnackOrderList getSnackOrder() {

        return snackOrder;
    }

}