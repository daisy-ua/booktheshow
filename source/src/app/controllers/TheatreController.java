package app.controllers;

import app.models.theatre.GlobalTheatre;
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
        theatrePick.getParentFrame().getContentPane().remove(theatrePick);

        Theatre theatre = TheatreCreator.getLavinaMultiplex();
        GlobalTheatre.setTheatre(theatre);
        new MovieController(theatre.getAffiche(), pickView).initController();
        pickView.setVisible(true);
    }
}