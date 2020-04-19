package app.models.payment;

public interface PayStrategy {
    
    public boolean checkInquiry(Object requisites);
    public boolean makePayment(double price, Object requisites);
    public boolean getStatus(int id);
}