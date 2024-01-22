package pye.twenty.sbcore.player;

import lombok.Getter;
import org.bukkit.entity.Player;
import pye.twenty.sbcore.player.rank.Rank;

import java.util.UUID;

@Getter
public class BoxPlayer {

    private final UUID uuid;
    private final Player player;
    private final PlayerConfig config;
    private final Rank rank;

    public BoxPlayer(Player player) {
        this.player = player;
        uuid = player.getUniqueId();
        config = new PlayerConfig(uuid);
        rank = applyRank();
    }

    private Rank applyRank() {
        if (player.hasPermission())
    }

}
