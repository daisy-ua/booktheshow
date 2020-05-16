package app.models.seat;

public class SeatPosition {
    
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