package app.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import app.models.seat.SeatType;

@SuppressWarnings("serial")
public class HallSeats extends JPanel {

    private JButton[][] seats;

    public HallSeats() {

        super(new GridBagLayout());
    }

    public JButton[][] getSeats() {

        return seats;
    }

    public void setSeats(JButton[][] seats) {

        this.seats = seats;
        addSeats();
    }

    private void addSeats() {

        int top = 3, left = 3, bottom = 3, right = 3;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = (new Insets(top, left, bottom, right));
        gbc.weightx = 1;
        gbc.weighty = 1;

        for(int i = 0; i < seats.length; i ++) {
            for(int j = 0; j < seats[i].length; j++) {

                if(seats[i][j].getClientProperty("seatType") == SeatType.LUX) {
                    seats[i][j].setBackground(Color.RED);
                } 
                else    
                    seats[i][j].setBackground(Color.BLUE);

                    add(seats[i][j], gbc);
                gbc.gridx++;
            }
            gbc.gridy++;
            gbc.gridx = 0;
        }
    }
}