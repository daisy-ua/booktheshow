package app.models.order;

public interface  IOrder {

    public double getTotalPrice();
    public String getDescription();
    public String getMovieTitle();
    public String getMovieTime();
    public int getMovieDuration();
    public int getHallNumber();
    public int getSeatRow();
    public int getSeatColumn();
}