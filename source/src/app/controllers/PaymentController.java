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
import app.models.payment.PayType;
import app.models.payment.PaymentContext;
import app.models.theatre.GlobalTheatre;
import app.views.CardPayment;
import app.views.PayPalPayment;
import app.views.PaymentView;

public class PaymentController {

    private IOrder order;
    private PaymentView paymentView;
    private CardPayment cardView;
    private PayPalPayment payPalView;
    private IPayment dataCollector;
    private PaymentContext payment;

    public PaymentController(IOrder order, PaymentView paymentView) {

        this.paymentView = paymentView;
        this.order = order;
        this.payment = new PaymentContext();
    }

    public void initController() {

        initPayAmount();
        initPayStrategyComboBox();
        initFormPanels();
        payment.setStrategy(new PayByCard());
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

                        payment.setStrategy(new PayByCard());
                        dataCollector = new CardController(cardView);
                        break;
                    }
                    case PAYPAL: {

                        payment.setStrategy(new PayByPayPal());
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

                if (!payment.pay(data, order)) {

                    JOptionPane.showMessageDialog(null, "Wrong Data");
                    return;
                }

                JOptionPane.showMessageDialog(null, "Order is paid");
                GlobalTheatre.getTheatre().sendOrderData(order);
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