package app.views;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
    private JPanel form;
    private JButton pay;

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

        form = new JPanel(new CardLayout());
        form.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 0, 10), new EtchedBorder()));

        pay = new JButton("Pay");
        setLayout(null);

        priceSet.setBounds(30, 30, 400, 30);
        paySet.setBounds(30, 70, 400, 60);
        form.setBounds(30, 160, 400, 200);
        pay.setBounds(30, 400, 80, 30);

        add(priceSet);
        add(paySet);
        add(form);
        add(pay);
    }

    public JLabel getPrice() {

        return price;
    }

    public JComboBox<String> getPayStrategy() {

        return payStrategy;
    }

    public JPanel getForm() {

        return form;
    }

    public JButton getPayButton() {

        return pay;
    }
}