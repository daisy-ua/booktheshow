package app;

import app.models.affiche.Movie;
import app.models.theatre.*;
import app.models.seat.*;

public class Test {

    public static void firstLoad() {

        try {
            Theatre theatre = TheatreCreator.getLavinaMultiplex();

            Movie movie = theatre.getAffiche().get(0);
            System.out.println(movie.getTitle() + "\n" + movie.getSessionsTime());

            int hallId = movie.getSessionDetails(0).getHallId();

            Seat[][] seats = theatre.getHallById(hallId).getSeats();

            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {

                    System.out.print(seats[i][j].getPrice() + "    ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}