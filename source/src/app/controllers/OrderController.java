package app.controllers;

import app.models.order.IOrder;
import app.models.seat.SeatType;
import app.views.MainOrder;
import app.views.OrderView;

public class OrderController {

    private IOrder order;
    private OrderView orderView;

    public OrderController(IOrder order, OrderView orderView) {

        this.order = order;
        this.orderView = orderView;
    }

    public void initController() {

        setMainOrderView();
    }

    private void setMainOrderView() {

        MainOrder mainOrder = orderView.getMainOrder();
        
        mainOrder.getMovieTitle().setText(order.getMovieTitle());
        mainOrder.getSession().setText(order.getMovieTime());
        mainOrder.getHallId().setText(Integer.toString(order.getHallNumber()));
        mainOrder.getRow().setText(Integer.toString(order.getSeatRow()));
        mainOrder.getColumn().setText(Integer.toString(order.getSeatColumn()));
        mainOrder.getPrice().setText(Double.toString(order.getTotalPrice()));
        mainOrder.getSeatType().setText(order.getSeatType());
    }
}