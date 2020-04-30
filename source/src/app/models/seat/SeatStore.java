package app.models.seat;

import java.util.HashMap; 
import java.util.Map; 

public class SeatStore {

    private static Map<SeatType, Seat> seatMap = new HashMap<SeatType, Seat>();

    static {

        seatMap.put(SeatType.GOOD, new GoodSeat());
        seatMap.put(SeatType.LUX, new LuxSeat());
    }

    public static Seat getSeat(SeatType type) {

        return (Seat) seatMap.get(type).clone();
    }
}