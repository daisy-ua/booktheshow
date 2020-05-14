package app.models.parser;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import app.models.affiche.Movie;
import app.models.affiche.Session;
import app.models.hall.ProxyHall;
import app.models.order.IOrder;
import app.models.seat.SeatPosition;

public class MultiplexParser {

    protected static String filePath;
    private static JSONObject database;

    public static void loadParser(String fileName) {

        filePath = "source/src/app/data/" + fileName;
        database = loadDataBase();
    }

    public static List<ProxyHall> parseHalls() {

        List<ProxyHall> halls = new ArrayList<ProxyHall>();

        JSONArray hallObjects = database.getJSONArray("halls");

        hallObjects.forEach(obj -> halls.add(parseHallObject((JSONObject) obj)));

        return halls;
    }

    public static List<Movie> parseMovies() {

        List<Movie> movies = new ArrayList<Movie>();

        JSONArray movieObjects = database.getJSONArray("movies");

        movieObjects.forEach(obj -> movies.add(parseMovieObject((JSONObject) obj)));

        return movies;
    }

    public static void uploadDataToDataBase(IOrder order) {

        JSONObject node = new JSONObject();
        node.put("row", order.getSeatRow());
        node.put("column", order.getSeatColumn());

        database.getJSONArray("halls").getJSONObject(order.getHallNumber())
            .getJSONArray("takenSeats").put(node);
        uploadDataBase();
    }

    private static void uploadDataBase() {

        try {

            FileWriter file = new FileWriter(filePath);
            file.write(database.toString());
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject loadDataBase() {

        JSONObject obj = null;

        try {
            String data = new String(Files.readAllBytes(
                Paths.get(filePath)));
            obj = new JSONObject(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

    private static ProxyHall parseHallObject(JSONObject hall) {

        int id = (int) hall.get("id");
        int row = (int) hall.get("rows");
        int column = (int) hall.get("columns");

        Set<SeatPosition> takenSeatsSet = new HashSet<SeatPosition>();
        
        JSONArray takenSeats = hall.getJSONArray("takenSeats");
        takenSeats.forEach(obj -> parseTakenSeatObject(takenSeatsSet, (JSONObject)obj));

        return new ProxyHall(id, row, column).setTakenSeats(takenSeatsSet);
    }

    private static void parseTakenSeatObject(Set<SeatPosition> takenSeats, JSONObject seat) {

        int row = (int) seat.get("row");
        int column = (int) seat.get("column");
        takenSeats.add(new SeatPosition(row, column));
    }

    private static Movie parseMovieObject(JSONObject movie) {

        int id = (int) movie.get("id");
        String title = (String) movie.get("title");
        int duration = (int) movie.get("duration");
        String description = (String) movie.get("description");
        String imagePath = (String) movie.get("imagePath");

        JSONArray sessions = movie.getJSONArray("session");

        return new Movie(id, title, duration, description, imagePath)
            .addSessions(parseSessions(sessions));
    }

    private static List<Session> parseSessions(JSONArray sessionObjects) {

        List<Session> sessions = new ArrayList<Session>();

        sessionObjects.forEach(obj -> sessions.add(parseSessionObject((JSONObject) obj)));

        return sessions;
    }

    private static Session parseSessionObject(JSONObject session) {

        int id = (Integer) session.get("id");
        int hallId = (Integer) session.get("hall");
        double luxSeatPrice = ((Number) session.get("luxSeat")).doubleValue();
        double goodSeatPrice = ((Number) session.get("goodSeat")).doubleValue();
        String time = (String) session.get("time");

        return new Session(id, hallId, luxSeatPrice, goodSeatPrice, time);
    }
}