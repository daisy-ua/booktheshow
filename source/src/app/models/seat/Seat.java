package app.models.seat;

public abstract class Seat implements Cloneable {

    protected double price;
    protected boolean isTaken;
    protected int row;
    protected int column;

    public Seat() {

        this.isTaken = false;
    }

    public Seat setPrice(double price) {

        this.price = price;
        this.isTaken = false;
        return this;
    }

    public double getPrice() {

        return this.price;
    }

    public Seat setPosition(int row, int column) {

        this.row = row;
        this.column = column;
        return this;
    }

    public int getRow() {

        return this.row;
    }

    public int getColumn() {

        return this.column;
    }

    public boolean reserveSeat() {

        if(isTaken) return false;

        this.isTaken = true;
        return true;
    }

    public boolean isTaken() {

        return isTaken;
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