package pye.twenty.sbcore.manager;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pye.twenty.sbcore.player.BoxPlayer;

import java.util.HashMap;
import java.util.UUID;

@Getter
public class PlayerManager {

    private final HashMap<UUID, BoxPlayer> players = new HashMap<>();

    public PlayerManager() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            players.put(player.getUniqueId(), new BoxPlayer(player));
        }
    }

}
