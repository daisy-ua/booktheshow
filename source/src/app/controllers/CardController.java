package app.controllers;

import java.util.HashMap;
import java.util.Map;

import app.views.CardPayment;

public class CardController implements IPayment {

    private CardPayment cardView;
    private Map<String, String> data;

    public CardController(CardPayment cardView) {

        this.cardView = cardView;
        data = new HashMap<>();
    }

    private void initUserData() {

        data.put("number", cardView.getNumber().getText());
        data.put("date", cardView.getDate().getText()); 
        data.put("cvv", cardView.getCvv().getText()); 
    }

    public Map<String, String> getData() {

        initUserData();
        return data;
    }
}