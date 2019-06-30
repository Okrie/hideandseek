package fr.momosced.hideandseek;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.*;

public class Arena implements ConfigurationSerializable {

    private Main plugin = Main.getInstance();

    private Location spawnLoc;
    private Location hunterLoc;
    private Location lobbyLoc;

    private List<UUID> players = new ArrayList<UUID>();

    public Arena() { }

    public Arena(Location spawnLoc, Location hunterLoc, Location lobbyLoc) {
        this.spawnLoc = spawnLoc;
        this.hunterLoc = hunterLoc;
        this.lobbyLoc = lobbyLoc;
    }

    public void setSpawnLocation(Location spawnLoc) {
        this.spawnLoc = spawnLoc;
    }

    public void setHunterLocation(Location hunterLoc) {
        this.hunterLoc = hunterLoc;
    }

    public void setLobbyLocation(Location lobbyLoc) {
        this.lobbyLoc = lobbyLoc;
    }

    public Location getSpawnLocation() {
        return this.spawnLoc;
    }

    public Location getHunterLocation() {
        return this.hunterLoc;
    }

    public Location getLobbyLocation() {
        return this.lobbyLoc;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> serialized = new HashMap<>();
        if (spawnLoc != null) serialized.put("spawnLoc", spawnLoc.serialize());
        if (hunterLoc != null) serialized.put("hunterLoc", hunterLoc.serialize());
        if (lobbyLoc != null) serialized.put("lobbyLoc", lobbyLoc.serialize());
        return serialized;
    }

    public static Arena deserialize(Map<String, Object> serialized)
    {
        Location spawnLoc = Location.deserialize((Map<String, Object>)serialized.get("spawnLoc"));
        Location hunterLoc = Location.deserialize((Map<String, Object>)serialized.get("hunterLoc"));
        Location lobbyLoc = Location.deserialize((Map<String, Object>)serialized.get("lobbyLoc"));

        return new Arena(spawnLoc, hunterLoc, lobbyLoc);
    }
}
