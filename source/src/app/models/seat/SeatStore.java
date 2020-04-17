package app.models.seat;

import java.util.HashMap; 
import java.util.Map; 

public class SeatStore {

    private static Map<SeatType, Seat> seatMap = new HashMap<SeatType, Seat>();

    private static double gprice = 100;
    private static double lprice = 150; //TODO: get theater price

    static {

        seatMap.put(SeatType.GOOD, new GoodSeat(gprice));
        seatMap.put(SeatType.LUX, new LuxSeat(lprice));
    }

    public static Seat getSeat(SeatType type) {

        return (Seat) seatMap.get(type).clone();
    }
}