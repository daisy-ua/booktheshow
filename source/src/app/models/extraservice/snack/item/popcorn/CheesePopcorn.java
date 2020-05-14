package app.models.extraservice.snack.item.popcorn;

import app.models.extraservice.snack.item.Snack;

public class CheesePopcorn extends Snack {

    private String taste;

    public CheesePopcorn() {

        super();
        this.taste = "Cheese";
    }

    @Override
    public String getDescription() {

        return "Popcorn " + this.taste + " " + this.getSize().getSize() 
            + " x" + this.quantity + " " + this.getTotalPrice() + " UAH";
    }
}