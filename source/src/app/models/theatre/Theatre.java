package app.models.theatre;

import app.models.hall.*;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.*;;

public abstract class Theatre {

    protected List<ProxyHall> halls; 
    protected JSONArray affiche;
    protected JSONObject database;
    protected String filePath;

    public void initTheatre() {

        this.database = readFile(this.filePath);
        initHalls();
    }

    private JSONObject readFile(String filePath) {

        JSONObject obj = null;

        try {
            String data = new String(Files.readAllBytes(Paths.get("source/src/app/data/lavina-affiche.json")));
            obj = new JSONObject(data);
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }


    private void initHalls() {

        this.halls = new ArrayList<ProxyHall>();
        
        JSONArray objects = this.database.getJSONArray("halls");

        objects.forEach(obj -> parseHallObject((JSONObject) obj));
    }

    private void parseHallObject(JSONObject hall) {

        int id = (int) hall.get("id");
        int row = (int) hall.get("rows");
        int column = (int) hall.get("columns");

        this.halls.add(new ProxyHall(id, row, column));
    }
}