package app.models.payment;

import java.util.Map;

import app.models.order.IOrder;

public interface PayStrategy {
    
    public boolean checkInquiry(Map<String, String> data);
    public boolean makePayment(IOrder order);
    public boolean getStatus();
}