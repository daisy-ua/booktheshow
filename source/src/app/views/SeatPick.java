package app.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SeatPick extends JPanel {

    private HallSeats hall;

    public SeatPick() {
        
        super();

        hall = new HallSeats();
        hall.setVisible(true);
    }

    public HallSeats getHall() {

        return hall;
    }

    public void setHall(HallSeats hall) {

        this.hall = hall;
        add(hall);
    }

    public JFrame getParentFrame() {

        return (JFrame) SwingUtilities.getRoot(this);
    }

}