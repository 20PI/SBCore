package pye.twenty.sbcore;

import org.bukkit.plugin.java.JavaPlugin;

public final class SBCorePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        SBCore.INSTANCE.initialize(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
