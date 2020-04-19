package app.models.payment;

public class PayByWallet implements PayStrategy {

    @Override
    public boolean checkInquiry(Object requisites) {

        //some of validation or\and requesting the customer 
        //wallet details logic
        return true;
    }

    @Override
    public boolean makePayment(double price, Object requisites) {

        //implement payment using wallet option logic logic here
        return true; 
    }

    @Override
    public boolean getStatus(int id) {

        //getting transaction status for a wallet payment
        return true;
    }
}