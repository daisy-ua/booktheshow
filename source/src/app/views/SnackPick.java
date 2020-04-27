package app.views;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

@SuppressWarnings("serial") 
public class SnackPick extends JPanel {

    private JComboBox<String> snackType;
    private JComboBox<String> snackTaste;
    private JComboBox<String> snackSize;
    private JSpinner snackQuantity;
    private JLabel price;

    public SnackPick() {

        super(new FlowLayout(FlowLayout.LEFT));

        price = new JLabel();
        add(price);
    }

    public JComboBox<String> getSnackType() {

        return snackType;
    }

    public JComboBox<String> getSnackTaste() {

        return snackTaste;
    }

    public JComboBox<String> getSnackSize() {

        return snackSize;
    }

    public void setSnackType(JComboBox<String> type) {

        snackType = type;
        add(snackType);
    }

    public void setSnackTaste(JComboBox<String> taste) {

        snackTaste = taste;
        add(snackTaste);
    }

    public void setSnackSize(JComboBox<String> size) {

        snackSize = size;
        add(snackSize);
    }

    public void setSnackQuantity(JSpinner quantity) {

        this.snackQuantity = quantity;
        add(snackQuantity);
    }

    public JSpinner getSnackQuantity() {

        return snackQuantity;
    }

    public void setPrice(String value) {

        price.setText(value);
    }

    public JLabel getPrice() {

        return price;
    }
}