package pye.twenty.sbcore.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pye.twenty.sbcore.player.BoxPlayer;
import pye.twenty.sbcore.player.PlayerConfig;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {

    private final HashMap<UUID, BoxPlayer> players = new HashMap<>();

    public PlayerManager() {
        for (Player player : Bukkit.getOnlinePlayers()) {

        }
    }

}
