package app.models.payment;

public class PayByCard implements PayStrategy {

    @Override
    public boolean checkInquiry() {

        //some of validation or\and requesting the customer 
        //card details logic
        return true;
    }

    @Override
    public boolean makePayment(double price) {

        //implement your payment using card option logic logic here
        return true; 
    }

    @Override
    public boolean getStatus() {

        //getting transaction status for a card payment
        return true;
    }
}