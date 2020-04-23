package app.views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SessionCard extends JPanel {

    protected JLabel movieTitle;
    protected JLabel movieImage;
    protected Sessions sessions;

    public SessionCard() {

        super();
    }

    public SessionCard(JLabel title, JLabel image, Sessions sessions) {
        
        super(null);
        this.movieImage = image;
        this.movieTitle = title;
        this.sessions = sessions;

        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 0, 10), new EtchedBorder()));

        add(movieImage);
        movieImage.setBounds(25, 25, 195, 260);
        add(movieTitle);
        movieTitle.setBounds(245, 20, 400, 35);
        add(sessions); 
        sessions.setLayout(new FlowLayout(FlowLayout.LEFT));   
        sessions.setBounds(240, 150, 200, 35);
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