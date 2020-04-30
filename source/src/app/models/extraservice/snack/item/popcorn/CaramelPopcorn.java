package app.models.extraservice.snack.item.popcorn;

import app.models.extraservice.snack.item.Snack;

public class CaramelPopcorn extends Snack {

    private String taste;

    public CaramelPopcorn() {

        super();
        this.taste = "Caramel";
        this.price = 30;
    }

    @Override
    public String getDescription() {

        return "Popcorn " + this.taste + " " + this.getSize().getSize() 
            + " x" + this.quantity + " " + this.getTotalPrice() + " UAH";
    }
}