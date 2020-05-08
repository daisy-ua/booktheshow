package app.models.theatre;

import app.models.order.IOrder;
import app.models.parser.MultiplexParser;

public class LavinaMultiplex extends Theatre {

    public LavinaMultiplex() {

        MultiplexParser.loadParser("lavina-affiche.json");
        initTheatre();
        MultiplexParser.uploadDataToDataBase(null);
    }

    private void initTheatre() {

        this.halls = MultiplexParser.parseHalls();
        this.movies = MultiplexParser.parseMovies();
    }

    @Override
    public void sendOrderData(IOrder order) {

        
    }
}