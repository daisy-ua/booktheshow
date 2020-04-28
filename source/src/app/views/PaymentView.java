package app.views;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial") 
public class PaymentView extends JPanel {

    private JLabel priceText;
    private JLabel price;
    private JLabel payStrategyText;
    private JComboBox<String> payStrategy;
    private JPanel paySet;
    private JPanel priceSet;

    public PaymentView() {
        
        super();

        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 0, 10), new EtchedBorder()));

        priceSet = new JPanel(new FlowLayout(FlowLayout.LEFT));
        priceText = new JLabel("Amount to pay:");
        price = new JLabel();

        priceSet.add(priceText);
        priceSet.add(price);

        priceSet.setMaximumSize(new Dimension(Integer.MAX_VALUE, price.getMinimumSize().height));

        paySet = new JPanel(new FlowLayout(FlowLayout.LEFT));
        payStrategyText = new JLabel("Select payment type:");
        payStrategy = new JComboBox<>();

        paySet.add(payStrategyText);
        paySet.add(payStrategy);

        // paySet.setMaximumSize(new Dimension(Integer.MAX_VALUE, payStrategy.getMinimumSize().height));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(priceSet);
        add(paySet);

    }

    public JLabel getPrice() {

        return price;
    }

    public JComboBox<String> getPayStrategy() {

        return payStrategy;
    }

}