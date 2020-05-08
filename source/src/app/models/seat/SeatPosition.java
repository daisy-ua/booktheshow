package app.models.seat;

public class SeatPosition { //TODO: change position in Seat
    
    private int row;
    private int column;

    public SeatPosition(int row, int column) {

        this.row = row;
        this.column = column;
    }

    public int getRow() {

        return row;
    }

    public int getColumn() {

        return column;
    }
}