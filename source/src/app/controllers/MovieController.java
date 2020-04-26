package app.controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.models.affiche.Movie;
import app.models.theatre.GlobalTheatre;
import app.views.MoviePick;
import app.views.SeatPick;
import app.views.SessionCard;
import app.views.Sessions;

public class MovieController {

    private List<Movie> movies;
    private MoviePick pickView;

    public MovieController(List<Movie> movies, MoviePick pickView) {

        this.movies = movies;
        this.pickView = pickView;
    }

    public void initController() {

        initSessionCards();
    }

    private void initSessionCards() {

        List<SessionCard> cards = new ArrayList<SessionCard>();

        for (Movie movie : movies) {

            cards.add(new SessionCard(getMovieTime(movie), getImageIcon(movie), getSessionsTime(movie)));
        }

        pickView.setSessionCards(cards);
    }

    private JLabel getMovieTime(Movie movie) {

        return new JLabel(movie.getTitle());
    }

    private Sessions getSessionsTime(Movie movie) {

        Sessions sessions = new Sessions(new JList(movie.getSessionsTime().toArray()));
        initSessionsEvent(sessions, movie);
        return sessions;
    }

    private JLabel getImageIcon(Movie movie) {

        JLabel label = new JLabel();
        try {

            URL url = new URL(movie.getImagePath());
            BufferedImage image = ImageIO.read(url);

            label.setSize(195, 260);

            Image dImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(dImage);

            label.setIcon(img);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return label;
    }

    private void initSessionsEvent(Sessions sessions, Movie movie) {

        JList<String> list = sessions.getSessions();

        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {

                if (!arg0.getValueIsAdjusting()) {

                    SeatPick seatPick = new SeatPick();
                    pickView.getParentFrame().getContentPane().add(seatPick);

                    new SeatController(movie, movie.getSessionDetails(list.getSelectedIndex()), seatPick)
                            .initController();

                    pickView.setVisible(false);        
                    seatPick.setVisible(true);        
                }
            }
        });
    }
}