package pye.twenty.sbcore.config;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import pye.twenty.sbcore.SBCore;
import pye.twenty.sbessentials.config.Config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Getter
public class LocationConfig extends Config {

    private final Map<String, Location> locations = new HashMap<>();

    public LocationConfig() {
        super(SBCore.INSTANCE.getPlugin().getDataFolder() + File.separator + "world" + File.separator + "locations.yml");
        loadLocations();
    }

    private void loadLocations() {
        if (!config.contains("locations")) {
            return;
        }

        ConfigurationSection section = getConfig().getConfigurationSection("locations");
        for (String key : section.getKeys(false)) {
            locations.put(key, section.getLocation(key));
        }
    }

    private void saveLocations() {
        for (String key : locations.keySet()) {
            this.config.set("locations." + key, locations.get(key));
        }
        saveConfig();
    }

    public void addLocation(String name, Location location) {
        this.locations.put(name, location);
        saveLocations();
    }

}
