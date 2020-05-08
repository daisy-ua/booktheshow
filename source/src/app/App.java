package app;

import java.awt.EventQueue;

import app.views.BookTheShow;

public class App {
    public static void main(String[] args) throws Exception {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new BookTheShow().setVisible(true);
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
    }
}