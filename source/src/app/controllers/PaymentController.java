package app.controllers;

import app.models.order.IOrder;
import app.views.PaymentView;

public class PaymentController {

    private IOrder order;
    private PaymentView paymentView;

    public PaymentController(IOrder order, PaymentView paymentView) {

        this.paymentView = paymentView;
        this.order = order;
    }

    public void initController() {

    }
}