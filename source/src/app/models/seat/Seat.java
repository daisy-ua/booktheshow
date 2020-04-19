package app.models.seat;

public abstract class Seat implements Cloneable {

    protected double price;
    protected boolean isTaken;

    public Seat(double price) {

        this.price = price;
        this.isTaken = false;
    }

    public double getPrice() {

        return this.price;
    }

    public boolean reserveSeat() {

        if(isTaken) return false;

        //TODO: call Payment
        return true;
    }

    public Object clone() {

        Object clone = null;

        try {

            clone = super.clone();
        } catch (CloneNotSupportedException e) {

            e.printStackTrace();
        }

        return clone;
    }
}