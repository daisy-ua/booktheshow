package app;

import java.awt.EventQueue;

import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;

import javax.swing.UIManager;

import app.views.BookTheShow;

public class App {
    public static void main(String[] args) throws Exception {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    UIManager.setLookAndFeel(new MaterialLookAndFeel(new JMarsDarkTheme()));
                    new BookTheShow().setVisible(true);
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
    }
}