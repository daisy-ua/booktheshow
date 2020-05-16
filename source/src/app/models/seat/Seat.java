package app.models.seat;

public abstract class Seat implements Cloneable {

    protected double price;
    protected boolean isTaken;
    protected SeatType seatType;
    protected SeatPosition seatPosition;

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

    public Seat setSeatType(SeatType type) {

        this.seatType = type;
        return this;
    }

    public SeatType getSeatType() {

        return this.seatType;
    }

    public Seat setPosition(SeatPosition position) {

        this.seatPosition = position;
        return this;
    }

    public int getRow() {

        return seatPosition.getRow();
    }

    public int getColumn() {

        return seatPosition.getColumn();
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