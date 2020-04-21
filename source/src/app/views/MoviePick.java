package app.views;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MoviePick extends JPanel {

    public MoviePick() {
        
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}