package app.models.extraservice.snack.item.popcorn;

import app.models.extraservice.snack.item.Snack;

public class BaconPopcorn extends Snack {

    private String taste;

    public BaconPopcorn() {

        super();
        this.taste = "Bacon";
    }

    @Override
    public String getDescription() {

        return "Popcorn " + this.taste + " " + this.getSize().getSize() 
            + " x" + this.quantity + " " + this.getTotalPrice() + " UAH";
    }
}