package app.views;

import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SnackOrder extends JPanel {

    private SnackPick snackPick;
    private JTextArea snackOrder;

    public SnackOrder() {

        super();

        snackPick = new SnackPick();
        // snackPick.setVisible(true);
        add(snackPick);
    }

    public SnackPick getSnackPick() {

        return snackPick;
    }

    public JTextArea getSnackOrder() {

        return snackOrder;
    }

}