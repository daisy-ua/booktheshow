package app.models.payment;

import java.util.Map;

public interface PayStrategy {
    
    public boolean checkInquiry(Map<String, String> data);
    public boolean makePayment(double price);
    public boolean getStatus();
}