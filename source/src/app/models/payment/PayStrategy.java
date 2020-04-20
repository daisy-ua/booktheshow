package app.models.payment;

public interface PayStrategy {
    
    public boolean checkInquiry();
    public boolean makePayment(double price);
    public boolean getStatus();
}