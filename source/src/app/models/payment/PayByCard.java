package app.models.payment;

public class PayByCard implements PayStrategy {

    @Override
    public boolean checkInquiry(Object requisites) {

        //some of validation or\and requesting the customer 
        //card details logic
        return true;
    }

    @Override
    public boolean makePayment(double price, Object requisites) {

        //implement your payment using card option logic logic here
        return true; 
    }

    @Override
    public boolean getStatus(int id) {

        //getting transaction status for a card payment
        return true;
    }
}