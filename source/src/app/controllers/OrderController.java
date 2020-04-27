package app.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import app.models.order.IOrder;
import app.views.MainOrder;
import app.views.OrderView;
import app.views.SnackOrder;

public class OrderController {

    private IOrder order;
    private OrderView orderView;

    public OrderController(IOrder order, OrderView orderView) {

        this.order = order;
        this.orderView = orderView;
    }

    public void initController() {

        setMainOrderView();
        setSnackOrderView();
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

    private void setSnackOrderView() {

        JLabel link = orderView.getSnackOrderLoadLink();
        link.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent m) {

                link.setText("Selects snacks:");
                orderView.setSnackOrder(new SnackOrder());
                initSnackOrderController();
            }
        });

    }

    private void initSnackOrderController() {

        new SnackController(orderView.getSnackOrder()).initController();
    }
}