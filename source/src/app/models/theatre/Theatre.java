package app.models.theatre;

import app.models.hall.*;
import app.models.order.IOrder;
import app.models.affiche.*;

import java.util.*;

public abstract class Theatre {

    protected List<ProxyHall> halls; 
    protected List<Movie> movies;

    public List<Movie> getAffiche() {

        return this.movies;
    }

    public List<ProxyHall> getHalls() {

        return this.halls;
    }

    public ProxyHall getHallById(int id) {

        return this.halls.get(id);
    }

    public abstract void sendOrderData(IOrder order);
}