package app.views;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CardPayment extends JPanel {

    private JLabel numberText;
    private JTextField number;
    private JLabel dateText;
    private JTextField date;
    private JLabel cvvText;
    private JTextField cvv;

    public CardPayment() {

        super();

        GroupLayout layout = new GroupLayout(this);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        setLayout(layout);

        numberText = new JLabel("Number:");
        number = new JTextField();
        dateText = new JLabel("Date:");
        date = new JTextField();
        cvvText = new JLabel("Cvv:");
        cvv = new JTextField();

        number.setMaximumSize(new Dimension(400, 25));
        date.setMaximumSize(new Dimension(400, 25));
        cvv.setMaximumSize(new Dimension(400, 25));

        setHorizontalLayout(layout);
        setVerticalLayout(layout);
    }

    private void setHorizontalLayout(GroupLayout layout) {

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(numberText)
                .addComponent(dateText)
                .addComponent(cvvText)
                .addGap(25)
            )
            .addGroup(layout.createParallelGroup()
            
                .addComponent(number)
                .addComponent(date)
                .addComponent(cvv)
            )
        );
    }

    private void setVerticalLayout(GroupLayout layout) {

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup()
            
                .addComponent(numberText)
                .addComponent(number)
            )
            .addGroup(layout.createParallelGroup()
                .addComponent(dateText)
                .addComponent(date)
            )
            .addGroup(layout.createParallelGroup()
                .addComponent(cvvText)
                .addComponent(cvv)
            )
            .addGap(25)
        );

    }

    public JTextField getNumber() {

        return number;
    }

    public JTextField getDate() {

        return date;
    }

    public JTextField getCvv() {

        return cvv;
    }
}