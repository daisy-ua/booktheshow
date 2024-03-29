package app.views;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mdlaf.utils.MaterialColors;

@SuppressWarnings("serial")
public class SnackOrderList extends JPanel {

    private JList<String> orderList;
    private JLabel header;
    private JScrollPane scrollOrder;
    private JPanel priceSet;
    private JLabel price;

    public SnackOrderList() {

        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(JPanel.LEFT_ALIGNMENT);

        header = new JLabel("Your snacks:");
        header.setForeground(MaterialColors.BLUE_400);

        orderList = new JList<String>(new DefaultListModel<>());
        scrollOrder = new JScrollPane();
        scrollOrder.setViewportView(orderList);
        
        header.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        scrollOrder.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);

        price = new JLabel();
        priceSet = new JPanel(new FlowLayout(FlowLayout.LEFT));
        priceSet.add(new JLabel("Price: "));
        priceSet.add(price);
        priceSet.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        
        add(header);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(scrollOrder);
        add(priceSet);
    }

    public void setOrderList(JList<String> orderList) {

        this.orderList = orderList;
    }

    public JList<String> getOrderList() {

        return orderList;
    }

    public JLabel getPrice() {

        return price;
    }
}