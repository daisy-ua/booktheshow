package app.controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.models.order.IOrder;
import app.models.payment.PayByCard;
import app.models.payment.PayByPayPal;
import app.models.payment.PayStrategy;
import app.models.payment.PayType;
import app.views.CardPayment;
import app.views.PayPalPayment;
import app.views.PaymentView;

public class PaymentController {

    private IOrder order;
    private PaymentView paymentView;
    private CardPayment cardView;
    private PayPalPayment payPalView;
    private IPayment dataCollector;
    private PayStrategy strategy;

    public PaymentController(IOrder order, PaymentView paymentView) {

        this.paymentView = paymentView;
        this.order = order;
    }

    public void initController() {

        initPayAmount();
        initPayStrategyComboBox();
        initFormPanels();
        strategy = new PayByCard();
        dataCollector = new CardController(cardView);
        initPayStrategyEvent();
        initPayEvent();
    }

    private void initPayAmount() {

        paymentView.getPrice().setText(Double.toString(order.getTotalPrice()));
    }

    private void initPayStrategyComboBox() {

        JComboBox<String> strategy = paymentView.getPayStrategy();

        for (PayType pay : PayType.values()) {

            strategy.addItem(pay.name());
        }

        strategy.setSelectedIndex(0);
    }

    private void initPayStrategyEvent() {

        paymentView.getPayStrategy().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String strategyType = ((JComboBox<String>) e.getSource()).getSelectedItem().toString();

                JPanel form = paymentView.getForm();
                CardLayout layout = (CardLayout) (form.getLayout());
                layout.show(form, strategyType);

                switch (PayType.valueOf(strategyType)) {
                case CARD: {
                    
                    strategy = new PayByCard();
                    dataCollector = new CardController(cardView);
                    break;
                }
                case PAYPAL: {

                    strategy = new PayByPayPal();
                    dataCollector = new PayPalController(payPalView);
                    break;
                }
                }
            }
        });
    }

    private void initPayEvent() {

        paymentView.getPayButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Map<String, String> data = dataCollector.getData();

                if(!strategy.checkInquiry(data)) {

                    JOptionPane.showMessageDialog(null, "Wrong Data");
                    return;
                }          
                
                if(strategy.makePayment(order.getTotalPrice()))
                    JOptionPane.showMessageDialog(null, "Order is paid");
                paymentView.getPayButton().setEnabled(false);    
            }
            
        });
    }

    private void initFormPanels() {

        JPanel form = paymentView.getForm();

        cardView = new CardPayment();
        payPalView = new PayPalPayment();

        form.add(cardView, PayType.CARD.name());
        form.add(payPalView, PayType.PAYPAL.name());
    }
}