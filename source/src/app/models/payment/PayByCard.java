package app.models.payment;

import java.util.Map;

import app.models.payment.instance.CreditCard;

public class PayByCard implements PayStrategy {

    public String number;
    public String date;
    public String cvv;

    public CreditCard card;

    @Override
    public boolean checkInquiry(Map<String, String> data) {

        //some of validation or\and requesting the customer 
        //card details logic

        card = new CreditCard(number, date, cvv);
        
        return true;
    }

    @Override
    public boolean makePayment(double price) {

        //implement your payment using card option logic logic here

        if(card == null) return false;

        card.setAmount(price);
        
        return true; 
    }

    @Override
    public boolean getStatus() {

        //getting transaction status for a card payment
        return true;
    }
}