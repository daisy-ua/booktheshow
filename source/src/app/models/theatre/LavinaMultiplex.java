package app.models.theatre;

import app.models.extraservice.snack.ColaSnackCreator;
import app.models.extraservice.snack.PopcornSnackCreator;
import app.models.order.IOrder;
import app.models.parser.MultiplexParser;

public class LavinaMultiplex extends Theatre {

    public LavinaMultiplex() {

        MultiplexParser.loadParser("lavina-affiche.json");
        initTheatre();
        initSnackPrices();
    }

    private void initTheatre() {

        this.halls = MultiplexParser.parseHalls();
        this.movies = MultiplexParser.parseMovies();
    }

    private void initSnackPrices() {

        PopcornSnackCreator.setPrices(MultiplexParser.parsePopcorn());
        ColaSnackCreator.setPrices(MultiplexParser.parseCola());
    }

    @Override
    public void sendOrderData(IOrder order) {

        MultiplexParser.uploadDataToDataBase(order);
    }
}