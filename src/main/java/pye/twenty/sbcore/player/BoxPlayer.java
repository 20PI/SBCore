package pye.twenty.sbcore.player;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
public class BoxPlayer {

    private final UUID uuid;
    private final PlayerConfig config;

    public BoxPlayer(Player player) {
        uuid = player.getUniqueId();
        config = new PlayerConfig(uuid);
    }

}
