package app.models.hall;

import java.util.Set;

import app.models.seat.*;

public class Hall implements IHall{

    private int id;
    private int rows;
    private int columns;
    private Seat[][] seats;
    private Set<SeatPosition> takenSeats;

    public Hall(int id, int rows, int columns) {

        this.id = id;
        this.rows = rows;
        this.columns = columns;
        seats = new Seat[rows][columns];
        setSeats();
    }

    public void setTakenSeats(Set<SeatPosition> set) {

        this.takenSeats = set;
        reserveSeats();
    }

    private void setSeats() {

        for(int i = 0; i < this.rows - 1; i++) {

            for(int j = 0; j < this.columns; j++) {

                this.seats[i][j] = SeatStore.getSeat(SeatType.GOOD).setPosition(new SeatPosition(i, j));
            }
        }

        for(int j = 0; j < this.columns; j++) {

            this.seats[this.rows - 1][j] = SeatStore.getSeat(SeatType.LUX).setPosition(new SeatPosition(this.rows - 1, j));
        }
    }

    private void reserveSeats() {

        if(takenSeats.isEmpty()) return;

        takenSeats.forEach(position -> 
            this.seats[position.getRow()][position.getColumn()].reserveSeat()
        );
    }

    public Seat[][] getSeats() {

        return this.seats;
    }
}