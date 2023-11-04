package pye.twenty.sbcore.listener;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import pye.twenty.sbcore.SBCore;
import pye.twenty.sbcore.config.BlockConfig;
import pye.twenty.sbcore.util.RegionUtils;

public class BlockPlaceListener implements Listener {

    @EventHandler
    private void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location location = block.getLocation();
        World world = location.getWorld();
        BlockConfig config = SBCore.INSTANCE.getConfigManager().get(BlockConfig.class);
        event.setCancelled(true);

        RegionUtils.getRegion(world, "arena").ifPresentOrElse(r -> {
            if (RegionUtils.withinRegion(r, location)) {
                config.addLocation(location);
                event.setCancelled(false);
            }
        }, () -> {
            if (player.isOp()) {
                player.sendMessage("§cWARNING: You have not defined the region 'arena'!");
            }
        });
    }

}
