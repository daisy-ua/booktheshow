package app.models.affiche;

import org.json.*;

import java.util.*;
import java.time.LocalTime;

public class Movie {

    private int id;
    private String title;
    private int duration;
    private String imagePath;
    private String description;
    private List<Session> sessions;

    public Movie(int id, String title, int duration, String description, String imagePath) {

        this.id = id;
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.imagePath = imagePath;
        this.sessions = new ArrayList<Session>();
    }

    public Movie addSessions(JSONArray sessions) {

        sessions.forEach(session -> parseSessionObject((JSONObject) session));
        return this;
    }

    public String getTitle() {

        return this.title;
    }

    public List<String> getSessionsTime() {

        List<String> timelines = new ArrayList<String>();

        this.sessions.forEach(session -> timelines.add(session.getTime().toString()));

        return timelines;
    }
    

    public int getId() {

        return this.id;
    }

    public int getDuration() {

        return this.duration;
    }

    public String getImagePath() {

        return this.imagePath;
    }

    public String getDescription() {

        return this.description;
    }

    public Session getSessionDetails(int sessionId) {

        return this.sessions.get(sessionId);
    }

    private void parseSessionObject(JSONObject session) {

        int id = (int) session.get("id");
        int hallId = (int) session.get("hall");
        double luxSeatPrice = (double) session.get("luxSeat");
        double goodSeatPrice = (double) session.get("goodSeat");
        String time = (String) session.get("time");

        this.sessions.add(new Session(id, hallId, luxSeatPrice, goodSeatPrice, time));

    }
}