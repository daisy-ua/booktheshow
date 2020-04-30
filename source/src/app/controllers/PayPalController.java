package app.controllers;

import java.util.HashMap;
import java.util.Map;

import app.views.PayPalPayment;

public class PayPalController implements IPayment {

    private PayPalPayment payPalView;
    private Map<String, String> data;

    public PayPalController(PayPalPayment payPalView) {

        this.payPalView = payPalView;
        data = new HashMap<>();
    }
   
    private void initUserData() {

        data.put("email", payPalView.getEmail().getText());
        data.put("password", String.valueOf(payPalView.getPassword().getPassword())); 
    }

    @Override
    public Map<String, String> getData() {

        initUserData();
        return data;
    }
}