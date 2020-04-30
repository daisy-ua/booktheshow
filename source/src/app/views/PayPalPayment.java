package app.views;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PayPalPayment extends JPanel {

    private JLabel emailText;
    private JTextField email;
    private JLabel passwordText;
    private JPasswordField password;

    public PayPalPayment() {

        super();

        GroupLayout layout = new GroupLayout(this);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        setLayout(layout);

        emailText = new JLabel("Email:");
        email = new JTextField();
        passwordText = new JLabel("Password:");
        password = new JPasswordField();

        email.setMaximumSize(new Dimension(400, 25));
        password.setMaximumSize(new Dimension(400, 25));

        setHorizontalLayout(layout);
        setVerticalLayout(layout);
    }

    private void setHorizontalLayout(GroupLayout layout) {

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            
                .addComponent(emailText)
                .addComponent(passwordText)
                .addGap(25)
            )
            .addGroup(layout.createParallelGroup()
            
                .addComponent(email)
                .addComponent(password)
            )
        );
    }

    private void setVerticalLayout(GroupLayout layout) {

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup()
            
                .addComponent(emailText)
                .addComponent(email)
            )
            .addGroup(layout.createParallelGroup()
            
                .addComponent(passwordText)
                .addComponent(password)
            )
            .addGap(25)
        );

    }

    public JTextField getEmail() {

        return email;
    }

    public JPasswordField getPassword() {

        return password;
    }
}