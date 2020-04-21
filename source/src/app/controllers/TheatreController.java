package app.controllers;

import app.views.MoviePick;
import app.views.TheatrePick;

public class TheatreController {

    private TheatrePick theatrePick;

    public TheatreController(TheatrePick theatrePick) {

        this.theatrePick = theatrePick;
    } 

    public void initController() {

        theatrePick.getLavinaMultiplex().addActionListener(e -> selectTheatre());
    }

    private void selectTheatre() {

        theatrePick.setVisible(false);

        MoviePick m = new MoviePick();
        theatrePick.getParentFrame().getContentPane().add(m);
        m.setVisible(true);
    }
}