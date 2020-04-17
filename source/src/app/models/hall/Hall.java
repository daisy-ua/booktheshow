package app.models.hall;

import app.models.seat.*;

public class Hall implements IHall{

    private int id;
    private int rows;
    private int columns;
    private Seat[][] seats;

    public Hall(int id, int rows, int columns) {

        this.id = id;
        this.rows = rows;
        this.columns = columns;
        seats = new Seat[rows][columns];
        setSeats();
    }

    private void setSeats() {

        for(int i = 0; i < this.rows - 1; i++) {

            for(int j = 0; j < this.columns; j++) {

                this.seats[i][j] = SeatStore.getSeat(SeatType.GOOD);
            }
        }

        for(int j = 0; j < this.columns; j++) {

            this.seats[this.rows - 1][j] = SeatStore.getSeat(SeatType.LUX);
        }
    }

    public Seat[][] getSeats() {

        return this.seats;
    }

}