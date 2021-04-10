package io.github.anishthewizard.hardcoreminecraft;
import org.bukkit.entity.Player;

import org.json.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.*;

import java.util.HashMap;
import java.util.Iterator;

public class DataStorage {
    // store data into file
    private JSONObject holder = new JSONObject();
    private JSONObject world = new JSONObject();
    public HashMap<String, JSONObject> players = new HashMap<>();

    public void setup() {
        holder.put("i", Constants.worldNumber);

    }

    // resets all instance vars and appends to holder (the overall wrapper to all data)
    public void reset() {
        holder.put("world"+Constants.worldNumber, world);

        world = new JSONObject();
        players.clear();

        for (Player p :
             Constants.pList) {
            players.put(p.getName(), new JSONObject());
        }
        setup();
    }

    // exports to a file called HardcoreMinecraftData.json
    public void export() {
        FileWriter jsonFile = null;
        try {
            jsonFile = new FileWriter("/home/anishthewizard/JavaProjects/HardCoreMinecraft/src/main/data/HardcoreMinecraftData.json");
            jsonFile.write(holder.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                jsonFile.flush();
                jsonFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // loads the previous state before the server shutdown
    public void loadPreviousState() {
        // loads the entire json
        JSONParser p = new JSONParser();
        JSONObject j = null;
        // TODO what if there is no file existing at said dir
        try {
            j = (JSONObject) p.parse(new FileReader("/home/anishthewizard/JavaProjects/HardCoreMinecraft/src/main/data/HardcoreMinecraftData.json"));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        this.holder = j;

        // load the world data
        Constants.worldNumber = (int) holder.get("i");
        this.world = (JSONObject) holder.get("world"+Constants.worldNumber);
        // load the player data
        for (Object o : this.world.keySet()) {
            String pName = (String) o;
            players.put(pName, (JSONObject) world.get(pName));
        }
    }


}
