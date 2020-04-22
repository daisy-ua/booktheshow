package app.views;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MoviePick extends JPanel {

    private List<SessionCard> cards;

    public MoviePick() {
        
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        cards = new ArrayList<SessionCard>();     
    }

    public void setSessionCards(List<SessionCard> cards) {

        this.cards = cards;
        for(SessionCard card : cards) {
            add(card);
        }
    }

    public List<SessionCard> getSessionCards() {

        return this.cards;
    }
}