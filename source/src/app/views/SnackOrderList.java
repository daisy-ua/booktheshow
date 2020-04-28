package app.views;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import mdlaf.utils.MaterialColors;

@SuppressWarnings("serial")
public class SnackOrderList extends JPanel {

    private JList<String> orderList;
    private JLabel header;

    public SnackOrderList() {

        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(JPanel.LEFT_ALIGNMENT);

        header = new JLabel("Your snacks");
        header.setForeground(MaterialColors.BLUE_400);

        orderList = new JList<String>(new DefaultListModel<>());
        
        header.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        orderList.setAlignmentX(JList.LEFT_ALIGNMENT);
        
        add(header);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(orderList);
    }

    public void setOrderList(JList<String> orderList) {

        this.orderList = orderList;
    }

    public JList<String> getOrderList() {

        return orderList;
    }
}