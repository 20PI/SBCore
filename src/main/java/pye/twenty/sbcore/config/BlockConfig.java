package pye.twenty.sbcore.config;

import org.bukkit.Location;
import pye.twenty.sbcore.SBCore;
import pye.twenty.sbessentials.config.Config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BlockConfig extends Config { // TODO: Optimize, by maybe saving only on plugin disable

    private final List<Location> locations;
    public BlockConfig() {
        super(SBCore.INSTANCE.getPlugin().getDataFolder() + File.separator + "world" + File.separator + "blocks.yml");
        locations = (List<Location>) config.getList("locations", new ArrayList<>());
    }

    public void removeLocation(Location location) {
        locations.remove(location);
        saveLocations();
    }

    public void addLocation(Location location) {
        if (locations.contains(location)) {
            return;
        }
        locations.add(location);
        saveLocations();
    }

    public boolean has(Location location) {
        return this.locations.contains(location);
    }
    private void saveLocations() {
        config.set("locations", locations);
        saveConfig();
    }
}
