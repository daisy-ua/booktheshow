package app.models.affiche;

import java.util.*;

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

    public Movie addSessions(List<Session> sessions) {

        this.sessions = sessions;
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
}