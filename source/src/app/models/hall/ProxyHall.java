package app.models.hall;

import app.models.seat.Seat;

public class ProxyHall implements IHall {

    private int id;
    private int rows;
    private int columns;
    private Hall realHall;


    public ProxyHall(int id, int rows, int columns) {

        this.id = id;
        this.rows = rows;
        this.columns = columns;
    }

    public Seat[][] getSeats() {

        if(realHall == null) {
            realHall = new Hall(id, rows, columns);
        }
        return realHall.getSeats();
    }
} 