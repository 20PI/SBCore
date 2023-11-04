package pye.twenty.sbcore.util;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.Location;
import org.bukkit.World;
import pye.twenty.sbessentials.util.AreaUtils;
import pye.twenty.sbmines.SBMines;
import pye.twenty.sbmines.manager.MineManager;
import pye.twenty.sbmines.mine.Mine;

import java.util.Optional;

public final class RegionUtils {

    public static boolean withinMine(Location location) {
        MineManager mineManager = SBMines.INSTANCE.getMineManager();
        for (Mine mine : mineManager.getMineMap().values()) {
            if (AreaUtils.isWithinArea(location, mine.getMinLocation(), mine.getMaxLocation())) {
                return true;
            }
        }
        return false;
    }
    public static Optional<ProtectedRegion> getRegion(World world, String name) {
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regions = container.get(BukkitAdapter.adapt(world));
        if (regions != null) {
            return regions.getRegions().keySet().stream().filter(k -> k.equalsIgnoreCase(name)).findFirst().map(k -> regions.getRegions().get(k));
        }
        return Optional.empty();
    }

    public static boolean withinRegion(ProtectedRegion region, Location location) {
        return region.contains(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

}
