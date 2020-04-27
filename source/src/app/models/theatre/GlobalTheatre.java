package app.models.theatre;

public class GlobalTheatre {

    private static Theatre _theatre;

    public static Theatre getTheatre() {

        return _theatre;
    }

    public static void setTheatre(Theatre theatre) {

        _theatre = theatre;
    }

}