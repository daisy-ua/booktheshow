package app.controllers;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import app.models.affiche.Movie;
import app.models.affiche.Session;
import app.models.hall.ProxyHall;
import app.models.order.IOrder;
import app.models.order.Order;
import app.models.seat.LuxSeat;
import app.models.seat.Seat;
import app.models.seat.SeatStore;
import app.models.seat.SeatType;
import app.models.theatre.GlobalTheatre;
import app.views.HallSeats;
import app.views.OrderView;
import app.views.SeatPick;

public class SeatController {

    private Movie movie;
    private Session session;
    private SeatPick hallView;

    public SeatController(Movie movie, Session session, SeatPick seatPick) {

        this.session = session;
        this.movie = movie;
        this.hallView = seatPick;
    }

    public void initController() {

        setHallView();
        setSeatEvents();
    }

    private void setSeatEvents() {

        JButton[][] seats = hallView.getHall().getSeats();

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {

                seats[i][j].addActionListener(e -> configureEvent(e));
            }
        }
    }

    private void configureEvent(ActionEvent e) {

        JButton seat = (JButton) e.getSource();

        double price = (double) seat.getClientProperty("price");
        int row = (int) seat.getClientProperty("row");
        int column = (int) seat.getClientProperty("column");
        SeatType type = (SeatType) seat.getClientProperty("seatType");

        setupOrderView(SeatStore.getSeat(type)
            .setPosition(row, column)
            .setPrice(price)
            .setSeatType(type)
        );
    }

    private void setupOrderView(Seat seat) {

        OrderView orderView = new OrderView();

        IOrder order = new Order(movie, session, seat);
        new OrderController(order, orderView).initController();

        hallView.getParentFrame().getContentPane().add(orderView);

        hallView.setVisible(false);
        orderView.setVisible(true);
    }

    private void setHallView() {

        HallSeats newSeats = new HallSeats();
        newSeats.setSeats(getSeats());
        hallView.setHall(newSeats);
    }

    private JButton[][] getSeats() {

        ProxyHall hall = GlobalTheatre.getTheatre().getHallById(session.getHallId());

        return convertProxySeats(hall.getSeats());
    }

    private JButton[][] convertProxySeats(Seat[][] proxySeats) {

        JButton[][] seats = new JButton[proxySeats.length][proxySeats[0].length];

        proxySeats[0][0].reserveSeat();

        for (int i = 0; i < proxySeats.length; i++) {
            for (int j = 0; j < proxySeats[i].length; j++) {

                JButton seat = new JButton(Integer.toString(j));

                seats[i][j] = initSeatProperties(proxySeats[i][j], seat, i, j);
            }
        }

        return seats;
    }

    private JButton initSeatProperties(Seat proxySeat, JButton seat, int row, int column) {

        if (proxySeat.isTaken())
            seat.setEnabled(false);
        else if (proxySeat instanceof LuxSeat) {
            seat.putClientProperty("seatType", SeatType.LUX);
            seat.putClientProperty("seatPrice", session.getLuxSeatPrice());
        } else {
            seat.putClientProperty("seatType", SeatType.GOOD);
            seat.putClientProperty("seatPrice", session.getGoodSeatsPrice());
        }

        seat.putClientProperty("row", row);
        seat.putClientProperty("column", column);
        seat.putClientProperty("price", proxySeat.getPrice());

        return seat;
    }

}