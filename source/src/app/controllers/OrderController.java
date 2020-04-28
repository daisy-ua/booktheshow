package app.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import app.models.order.ExtraServiceFeature;
import app.models.order.IOrder;
import app.views.MainOrder;
import app.views.OrderView;
import app.views.PaymentView;
import app.views.SnackOrder;

public class OrderController {

    private IOrder order;
    private OrderView orderView;
    private SnackController snackController;

    public OrderController(IOrder order, OrderView orderView) {

        this.order = order;
        this.orderView = orderView;
    }

    public void initController() {

        setMainOrderView();
        setSnackOrderView();
        initContinueEvent();
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

        snackController = new SnackController(orderView.getSnackOrder(), order);
        snackController.initController();
    }

    private void initContinueEvent() {

        orderView.getNexButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                IOrder totalOrder = (snackController != null)
                        ? (snackController.getExtraService() != null)
                            ? new ExtraServiceFeature(order, snackController.getExtraService())
                            : order 
                        : order;    

                PaymentView paymentView = new PaymentView();

                orderView.getParentFrame().getContentPane().add(paymentView);
                paymentView.setVisible(true);
                orderView.setVisible(false);

                new PaymentController(totalOrder, paymentView).initController();

            }
        });
    }
}