package app.models.payment;

import java.util.Map;

import app.models.order.IOrder;

public class PaymentContext {
    
    private PayStrategy strategy;

    public void setStrategy(PayStrategy strategy) {

        this.strategy = strategy;
    }

    public boolean pay(Map<String, String> data, IOrder order) {

        return (strategy.checkInquiry(data)) ? strategy.makePayment(order) : false;
    }
}