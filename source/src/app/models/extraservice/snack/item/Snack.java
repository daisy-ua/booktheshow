package app.models.extraservice.snack.item;

import app.models.extraservice.snack.size.*;

public abstract class Snack {

    private SizeState size;
    protected double price;
    protected int quantity;

    public Snack() {

        this.size = new LargeSize();
        this.quantity = 1;
    }

    public abstract String getDescription();

    public double getTotalPrice() {

        return (this.price + (int)(this.price * size.getTax())) * this.quantity;
    }

    public SizeState getSize() {

        return size;
    }

    public void setSize(SizeType type) {

        switch (type) {

        case SMALL:
            this.size = new SmallSize();
            break;
        case MEDIUM:
            this.size = new MediumSize();
            break;
        case LARGE:
            this.size = new LargeSize();
            break;
        default:
            break;
        }
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }
}