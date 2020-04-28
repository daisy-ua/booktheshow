package app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import app.models.order.IOrder;
import app.models.payment.PayStrategy;
import app.models.payment.PayType;
import app.views.PaymentView;

public class PaymentController {

    private IOrder order;
    private PaymentView paymentView;

    public PaymentController(IOrder order, PaymentView paymentView) {

        this.paymentView = paymentView;
        this.order = order;
    }

    public void initController() {

        initPayStrategyComboBox();
    }

    private void initPayStrategyComboBox() {

        // List<String> options = new ArrayList<>();
        JComboBox<String> strategy = paymentView.getPayStrategy();

        for(PayType pay : PayType.values()) {

            // options.add(pay.name());
            strategy.addItem(pay.name());

        }

        // paymentView.getPayStrategy().getModel().
    }
}