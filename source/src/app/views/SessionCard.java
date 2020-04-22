package app.views;

import java.time.LocalTime;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SessionCard extends JPanel {

    protected JLabel movieTitle;
    protected JLabel movieImage;
    // protected List<LocalTime> sessions;
    protected Sessions sessions;

    public SessionCard() {

        super();
    }

    public SessionCard(JLabel title, JLabel image, Sessions sessions) {
        
        super();
        this.movieImage = image;
        this.movieTitle = title;
        this.sessions = sessions;

        add(movieTitle);
        add(movieImage);
        add(sessions);        
    }

    public JLabel getMovieTitle() {

        return movieTitle;
    }

    public void setMovieTitle(JLabel title) {

        this.movieTitle = title;
    }

    public JLabel getMovieImage() {

        return movieImage;
    }

    public void setMovieImage(JLabel image) {

        this.movieImage = image;
    }

    public Sessions getMovieSession() {

        return sessions;
    }

    public void setMovieSessions(Sessions sessions) {

        this.sessions = sessions;
    }
}