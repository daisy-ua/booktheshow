package app.models.payment;

import java.util.Map;

import app.models.user.*;

public class PayByPayPal implements PayStrategy {

    public String email;
    public String password;

    @Override
    public boolean checkInquiry(Map<String, String> data) {

        //some of validation or\and requesting the customer 
        //wallet details logic

        email = data.get("email");
        password = data.get("password");

        return (email.equals(DefaultUserData.getPayPalData().get(password)));
    }

    @Override
    public boolean makePayment(double price) {

        //implement payment using wallet option logic logic here

        return true; 
    }

    @Override
    public boolean getStatus() {

        //getting transaction status for a wallet payment
        return true;
    }
}