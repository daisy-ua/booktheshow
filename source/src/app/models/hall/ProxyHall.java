package app.models.hall;

import java.util.Set;

import app.models.seat.Seat;
import app.models.seat.SeatPosition;

public class ProxyHall implements IHall {

    private int id;
    private int rows;
    private int columns;
    private Hall realHall;
    private Set<SeatPosition> set;

    public ProxyHall(int id, int rows, int columns) {

        this.id = id;
        this.rows = rows;
        this.columns = columns;
    }

    public ProxyHall setTakenSeats(Set<SeatPosition> set) {

        this.set = set;
        return this;
    }

    public Seat[][] getSeats() {

        if(realHall == null) {
            realHall = new Hall(id, rows, columns);
            realHall.setTakenSeats(set);
        }
        return realHall.getSeats();
    }
} 