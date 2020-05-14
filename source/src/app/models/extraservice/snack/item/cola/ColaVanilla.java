package app.models.extraservice.snack.item.cola;

import app.models.extraservice.snack.item.Snack;

public class ColaVanilla extends Snack {

    private String taste;

    public ColaVanilla() {

        super();
        this.taste = "Vanilla";
    }

    @Override
    public String getDescription() {

        return "CocaCola " + this.taste + " " + this.getSize().getSize() 
            + " x" + this.quantity + " " + this.getTotalPrice() + " UAH";
    }
}