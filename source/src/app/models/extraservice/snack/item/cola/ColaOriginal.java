package app.models.extraservice.snack.item.cola;

import app.models.extraservice.snack.item.Snack;

public class ColaOriginal extends Snack {

    private String taste;

    public ColaOriginal() {

        super();
        this.taste = "Original";
    }

    @Override
    public String getDescription() {

        return "CocaCola " + this.taste + " " + this.getSize().getSize() 
            + " x" + this.quantity + " " + this.getTotalPrice() + " UAH";
    }
}