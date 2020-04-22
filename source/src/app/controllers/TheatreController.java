package app.controllers;

import app.models.theatre.Theatre;
import app.models.theatre.TheatreCreator;
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
        //lavina
        theatrePick.setVisible(false);

        MoviePick pickView = new MoviePick();
        theatrePick.getParentFrame().getContentPane().add(pickView);

        Theatre theatre = TheatreCreator.getLavinaMultiplex();
        new MovieController(theatre.getAffiche(), pickView).initController();
        pickView.setVisible(true);
    }
}