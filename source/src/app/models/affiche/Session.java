package app.models.affiche;

import java.time.LocalTime;

public class Session {

    private int hallId;
    private double luxSeatPrice;
    private double goodSeatPrice;
    private LocalTime time;

    public Session(int hallId, double luxSeatPrice, double goodSeatPrice, String time) {

        this.hallId = hallId;
        this.luxSeatPrice = luxSeatPrice;
        this.goodSeatPrice = goodSeatPrice;
        this.time = LocalTime.parse(time);
    }

    public int getHallId() {

        return this.hallId;
    }

    public double getLuxSeatPrice() {

        return this.luxSeatPrice;
    }

    public double getGoodSeatsPrice() {

        return this.goodSeatPrice;
    }

    public LocalTime getTime() {

        return this.time;
    }
}