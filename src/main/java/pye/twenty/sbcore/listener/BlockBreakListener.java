package pye.twenty.sbcore.listener;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import pye.twenty.sbcore.SBCore;
import pye.twenty.sbcore.config.BlockConfig;
import pye.twenty.sbcore.util.RegionUtils;

public class BlockBreakListener implements Listener { // TODO: create custom event after everything checked

    @EventHandler
    private void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location location = block.getLocation();
        World world = location.getWorld();
        BlockConfig config = SBCore.INSTANCE.getConfigManager().get(BlockConfig.class);

        event.setCancelled(true);
        if (config.has(location)) {
            config.removeLocation(location);
            event.setCancelled(false);
        }

        if (RegionUtils.withinMine(location)) {
            event.setCancelled(false);
        }

    }



}
