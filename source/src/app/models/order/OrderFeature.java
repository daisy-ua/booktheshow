package app.models.order;

public class OrderFeature implements IOrder{

    protected IOrder order;

    public OrderFeature(IOrder order) {

        this.order = order;
    }

    @Override 
    public String getDescription() {

        return order.getDescription();
    }

    @Override
    public double getTotalPrice() {

        return order.getTotalPrice();
    }

    @Override
    public String getMovieTitle() {

        return order.getMovieTitle();
    }

    @Override
    public String getMovieTime() {

        return order.getMovieTime();
    }

    @Override
    public int getHallNumber() {

        return order.getHallNumber();
    }

    @Override
    public int getSeatRow() {

        return order.getSeatRow();
    }

    @Override
    public int getSeatColumn() {

        return order.getSeatColumn();
    }

    @Override
    public int getMovieDuration() {

        return order.getMovieDuration();
    }
}