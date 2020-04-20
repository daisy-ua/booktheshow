package app.models.order;

import app.models.affiche.*;
import app.models.seat.*;

public class Order implements IOrder {

    private Movie movie;
    private Session session;
    private Seat seat;

    public Order(Movie movie, Session session, Seat seat) {

        this.movie = movie;
        this.seat = seat;
        this.session = session;
    }

    @Override
    public String getDescription() {

        return "";
    }

    @Override
    public double getTotalPrice() {

        return (seat instanceof GoodSeat) ? session.getGoodSeatsPrice() : session.getLuxSeatPrice();
    }

    @Override
    public String getMovieTitle() {

        return movie.getTitle();
    }

    @Override
    public String getMovieTime() {

        return session.getTime().toString();
    }

    @Override
    public int getHallNumber() {

        return session.getHallId();
    }

    @Override
    public int getSeatRow() {

        return seat.getRow();
    }

    @Override
    public int getSeatColumn() {

        return seat.getColumn();
    }

    @Override
    public int getMovieDuration() {

        return movie.getDuration();
    }
}