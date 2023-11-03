package pye.twenty.sbcore.player;

import pye.twenty.sbcore.SBCore;
import pye.twenty.sbessentials.config.Config;

import java.io.File;
import java.util.UUID;

public class PlayerConfig extends Config {


    public PlayerConfig(UUID uuid) {
        super(SBCore.INSTANCE.getPlugin().getDataFolder() + File.separator + "userinfo" + File.separator + uuid + File.separator + "info.yml");
    }

    public static PlayerConfig getConfig(UUID uuid) {
        return null;
    }

}
