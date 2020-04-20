package app.models.extraservice.snack.item.cola;

import app.models.extraservice.snack.item.Snack;

public class ColaZero extends Snack {

    private String taste;

    public ColaZero() {

        super();
        this.taste = "Zero";
        this.price = 28;
    }

    @Override
    public String getDescription() {

        return "CocaCola " + this.taste + " " + this.getSize().getSize() 
            + " x" + this.quantity + " " + this.getTotalPrice() + " UAH";
    }
}