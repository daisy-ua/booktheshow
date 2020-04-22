package app.controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

import app.models.affiche.Movie;
import app.views.MoviePick;
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

        return new Sessions(new JList(movie.getSessionsTime().toArray()));
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
}